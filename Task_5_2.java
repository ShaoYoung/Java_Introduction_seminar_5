//Написать программу, определяющую правильность расстановки скобок в выражении.
//Пример 1: a+(d*3) - истина
//Пример 2: [a+(1*3) - ложь
//Пример 3: [6+(3*3)] - истина
//Пример 4: {a}[+]{(d*3)} - истина
//Пример 5: <{a}+{(d*3)}> - истина
//Пример 6: {a+]}{(d*3)} - ложь

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_5_2 {
    public static void main(String[] args) {

//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("Введите выражение ");
//        String str = iScanner.nextLine();
//        iScanner.close();
        String str = "a+(d*3])-[d+c]";
        String[] ch = str.split("");
        System.out.println(Arrays.toString(ch));

        Map<String, Integer> db = new HashMap<>();
        db.put("(", 0);
        db.put(")", 0);
        db.put("[", 0);
        db.put("]", 0);

        Map<String, Boolean> flag = new HashMap<>();
        flag.put("(", false);
//        flag.put(")", false);
        flag.put("[", false);
//        flag.put("]", false);


//{} () [] <>
        boolean fl = false;
        int count = 0;
        for (String sym : ch) {
            if (((flag.get("(") & (sym.equals(")"))) | ((flag.get("[") & (sym.equals("]")))))) {
                db.put("(", -1);
                break;
            }
            if (sym.equals("(")) {
                count = db.get("(");
                db.put("(", ++count);
//                поднять флаг (
                flag.put("(", true);
                fl = true;
                System.out.printf("( %s \n", db.get("("));

            } else if (sym.equals(")")) {
                System.out.printf("fl %s\n", fl);
                System.out.printf("flag %s\n", flag.get("("));
                if (fl) {
                    if (flag.get("(")) {
                        count = db.get(")");
                        db.put(")", ++count);
                        flag.put(")", false);
                        fl = false;
                    }
                }
//                count = db.get(")");
//                db.put(")", ++count);
//                опустить флаг )
                System.out.printf("( %s \n", db.get("("));
            }

            if (sym.equals("[")) {
                count = db.get("[");
                db.put("[", ++count);
//                поднять флаг (
                flag.put("[", true);
                fl = true;
                System.out.printf("[ %s \n", db.get("["));

            } else if (sym.equals("]")) {
                System.out.printf("fl %s\n", fl);
                System.out.printf("flag %s\n", flag.get("["));
                if (fl) {
                    if (flag.get("[")) {
                        count = db.get("]");
                        db.put("]", ++count);
                        flag.put("[", false);
                        fl = false;
                    }
                }
//                count = db.get(")");
//                db.put(")", ++count);
//                опустить флаг )
                System.out.printf("[ %s \n", db.get("["));
            }
        }
        if ((db.get("(") == db.get(")")) & (db.get("[") == db.get("]"))) {
            System.out.println("True");
        } else System.out.println("False");
    }
}

