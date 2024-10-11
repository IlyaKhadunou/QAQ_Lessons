
public class Main {

    public static void main(String[] args) {

        String[][] correctArray = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] wrongArrayLength = {
                {"1", "1", "1", "1", "1"},
                {"1", "", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] wordElementArray = {
                {"1", "1", "1", "1"},
                {"1", "word", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        try {
            int sum = sumArray(correctArray);
            System.out.println("Сумма всех элементов массива равна: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            int sum = sumArray(wrongArrayLength);
            System.out.println("Сумма всех элементов массива равна: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            int sum = sumArray(wordElementArray);
            System.out.println("Сумма всех элементов массива равна: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    //метод проверяющий размер массива, проверяющий элементы массива и преобразование элементов массива
    // из String в int
    public static int sumArray(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        if (strings.length != 4 || strings[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива. Массив должен быть размером 4х4");
        }

        // в переменной sum в дальнейшем будет хранится сумма всех элементов массива
        int sum = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    //преобразование элементов массива из String в int
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '"
                            + strings[i][j] + "'" + " - не является числом!");
                }
            }
        }
        return sum;
    }
}
