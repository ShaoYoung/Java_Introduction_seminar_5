//Задание №6 (доп)
//Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго один раз.
// Вывести двумерный массив с последовательностью ходов


public class Task_5_6 {

    //    размерность доски
    public static int n = 8;
    //    шахматная доска - глобальная переменная
    public static int[][] chessBoard = new int[n][n];
    //    количество ходов коня в попытке - глобальная переменная
    public static int count = 1;

    public static void printChessBoard() {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                if (chessBoard[i][j] < 10) {
                    System.out.printf("  %s", chessBoard[i][j]);
                } else {
                    System.out.printf(" %s", chessBoard[i][j]);
                }
            }
            System.out.println();
        }
    }


    public static void clearChessBoard() {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                chessBoard[i][j] = 0;
            }
        }
    }


    //    следующий ход коня
    public static int[] nextMove(int row, int col) {
        int[] coord = new int[2];
//        варианты смещения текущей координаты коня
        int[] dx = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
// рандомное начало следующего хода коня
        int j = (int) (Math.random() * 8);
//        System.out.println(j);
        for (int i = 0; i < dx.length; i++) {
            j++;
            if (j > 7) j = 0;
//            System.out.println(j);
//            System.out.printf("Ход %s, row %s, col %s\n", count + 1, row + dx[j], col + dy[j]);
//            проверка на границы шахматного поля
            if ((row + dx[j] < chessBoard.length) & (row + dx[j] >= 0) & (col + dy[j] < chessBoard[0].length) & (col + dy[j] >= 0)) {
//                если поле свободно, то ходим туда
                if (chessBoard[row + dx[j]][col + dy[j]] == 0) {
                    count++;
                    chessBoard[row + dx[j]][col + dy[j]] = count;
                    coord[0] = row + dx[j];
                    coord[1] = col + dy[j];
//                    printChessBoard();
                    return coord;
//                    nextMove(coord[0],coord[1]);
                }
            }
        }
//        конь зашёл в тупик
        coord[0] = -1;
        coord[1] = -1;
        return coord;
    }


    public static void main(String[] args) {
// стартовая позиция коня
        int startPos = n / 2;
// скачем, пока не проскачем все поле
        while (count < n * n) {
            clearChessBoard();
            count = 1;
            chessBoard[startPos][startPos] = 1;
            int[] coord = new int[]{startPos, startPos};
            boolean result;

            for (int i = 0; i < n * n; i++) {
                coord = nextMove(coord[0], coord[1]);
                if (coord[0] == -1) {
                    System.out.printf("Конь зашёл в тупик на %s попытке\n", count);
                    break;
                } else if (count == n * n) {
                    System.out.println("Конь проскакал всё поле!");
                    printChessBoard();
                    break;
                }
            }
        }
    }
}
