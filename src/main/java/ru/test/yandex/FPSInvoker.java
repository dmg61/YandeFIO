package ru.test.yandex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.test.api.Externalsystems.AbstractExternalSystem;
import ru.test.api.Helpers.StringHelper;
import ru.test.api.Helpers.XMLHelper;
import ru.test.api.exceptions.*;
import ru.test.yandex.soap.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Дмитрий Астахов on 15.12.2016.
 */
public class FPSInvoker extends AbstractExternalSystem{
    private Logger log = LoggerFactory.getLogger(getClass());
    private long sleepTime = 6000;
    private int maxRetryCount = 10;

    public FPSInvoker() {
        super("");
        this.connectionString = "login=domadengionline_webuser;password=o1lsnBl3J2;partnerid=DDO;ip=10.130.11.77";
    }

    public String main(String input) throws Exception {
        log.info("(FPS)Вызов сервиса FPS");

        String dateTimeRequest = getCurrentDate("dd.MM.yyyy HH:mm:ss");

        // Инциализация параметров запроса
        FPSPartnerServiceStub fps;
        NewApplication request;
        try {
            fps = new FPSPartnerServiceStub("http://" + this.getConnectionParams().get("ip") + "/soap/bank");
            request = createRequestCreditHistory(input, dateTimeRequest);
        } catch (IOException | SAXException | ParserConfigurationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new ExternalSystemException("(FPS)Ошибка формирования запроса \"Кредитная история\" к сервису FPS", e);
        }
        System.out.println(request.toString());
        // Запрос "Кредитная история"
        NewApplicationResponse response;
        try {
            response = fps.newApplication(request);
        } catch (RemoteException e) {
            throw new ExternalSystemIOException("(FPS)Сетевая ошибка отправки запроса \"Кредитная история\" к сервису FPS: " + e.getMessage(), e);
        }

        if (!response.getStatus().equals("0")) {
            throw new ExternalSystemException("(FPS)Ошибка ответа \"Кредитная история\" от сервиса FPS, код ошибки: " + response.getStatus().toString());
        }

        // Уникальный Id заявки
        String applicationid = response.getApplicationid();

        log.info("(FPS)Метод newApplication выполнен: applicationId={}, status={}, dateTimeRequest={}", applicationid, response.getStatus(), dateTimeRequest);

        // Создание запроса "Выходной вектор"
        OutputVector outputVector = createRequestOutputVector(applicationid, dateTimeRequest);

        // Запрос "Выходной вектор"
        OutputVectorResponse responseOutputVector = null;
        int countRequest = 0;

        while(countRequest < maxRetryCount) {

            try {
                log.debug("Ждем {}мс", sleepTime);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new ExternalSystemException("(FPS)Ошибка ожидания ответа на запрос \"Выходной вектор\" сервиса FPS: " + e.getMessage(), e);
            }

            try {
                responseOutputVector = fps.outputVector(outputVector);
                if (!responseOutputVector.getStatus().equals("0")) { // Ответ не успел сформироваться
                    countRequest++;
                    continue;
                }
            } catch (RemoteException e) {
                throw new ExternalSystemIOException("(FPS)Сетевая ошибка отправки запроса \"Выходной вектор\" к сервису FPS: " + e.getMessage(), e);
            }

            break;
        }

        if (countRequest >= maxRetryCount) {
            throw new ExternalSystemException("(FPS)Превышен лимит ожидания ответа на запрос \"Выходной вектор\" сервиса FPS");
        }

        String responseXML = null;
        try {
            responseXML = parseResponseOutputVector(responseOutputVector);
        } catch (Exception e) {
            throw new ExternalSystemException("(FPS)Ошибка разбора ответа \"Выходной вектор\" от сервиса FPS", e);
        }

        return responseXML;
    }

    public NewApplication createRequestCreditHistory(String inputXML, String dateTimeRequest) throws Exception {
        NewApplication request = new NewApplication();
        Document doc = XMLHelper.parseXml(inputXML);
        // Формирования массива из методов класса NewApplication
        Method[] methodArr = NewApplication.class.getMethods();
        Map<String, Method> methods = new HashMap<String, Method>();
        for(Method m : methodArr) {
            methods.put(m.getName(), m);
        }

        Node node = null; // Обрабатываемый узел
        Method method = null; // Метод set'ClassName' класса NewApplication
        String methodName = null; // Название метода, пример: setDateType
        Object objParam = null; // Объект класса параметров
        Class classParam = null; // Название устанавливаемого класса параметра
        Method methodParams = null; // Метод установки параметров класса
        NodeList nodeList = doc.getDocumentElement().getChildNodes(); // Список эелементов в теге response

        for (int i = 0; i < nodeList.getLength(); ++i) {
            node = nodeList.item(i);

            // Не зполняем если значение в поле отсутствует
            if (StringHelper.isNullOrEmpty(node.getTextContent())) {
                continue;
            }

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                methodName = "set" + setStartWithUpperCase(node.getNodeName());

                if (methodName.contains("_")) {
                    int index = methodName.indexOf("_");
                    methodName = methodName.substring(0, index) + setStartWithUpperCase(methodName.substring(index + 1));
                }

                method = methods.get(methodName);

                objParam = node.getTextContent();

                if (objParam == null) {
                    objParam = "";
                }

                method.invoke(request, objParam);
            }
        }

        request.setLogin(this.getConnectionParams().get("login"));
        request.setPassword(this.getConnectionParams().get("password"));
        request.setPartnerid(this.getConnectionParams().get("partnerid"));
        request.setApplicationid(String.valueOf(randInt()));
        request.setApplicationdate(dateTimeRequest);

        return request;
    }

    public OutputVector createRequestOutputVector(String applicationid, String dateTimeRequest) throws Exception {
        OutputVector outputVector = new OutputVector();

        outputVector.setLogin(this.getConnectionParams().get("login"));
        outputVector.setPassword(this.getConnectionParams().get("password"));
        outputVector.setPartnerid(this.getConnectionParams().get("partnerid"));
        outputVector.setApplicationid(applicationid);
        outputVector.setApplicanttype("1");
        outputVector.setApplicationdate(dateTimeRequest);
        outputVector.setApplicanttypenum("1");

        return outputVector;
    }

    public String parseResponseOutputVector(OutputVectorResponse response) throws Exception {
        Document doc = null;

        Map<String, String> params = new HashMap<String, String>();
        params.put("applicationid", response.getApplicationid());
        params.put("status", response.getStatus());
        params.put("mainrules", response.getMainrules());
        params.put("mainscorevalue", response.getMainscorevalue());
        params.put("specificrules", response.getSpecificrules());
        params.put("applicationsfound", response.getApplicationsfound());

        doc = XMLHelper.generateXmlFromParams(params, "outputVectorResponse");

        return XMLHelper.convertToString(doc);
    }

    /**
     * Преобразование строки, чтобы она начиналась с заглавной буквы
     * @param input Стррока в нижнем регистре
     * @return Строка, первая буква которой в верхнем регистре
     */
    public String setStartWithUpperCase(String input) {
        return Character.toUpperCase(input.charAt(0)) + input.substring(1);
    }

    /**
     * Получение названия класса из полного пути
     * @param input Полный путь к классу: ru.example.example1.className
     * @return Название класса: className
     */
    public String getClassName(String input) {
        return input.substring(input.lastIndexOf(".") + 1);
    }

    /**
     * Установка значения класса соответствующего значению input
     * @param srcClass Класс, в котором присутствуют встроенные инициализаторы
     * @param input Устанавливаемое значение
     * @return Значение класса
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object getValue(Class srcClass, String input) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] fields = srcClass.getFields();
        Object object = null;
        Method method = null;
        String result;

        for(Field f : fields) {
            if (!f.getName().startsWith("value")) {
                continue;
            }

            object = f.get(new Object());
            method = object.getClass().getMethod("getValue");
            result = (String)method.invoke(object);

            if (result.equals(input)) {
                return object;
            }
        }

        return null;
    }

    public static String getCurrentDate(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();

        return dateFormat.format(date);
    }

    public static int randInt() {
        Random rand = new Random();
        int randomNum = rand.nextInt();

        return randomNum < 0 ? -randomNum : randomNum;
    }
}
