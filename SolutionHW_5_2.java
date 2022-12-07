// ДЗ 2. Пусть дан список сотрудников: Иван Иванов (и остальные, полный текст дз будет на платформе)
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности. LinkedHashMap.

import java.util.*;

public class SolutionHW_5_2 {
    public static void main(String[] args) {

        Map<String, Integer> db = new HashMap<>();
//        Количество повторений
        int count = 0;
//        Строка с исходными ИФ
        String peoples = "Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
//          разбиваем
        String[] persons = peoples.split(", ");
//        System.out.println(Arrays.toString(persons));
//        считаем и записываем в HashMap количество повторений
        for (String person : persons) {
            String[] NandS = person.split(" ");
            if (db.containsKey(NandS[0])) {
                count = db.get(NandS[0]) + 1;
                db.put(NandS[0], count);
            } else {
                db.put(NandS[0], 1);
            }
        }
        System.out.printf("Имена и количество повторов %s \n", db);
        //        Список повторений
        ArrayList<Integer> numOfRepeat = new ArrayList<>();
//        LinkedHashMap для записи по убыванию популярности
        Map<String, Integer> dbSorted = new LinkedHashMap<>();
//        сохраняем все повторения имён в список
        for (String name : db.keySet()) {
            numOfRepeat.add(db.get(name));
        }
//        System.out.println(numOfRepeat);
//      Сортируем список повторений в обратном порядке
        numOfRepeat.sort(Collections.reverseOrder());
//        System.out.println(numOfRepeat);
//        Записываем LinkedHashMap в соответствии с количеством повторений имён
        for (Integer num : numOfRepeat) {
            for (String name : db.keySet()) {
                if (db.get(name) == num) {
                    dbSorted.put(name, db.get(name));
                }
            }
        }
        System.out.printf("Имена в порядке убывания популярности %s\n", dbSorted);
    }
}
