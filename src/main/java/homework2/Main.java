package homework2;


public class Main {
    public static void main(String[] args) {

    }

    public static void first() {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

    }

    public static void second() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }

    public static void third() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    public static void forth() {
        int[][] arr = new int[9][9];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i + j == arr.length - 1 || i == j)
                    arr[i][j] = 1;
            }
        }

    }

    public static void fifth() {
        int[] arr = {1, -5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 13};
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                continue;
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
    }

    public static boolean sixth(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
        }
        if (sum1 % 2 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            sum1 -= arr[i];
            sum2 += arr[i];
            if (sum1 == sum2) {
                return true;
            }
        }
        return false;
    }
   // Вроде постарался сделать читаемым
    public static int[] shift2(int n, int[] arr) {
        if (n == 0 || Math.abs(n) == arr.length) {
            return arr;
        } else if (n > 0) {
            for (int i = 0; i < n % arr.length; i++) {
                int last_number = arr[0];
                for (int j = 0; j < arr.length-1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length-1] = last_number;
            }
        } else {
            for (int i = 0; i > n % arr.length; i--) {
                int last_number = arr[arr.length - 1];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[arr.length - 1 - j] = arr[arr.length - 2 - j];
                }
                arr[0] = last_number;
            }
        }
        return arr;
    }
    // А это версия с тем самым франкенштейном))
 /*
    public static int[] shift1(int n, int[] arr) {
        int lengthshift = n % arr.length; //Длина сдвига без лишних кругов
        int route = lengthshift / Math.abs(lengthshift);
        if (lengthshift == 0) {
            return arr;
        }
        int k = arr[0];
        int kk = Math.abs(lengthshift) * arr.length - 1; // Количество перемещений чисел, кроме последнего

        for (int j = 0; j < kk; j++) {
            if (route > 0) {
                arr[j % arr.length] = arr[(j + 1) % (arr.length)];
            } else {
                arr[(kk + 1 - j) % (arr.length)] = arr[(kk - j) % arr.length];
            }
        }
        arr[(arr.length - lengthshift) % arr.length] = k; // Замена последнего незамененного числа
        return arr;
    }
*/


    public static boolean sixth1(int[] arr) {
        if ( arr.length < 4){
            return false;
        }
        int sum1 = 0;
        int sum2 = arr[arr.length - 1] + arr[arr.length - 2];
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
        }
        if ((sum1 + sum2) % 2 != 0) {
            return false;
        }
        for (int i = 1; i < arr.length - 2; i++) {
            sum1 -= arr[i];
            sum2 += arr[i];
            if (sum1 == sum2) {
                return true;
            }
        }
        return false;
    }static void shiftArr(int arr [], int n) {
        int temp = arr[0];
        int currentIndex = n;
        int jumps = 1;

        while(jumps <= arr.length) {
            int swap = arr[currentIndex % arr.length];
            arr[currentIndex % arr.length] = temp;
            temp = swap;
            if ((jumps * n) % arr.length == 0) {
                currentIndex++;
                temp = arr[currentIndex % arr.length];
            }
            currentIndex += n;
            jumps++;
        }
    }
}



