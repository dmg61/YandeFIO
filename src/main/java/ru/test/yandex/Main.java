package ru.test.yandex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ������� ������� on 18.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        YandexId invoker = new YandexId();

        if (args.length != 1) {
            System.out.println("Неверное количество аргументов");
            return;
        }

//        BufferedReader br = null;
        String everything = null;
//        try {
//            br = new BufferedReader(new FileReader(args[0]));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//            everything = sb.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        everything = args[0];

        System.out.println("\n############## REQUEST ######################");
        System.out.println(everything);

        String result = null;
        try {
            result = invoker.main(everything);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n############## RESPONSE ######################");
        System.out.println(result);
    }
}
