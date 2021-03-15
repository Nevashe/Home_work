package homework8.servise;

import homework8.front.MyWindow;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

import static homework8.front.MyWindow.*;


public class Algorithm {

    public static char[][] MyMap;

    public static int getSizeMap() {
        return SizeMap;
    }

    private static final int SizeMap = 3;
    private static final int CharToWin = 3;
    private static final char EmptyChar = '.';
    public static final char XChar = 'x';
    private static final char OChar = 'o';
    private static int[][] TestMap;

    public static void setCheckClick(boolean checkClick) {
        CheckClick = checkClick;
    }

    private static volatile boolean CheckClick = false;


    private static volatile boolean CheckComputerTurn = false;
    private static volatile boolean CheckTrueClick = false;

    public Algorithm() {
        initMap();
        while (true) {
                while (!CheckTrueClick) {
                    while (CheckClick) {
                        humanMove();
                    }
                }
            if (checkWin(XChar)) {
                newLabel("Вы победили");
                break;
            } else if (checkDrow()) {
                newLabel("Ничья");
                break;
            }
            computerMoveInt();
            if (checkWin(OChar)) {
                newLabel("Вы проиграли");
                break;
            } else if (checkDrow()) {
                newLabel("Ничья");
                break;
            }
            CheckClick = false;
            CheckTrueClick = false;
        }

    }

    public static void humanMove() {
        System.out.println("Введите координаты в формате х у");

        if (checkInp(MyWindow.coordinateTurn / 10, MyWindow.coordinateTurn % 10)){
            MyMap[MyWindow.coordinateTurn / 10][MyWindow.coordinateTurn % 10] = XChar;
            jButtonsFirstPanel[MyWindow.coordinateTurn/10][MyWindow.coordinateTurn%10].setBackground(Color.RED);
            CheckTrueClick = true;
        } else {
            CheckClick = false;
        }

    }


    private static void initMap() {
        MyMap = new char[SizeMap][SizeMap];
        for (char[] chars : MyMap) {
            Arrays.fill(chars, EmptyChar);
        }
    }

    public static boolean checkInp(int x, int y) {
        if (Math.min(x, y) < 0 && Math.max(x, y) > SizeMap - 1) {
            return false;
        }
        if (MyMap[x][y] == EmptyChar) {
            return true;
        }
        return false;
    }

    private static boolean checkWin(char c) {
        if (checkLineColumnDown(c)) {
            return true;
        }
        // Провека главных диагоналей
        if (checkFirstDiagDown(c)) {
            return true;
        }
        // Проверка второстепенных диагоналей
        if (checkSecondDiagDown(c)) {
            return true;
        }
        return false;
    }

    private static boolean checkLineColumnDown(char c) {
        TestMap = new int[SizeMap][SizeMap];
        int tmpMaxLine = 0;
        int tmpMaxColumn = 0;
        for (int i = 0; i < MyMap.length; i++) {
            int tmpLine = 0;
            int tmpColumn = 0;
            for (int j = 0; j < MyMap[i].length; j++) {
                // проверка линии вниз
                if (MyMap[i][j] == c) {
                    tmpLine++;
                    if (tmpLine == CharToWin) {
                        return true;
                    }
                } else {
                    if (MyMap[i][j] == EmptyChar) {
                        TestMap[i][j] = TestMap[i][j] + tmpLine;
                    }
                    if (tmpLine > tmpMaxLine) {
                        tmpMaxLine = tmpLine;
                    }
                    tmpLine = 0;
                }

                // Проверка столбца вниз
                if (MyMap[j][i] == c) {
                    tmpColumn++;
                    if (tmpColumn == CharToWin) {
                        return true;
                    }
                } else {
                    if (MyMap[j][i] == EmptyChar) {
                        TestMap[j][i] = TestMap[j][i] + tmpColumn;
                    }
                    if (tmpColumn > tmpMaxColumn) {
                        tmpMaxColumn = tmpColumn;
                    }
                    tmpColumn = 0;
                }
                if (Math.max(tmpMaxColumn, tmpMaxLine) >= CharToWin) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkFirstDiagDown(char c) {
        int tmpMaxDiagLeft = 0;
        int tmpMaxDiagRight = 0;
        for (int i = MyMap.length - CharToWin; i != -1; i--) {
            int tmpDiagRight = 0;
            int tmpDiagLeft = 0;
            for (int j = 0; j < MyMap.length - i; j++) {

                if (MyMap[j][j + i] == c) {
                    tmpDiagRight++;
                    if (tmpDiagRight == CharToWin) {
                        return true;
                    }
                } else {
                    if (MyMap[j][j + i] == EmptyChar) {
                        TestMap[j][j + i] = TestMap[j][j + i] + tmpDiagRight;
                    }
                    if (tmpDiagRight > tmpMaxDiagRight) {
                        tmpMaxDiagRight = tmpDiagRight;
                    }
                    tmpDiagRight = 0;
                }
            }
            if (i != 0) {
                tmpDiagRight = 0;
                tmpDiagLeft = 0;
                for (int j = 0; j < MyMap.length - i; j++) {
                    if (MyMap[j + i][j] == c) {
                        tmpDiagLeft++;
                        if (tmpDiagLeft == CharToWin) {
                            return true;
                        }
                    } else {
                        if (MyMap[j + i][j] == EmptyChar) {
                            TestMap[j + i][j] = TestMap[j + i][j] + tmpDiagLeft;
                        }
                        if (tmpDiagLeft > tmpMaxDiagLeft) {
                            tmpMaxDiagLeft = tmpDiagLeft;
                        }
                        tmpDiagLeft = 0;
                        if (Math.max(tmpMaxDiagLeft, tmpMaxDiagRight) >= CharToWin) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkSecondDiagDown(char c) {
        int tmpMaxDiagLeft = 0;
        int tmpMaxDiagRight = 0;
        for (int i = MyMap.length - CharToWin; i != -1; i--) {
            int tmpDiagRight = 0;
            int tmpDiagLeft = 0;
            for (int j = 0; j < MyMap.length - i; j++) {
                if (MyMap[j + i][MyMap.length - 1 - j] == c) {
                    tmpDiagRight++;
                    if (tmpDiagRight == CharToWin) {
                        return true;
                    }
                } else {
                    if (MyMap[j + i][MyMap.length - 1 - j] == EmptyChar) {
                        TestMap[j + i][MyMap.length - 1 - j] += tmpDiagRight;
                    }
                    if (tmpDiagRight > tmpMaxDiagRight) {
                        tmpMaxDiagRight = tmpDiagRight;
                    }
                    tmpDiagRight = 0;
                }
            }
            if (i != 0) {
                tmpDiagRight = 0;
                tmpDiagLeft = 0;
                for (int j = 0; j < MyMap.length - i; j++) {
                    if (MyMap[j][MyMap.length - 1 - i - j] == c) {
                        tmpDiagLeft++;
                        if (tmpDiagLeft == CharToWin) {
                            return true;
                        }
                    } else {
                        if (MyMap[j][MyMap.length - 1 - i - j] == EmptyChar) {
                            TestMap[j][MyMap.length - 1 - i - j] += tmpDiagLeft;
                        }
                        if (tmpDiagLeft > tmpMaxDiagLeft) {
                            tmpMaxDiagLeft = tmpDiagLeft;
                        }
                        tmpDiagLeft = 0;
                    }
                }
            }
            if (Math.max(tmpMaxDiagLeft, tmpMaxDiagRight) >= CharToWin) {
                return true;
            }
        }
        return false;
    }


    private static boolean checkDrow() {
        for (char[] chars : MyMap) {
            for (char aChar : chars) {
                if (aChar == EmptyChar) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void computerMoveInt() {

        int x_coordinate = 0;
        int y_coordinate = 0;

        checkLineColumnUp(XChar);
        checkFirstDiagUp(XChar);
        checkSecondDiagUp(XChar);
        int MaxNum = 0;
        for (int i = 0; i < TestMap.length; i++) {
            for (int j = 0; j < TestMap[i].length; j++) {
                Random random = new Random();
                if (TestMap[i][j] > MaxNum) {
                    x_coordinate = i;
                    y_coordinate = j;
                    MaxNum = TestMap[i][j];
                } else if (TestMap[i][j] == MaxNum && random.nextInt(2) == 0) {
                    x_coordinate = i;
                    y_coordinate = j;
                }
            }
        }
        System.out.println(MaxNum);
        MyMap[x_coordinate][y_coordinate] = OChar;
        CheckComputerTurn = true;
        jButtonsFirstPanel[x_coordinate][y_coordinate].setBackground(Color.BLUE);

    }

    private static void checkLineColumnUp(char c) {
        for (int i = MyMap.length - 1; i >= 0; i--) {
            int tmpLine = 0;
            int tmpColumn = 0;
            for (int j = MyMap[i].length - 1; j >= 0; j--) {
                if (MyMap[i][j] == c) {
                    tmpLine++;
                } else {
                    if (MyMap[i][j] == EmptyChar) {
                        TestMap[i][j] += tmpLine;
                    }
                    tmpLine = 0;
                }
                if (MyMap[j][i] == c) {
                    tmpColumn++;
                } else {
                    if (MyMap[j][i] == EmptyChar) {
                        TestMap[j][i] += tmpColumn;
                    }
                    tmpColumn = 0;
                }
            }
        }
    }

    private static void checkFirstDiagUp(char c) {
        for (int i = MyMap.length - CharToWin; i != -1; i--) {
            int tmpDiagRight = 0;
            int tmpDiagLeft = 0;
            for (int j = MyMap.length - i - 1; j >= 0; j--) {

                if (MyMap[j][j + i] == c) {
                    tmpDiagRight++;
                } else {
                    if (MyMap[j][j + i] == EmptyChar) {
                        TestMap[j][j + i] = TestMap[j][j + i] + tmpDiagRight;
                    }
                    tmpDiagRight = 0;
                }
            }
            if (i != 0) {
                for (int j = MyMap.length - i - 1; j >= 0; j--) {
                    if (MyMap[j + i][j] == c) {
                        tmpDiagLeft++;
                    } else {
                        if (MyMap[j + i][j] == EmptyChar) {
                            TestMap[j + i][j] = TestMap[j + i][j] + tmpDiagLeft;
                        }
                        tmpDiagLeft = 0;
                    }
                }
            }
        }
    }

    private static void checkSecondDiagUp(char c) {
        for (int i = MyMap.length - CharToWin; i != -1; i--) {
            int tmpDiagRight = 0;
            int tmpDiagLeft = 0;
            for (int j = MyMap.length - i - 1; j >= 0; j--) {
                if (MyMap[j + i][MyMap.length - 1 - j] == c) {
                    tmpDiagRight++;
                } else {
                    if (MyMap[j + i][MyMap.length - 1 - j] == EmptyChar) {
                        TestMap[j + i][MyMap.length - 1 - j] = TestMap[j + i][MyMap.length - 1 - j] + tmpDiagRight;
                    }
                    tmpDiagRight = 0;
                }
            }
            if (i != 0) {
                for (int j = MyMap.length - i - 1; j >= 0; j--) {
                    if (MyMap[j][MyMap.length - 1 - i - j] == c) {
                        tmpDiagLeft++;
                    } else {
                        if (MyMap[j][MyMap.length - 1 - i - j] == EmptyChar) {
                            TestMap[j][MyMap.length - 1 - i - j] = TestMap[j][MyMap.length - 1 - i - j] + tmpDiagLeft;
                        }
                        tmpDiagLeft = 0;
                    }
                }
            }
        }
    }

}


