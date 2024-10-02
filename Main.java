package Lesson_2;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Иванов Иван Иванович", "Инженер",
                "ivanoc@mail.ru", "+375291234567", 3550.15, 50);

        employee1.info();


        //Задание №2
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Петров Петр Петрович", "Менеджер",
                "petrov@mail.ru", "+375331112233", 1500.25, 25);
        employeeArray[1] = new Employee("Александров Александр Александрович", "Консультант",
                "alex@mail.ru", "+375252223344", 2800, 33);
        employeeArray[2] = new Employee("Ленин Владимир Ильич", "Директор",
                "leninlive@mail.ru", "+3751524687", 15000.1, 75);
        employeeArray[3] = new Employee("Сталин Иосиф Виссарионович", "Зам. директора",
                "stalin@mail.ru", "+375331599333", 10000, 70);
        employeeArray[4] = new Employee("Пушкин Александр Сергеевич", "Копирайтер",
                "pushkin@mail.ru", "+375298981514", 2000.20, 33);
    }
}
