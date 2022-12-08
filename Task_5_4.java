//Задание №4. Написать метод, который переведёт данное целое число в римский формат.


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_5_4 {


    // если надо переводить из int, то сначала int надо сконвертировать в String -> String ИМЯ = Integer.toString(arNumber);
    public static String ArabianToRome(String arNumber) {
        // сотни
        Map<String, String> hundreds = new HashMap<>();
        hundreds.put("0", "");
        hundreds.put("1", "C");
        hundreds.put("2", "CC");
        hundreds.put("3", "CCC");
        hundreds.put("4", "CD");
        hundreds.put("5", "D");
        hundreds.put("6", "DC");
        hundreds.put("7", "DCC");
        hundreds.put("8", "DCCC");
        hundreds.put("9", "CM");
        // десятки
        Map<String, String> tens = new HashMap<>();
        tens.put("0", "");
        tens.put("1", "X");
        tens.put("2", "XX");
        tens.put("3", "XXX");
        tens.put("4", "XL");
        tens.put("5", "L");
        tens.put("6", "LX");
        tens.put("7", "LXX");
        tens.put("8", "LXXX");
        tens.put("9", "XC");
        // единицы
        Map<String, String> ones = new HashMap<>();
        ones.put("0", "");
        ones.put("1", "I");
        ones.put("2", "II");
        ones.put("3", "III");
        ones.put("4", "IV");
        ones.put("5", "V");
        ones.put("6", "VI");
        ones.put("7", "VII");
        ones.put("8", "VIII");
        ones.put("9", "IX");

// дописываем нулями старшие разряды
        while (arNumber.length() < 4) {
            arNumber = "0" + arNumber;
        }
        String romNumber = "";
        // разбиваем на символы
        String[] arSymbols = arNumber.split("");
        // поразрядно собираем римское число
        for (int i = arSymbols.length - 1; i >= 0; i--) {
            switch (i) {
                case 0: {
                    for (int j = 0; j < Integer.parseInt(arSymbols[i]); j++) {
                        romNumber = "M" + romNumber;
                    }
                    break;
                }
                case 1: {
                    romNumber = hundreds.get(arSymbols[i]) + romNumber;
                    break;
                }
                case 2: {
                    romNumber = tens.get(arSymbols[i]) + romNumber;
                    break;
                }
                case 3: {
                    romNumber = ones.get(arSymbols[i]) + romNumber;
                    break;
                }
                default:
                    break;
            }
        }
        return romNumber;
    }

    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите целое число в арабском формате записи (от 1 до 3999) : ");
        String arNumber = iScanner.nextLine();
        iScanner.close();
        if ((Integer.parseInt(arNumber) < 1) | (Integer.parseInt(arNumber) > 3999)) {
            System.out.println("Не корректное значение!");
        } else {
            System.out.printf("Арабское число %s соответствует римскому числу %s\n", arNumber, ArabianToRome(arNumber));
        }
    }

}
