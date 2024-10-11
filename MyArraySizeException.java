package Lesson_4;

public class MyArraySizeException extends Exception {

    //исключение при неверном размере массива
    public MyArraySizeException (String message){
        super(message);
    }
}
