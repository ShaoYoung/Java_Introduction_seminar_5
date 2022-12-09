//ДЗ 3*. Реализовать алгоритм пирамидальной сортировки (HeapSort).

//Разобраться с алгоритмом HeapSort

import java.util.Arrays;

public class SolutionHW_5_3 {


    //  Основной алгоритм сортировки кучей
    public static int[] HeapSort(int[] data) {
//  Формируем первоначальное сортирующее дерево
//  Для этого справа-налево перебираем элементы массива (у которых есть потомки) и делаем для каждого из них просейку
        for (int start = (data.length - 2) / 2; start >= 0; start--) {
            HeapSift(data, start, data.length - 1);
        }
        System.out.printf("Первоначальное сортирующее дерево %s\n", Arrays.toString(data));

// Первый элемент массива всегда соответствует корню сортирующего дерева и поэтому является максимумом для неотсортированной части массива.
        for (int end = data.length - 1; end > 0; end--) {
            //  Меняем этот максимум местами с последним элементом неотсортированной части массива
            int temp = data[end];
            data[end] = data[0];
            data[0] = temp;
            // После обмена в корне сортирующего дерева немаксимальный элемент
            //  Восстанавливаем сортирующее дерево (просейка для неотсортированной части массива)
            HeapSift(data, 0, end - 1);
            System.out.printf("Массив после подъёма очередного максимума в конец масива %s\n", Arrays.toString(data));
        }
        return data;
    }


    //  Просейка свеху вниз, в результате которой восстанавливается сортирующее дерево. изменяется массив - аргумент
    public static void HeapSift(int[] data, int start, int end) {
// Начало подмассива - узел, с которого начинаем просейку вниз
        int root = start;
//  Цикл просейки продолжается до тех пор, пока встречаются потомки, большие чем их родитель
        while (true) {
// Левый потомок
            int child = root * 2 + 1;
// Если левый потомок за пределами подмассива - завершаем просейку
            if (child > end) {
                break;
            }
//  Если правый потомок тоже в пределах подмассива, то среди обоих потомков выбираем наибольший
            if (((child + 1) <= end) && (data[child] < (data[child + 1]))) {
                child++;
            }
//  Если больший потомок больше корня, то меняем местами, при этом больший потомок сам становится корнем, от которого дальше опускаемся вниз по дереву
            if (data[root] < data[child]) {
                int temp = data[root];
                data[root] = data[child];
                data[child] = temp;
                root = child;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {

        int[] data = new int[]{3, 1, 5, 2, 9, 4};
        System.out.printf("Первоначальный массив %s\n", Arrays.toString(data));
        data = HeapSort(data);
        System.out.printf("Heap-sorted массив %s\n", Arrays.toString(data));


    }
}
