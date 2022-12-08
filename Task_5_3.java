//Задание №3. Написать метод, который переведет число из римского формата записи в арабский.
//Например, MMXXII = 2022
//http://graecolatini.bsu.by/htm-different/num-converter-roman.htm

//Алгоритм перевода (Turbo Pascal)
//https://www.cyberforum.ru/pascal/thread66998.html


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_5_3 {

    public static int RomeToArabian(String romeNumber) {
        Map<String, Integer> ra = new HashMap<>();
        ra.put("I", 1);
        ra.put("V", 5);
        ra.put("X", 10);
        ra.put("L", 50);
        ra.put("C", 100);
        ra.put("D", 500);
        ra.put("M", 1000);
        // String romeNumber = "XC";
        // предыдущее число
        int prev = 0;
        // текущее число
        int curr = 0;
        // арабское число
        int arNumber = 0;
        // для корректировки
        int temp = 0;
        // разбиваем на символы
        String[] romeSymbols = romeNumber.split("");
        for (String romSym : romeSymbols) {
            prev = curr;
            curr = ra.get(romSym);
            // если предыдущий символ римского числа был меньше текущего, вносим корректировку
            if (curr > prev) {
                temp = -2 * prev;
            } else temp = 0;
            arNumber = arNumber + temp + curr;
        }
        return arNumber;
    }

    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите число в римском формате записи : ");
        String romeNumber = iScanner.nextLine();
        iScanner.close();

        try {
            System.out.printf("Римское число %s соответствует арабскому числу %d\n", romeNumber, RomeToArabian(romeNumber));
        } catch (Exception e) {
            System.out.println("Не корректная запись числа в римском формате!");
        }
    }

}
