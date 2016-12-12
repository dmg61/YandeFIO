package ru.test.yandex;

/**
 * Created by ������� ������� on 18.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        YandexFio invoker = new YandexFio();

        if (args.length != 1) {
            System.out.println("Неверное количество аргументов");
            return;
        }

        String result = null;
        try {
            result = invoker.main(args[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n############## RESPONSE ######################");
        System.out.println(result);
    }
}
