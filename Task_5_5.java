//Задание №5 (доп)
//
//Взять набор строк, например,Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.
//Написать метод, который отсортирует эти строки по длине с помощью TreeMap. Строки с одинаковой длиной не должны “потеряться”.

//Разобраться с TreeMap

import java.util.Comparator;
import java.util.TreeMap;

public class Task_5_5 {


    public static TreeMap<String, Integer> sortStrings(String str) {
        //    разбиваем строку на массив слов
        String[] strArr = str.split(" ", 0);
        // TreeMap с компаратором. Сначала сортируется по длине строки, если строки равны, то лексически (compareTo)
        TreeMap<String, Integer> sortedTreeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            // сравнивает два integer аргумента по правилу. возвращает integer (разница +, - или 0) в зависимости от значений аргументов
            public int compare(String o1, String o2) {
                int lengthDifference = o1.length() - o2.length();
                if (lengthDifference != 0) return lengthDifference;
                return o1.compareTo(o2);
            }
        });
        // записываем слова в TreeMap. там они сортируются согласно правилу, описаному выше в компараторе
        for (String word : strArr) {
            sortedTreeMap.put(word, word.length());
        }
        return sortedTreeMap;
    }

    public static void main(String[] args) {

        String str = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        TreeMap<String, Integer> sortedTreeMap = sortStrings(str);
        System.out.printf("Строка, сортированная с помощью TreeMap: %s\n", sortedTreeMap);

    }
}
