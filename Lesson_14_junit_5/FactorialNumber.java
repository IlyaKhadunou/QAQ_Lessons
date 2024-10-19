package Lesson_14_junit_5;

public class FactorialNumber {
    public static long getFactorialNumber(int numb){
        if(numb < 0){
            throw new IllegalArgumentException("Number must be non-negative.");
        }

        int result = 1;
        for(int i = 1; i <= numb; i++){
            result *= i;
        }
        return result;
    }
}
