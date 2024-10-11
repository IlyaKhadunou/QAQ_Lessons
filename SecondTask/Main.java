package Lesson_5.SecondTask;

public class Main {

    public static void main(String[] args) {
        TelephoneBook telephoneBook = new TelephoneBook();

        telephoneBook.add(1111111, "Сидоров");
        telephoneBook.add(2222222, "Петров");
        telephoneBook.add(3333333, "Иванов");
        telephoneBook.add(4444444, "Петров");
        telephoneBook.add(5555555, "Кузнецов");
        telephoneBook.add(6666666, "Смирнов");
        telephoneBook.add(7777777, "Петров");
        telephoneBook.add(8888888, "Смирнов");

        telephoneBook.get("Сидоров");
        telephoneBook.get("Петров");
        telephoneBook.get("Иванов");
        telephoneBook.get("Кузнецов");
        telephoneBook.get("Смирнов");

    }
}
