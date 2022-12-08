//ДЗ 4*. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
//https://habr.com/ru/post/343738/

public class SolutionHW_5_4 {
    // печать шахматной доски
    public static void printChessBoard(String[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                System.out.printf(" %s", chessBoard[i][j]);
            }
            System.out.println();
        }
    }

    // заполнение шахматной доски знаками "-"
    public static String[][] fillChessBoard(int rows, int columns) {
        String[][] chessBoard = new String[rows][columns];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                chessBoard[i][j] = "-";
            }
        }
        return chessBoard;
    }

    //    ставит ферзя "Ф" и помечает клетки шахматного поля, которые он "простреливает" знаком "+"
    public static String[][] setQueen(String[][] chessBoard, int row, int col) {
        chessBoard[row][col] = "Ф";
        int i = row;
        int j = col;
// горизонталь
        while (i < chessBoard.length) {
            chessBoard[i][j] = "+";
            i++;
        }
        i = row;
        while (i >= 0) {
            chessBoard[i][j] = "+";
            i--;
        }
        i = row;
// вертикаль
        while (j < chessBoard[0].length) {
            chessBoard[i][j] = "+";
            j++;
        }
        j = col;
        while (j >= 0) {
            chessBoard[i][j] = "+";
            j--;
        }
        j = col;
// 1-я диагональ
        while ((i < chessBoard.length) & (j < chessBoard[0].length)) {
            chessBoard[i][j] = "+";
            i++;
            j++;
        }
        i = row;
        j = col;
        while ((i >= 0) & (j >= 0)) {
            chessBoard[i][j] = "+";
            i--;
            j--;
        }
        i = row;
        j = col;
// 2-я диагональ
        while ((i < chessBoard.length) & (j >= 0)) {
            chessBoard[i][j] = "+";
            i++;
            j--;
        }
        i = row;
        j = col;
        while ((i >= 0) & (j < chessBoard[0].length)) {
            chessBoard[i][j] = "+";
            i--;
            j++;
        }
        chessBoard[row][col] = "Ф";

        return chessBoard;
    }


    public static void main(String[] args) {

// Число строк
        int rows = 8;
// Число столбцов
        int columns = 8;
// Стартовая позиция расстановки
        int pos = 0;

// Разные варианты старта начала расстановки ферзей (от 0,0 до rows-1, columns-1)
        for (int i = 0; i < rows * columns; i++) {
            int count = 0;
            pos = i;
//            очищаем шахматную доску
            String[][] chessBoard = fillChessBoard(rows, columns);
//            Перебор всех вариантов
            for (int attempt = 0; attempt < rows * columns; attempt++) {
                int row = pos / columns;
                int column = pos % columns;
//                Если клетка не "простреливается", то ставим на ней ферзя и считаем его
                if (chessBoard[row][column] == "-") {
                    setQueen(chessBoard, row, column);
                    count++;
                }
                pos++;
                if (pos == rows * columns) pos = 0;
            }
            if (count > 7) {
                System.out.printf("Вариант %s, количество 'мирных' ферзей %s\n", pos, count);
                printChessBoard(chessBoard);
                System.out.println();
            }
        }
    }
}
