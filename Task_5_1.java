// Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
//123456 Иванов
//321456 Васильев
//234561 Петрова
//234432 Иванов
//654321 Петрова
//345678 Иванов
//Вывести данные по сотрудникам с фамилией Иванов.

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Task_5_1 {
    public static void main(String[] args) {


        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(111, "Иванов");
        db.putIfAbsent(222, "Петров");
        db.putIfAbsent(333, "Иванов");

        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Кого ищем ? ");
        String str = iScanner.nextLine();
        iScanner.close();

        for (Integer numPass : db.keySet()) {
            if (Objects.equals(db.get(numPass).toLowerCase(), str.toLowerCase())) {
                System.out.printf("Паспорт %d фамилия %s\n", numPass, db.get(numPass));
            }
        }

    }
}
