package ru.test.api.Externalsystems;


import ru.test.api.Helpers.StringHelper;
import ru.test.api.exceptions.AxiLinkException;

import java.util.Map;

/**
 * Created by tikhonin on 23.12.2015.
 */
public abstract class AbstractExternalSystem {
    protected String connectionString;
    private Map<String, String> connectionStringParams;

    public AbstractExternalSystem(String connectionString) {
        this.connectionString = connectionString;
    }

    /**
     * Получение строки настроек подключения ко внешней системе
     * @return строка настроек подключения ко внешней системе
     */
    public String getConnectionString() {
        return connectionString;
    }

    /**
     * Получение параметров подключения ко внешней системе
     * @return Параметры подключения ко внешней системе
     * @throws AxiLinkException
     */
    public Map<String, String> getConnectionParams() throws AxiLinkException {
        if(connectionStringParams == null ) {
            try {
                connectionStringParams = StringHelper.splitParamsStringToMap(connectionString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return connectionStringParams;
    }
}
