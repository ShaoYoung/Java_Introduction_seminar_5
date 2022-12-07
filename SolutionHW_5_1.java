// ДЗ 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionHW_5_1 {

    //    добавление информации в телефонную книгу
    public static Map<String, String> addPB(Map<String, String> db, String record) {
        String[] abonent = record.split(" ", 0);
        db.putIfAbsent(abonent[1], abonent[0]);
        return db;
    }

    // удаление информации из телефонной книги
    public static Map<String, String> delPB(Map<String, String> db, String surname) {
        Map<String, String> db_new = new HashMap<>();
        for (String phone : db.keySet()) {
            if (!db.get(phone).toLowerCase().equals(surname)) {
                db_new.putIfAbsent(phone, db.get(phone));
            }
            // или можно через итератор
        }
        return db_new;
    }

    // поиск информации в телефонной книге
    public static ArrayList<String> findPB(Map<String, String> db, String surname) {
        ArrayList<String> findedPhones = new ArrayList<>();
        for (String phone : db.keySet()) {
            if (db.get(phone).toLowerCase().equals(surname)) {
                // if (abon.toLowerCase().equals(surname.toLowerCase())){
                findedPhones.add(phone);
            }
        }
        return findedPhones;
    }


    // печать всей телефонной книги
    public static void printPB(Map<String, String> db) {
        System.out.println("Телефонная книга: ");
        for (String phone : db.keySet()) {
            System.out.printf("Фамилия %s телефон %s\n", db.get(phone), phone);
        }
    }

    public static void main(String[] args) {

// HashMap телефон, фамилия
        Map<String, String> db = new HashMap<>();
        String record;
        String action;
        Scanner iScanner = new Scanner(System.in);
        boolean repeat = true;

        while (repeat) {
            System.out.print("Введите действие (1 - просмотр всего справочника, 2 - добавление записи, 3 - поиск информации, 4 - удаление информации, Enter - завершение работы, ) : ");
            action = iScanner.nextLine();
            switch (action) {
                case "" -> repeat = false;
                case "1" -> printPB(db);
                case "2" -> {
                    System.out.print("Введите абонента в формате Фамилия Пробел Телефон ");
                    record = iScanner.nextLine();
                    db = addPB(db, record);
                }
                case "3" -> {
                    // поиск информации
                    System.out.print("Введите фамилию абонента ");
                    record = iScanner.nextLine();
                    // список найденных телефонов
                    ArrayList<String> findedPhones = findPB(db, record);
                    System.out.printf("Телефоны абонента %s :\n", record);
                    System.out.println(findedPhones);
                }
                case "4" -> {
                    // удаление информации
                    System.out.print("Введите фамилию абонента ");
                    record = iScanner.nextLine();
                    db = delPB(db, record);
                }
                default -> System.out.println("Не корректный ввод!");
            }
        }
        iScanner.close();
    }
}
