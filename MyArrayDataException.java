package Lesson_4;

public class MyArrayDataException extends Exception {

    //исключение при неверных данных в массиве
    public MyArrayDataException (String message){
        super(message);
    }
}
