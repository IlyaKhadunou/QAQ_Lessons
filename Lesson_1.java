import java.util.Arrays;

public class Lesson_1 {

    public static void main(String[] args) {

        // 1-ый метод
        printThreeWords();

        // 2-ой метод
        checkSumSign();

        // 3-ий метод
        printColor();

        // 4-ый метод
        compareNumbers();

        // 5-ый метод
        System.out.println(withinNumbers(7, 2));
        System.out.println();

        // 6-ой метод
        positiveOrNegative(14);

        // 7-ой метод
        System.out.println(negativeOrPositive(-1));
        System.out.println();

        // 8-ый метод
        lineRepeat("Строка", 10);

        // 9-ый метод
        System.out.println(isLeapYear(1996));
        System.out.println();

        // 10-ый метод
        numbersReplacement();

        // 11-ый метод
        fillingArray();

        // 12-ый метод
        multiplicationByTwo();

        // 13-ый метод
        diagonalFilling();

        // 14-ый метод
        System.out.println(Arrays.toString(array(6, 6)));


    }

    // 1-ый метод
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println();
    }

    // 2-ой метод
    public static void checkSumSign() {
        int a = 14;
        int b = -4;
        if (a + b >= 0) {
            System.out.println("Сумма положительная!");
        } else {
            System.out.println("Сумма отрицательная!");
        }
        System.out.println();
    }

    // 3-ий метод
    public static void printColor() {
        int value = 15;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
        System.out.println();
    }

    // 4-ый метод
    public static void compareNumbers() {
        int a = 99;
        int b = 66;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
        System.out.println();
    }

    // 5-ый метод
    public static boolean withinNumbers(int a, int b) {
        if (a + b >= 10 & a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // 6-ой метод
    public static void positiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное!");
        } else {
            System.out.println("Число " + a + " отрицательное!");
        }
        System.out.println();
    }

    // 7-ой метод
    public static boolean negativeOrPositive(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    // 8-ой метод
    public static void lineRepeat(String str, int a) {
        for (int i = 1; i <= a; i++) {
            System.out.println(str);
        }
        System.out.println();
    }

    // 9-ый метод
    public static boolean isLeapYear(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }

    // 10-ый метод
    public static void numbersReplacement() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }


    // 11-ый метод
    public static void fillingArray() {
        int[] array = new int[100];

        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }


    // 12-ый метод
    public static void multiplicationByTwo() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
            System.out.printf(array[i] + " ");
        }
        System.out.println("\n");
    }


    // 13-ый метод
    public static void diagonalFilling() {
        int n = 10;
        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    //14 метод
    public static int[] array(int len, int initialValue) {
        int[] arrayLen = new int[len];
        for (int i = 0; i < arrayLen.length; i++) {
            arrayLen[i] = initialValue;
        }
        return arrayLen;
    }
    
}
