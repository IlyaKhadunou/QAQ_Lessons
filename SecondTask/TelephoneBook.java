package Lesson_5.SecondTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelephoneBook {

    private Map<Integer, String> telephoneBook = new HashMap<>();

    public TelephoneBook() {

    }

    public void add(int number, String surname) {
        telephoneBook.put(number, surname);
    }

    public void get(String surname) {
        if (telephoneBook.containsValue(surname)) {
            Set<Map.Entry<Integer, String>> set = telephoneBook.entrySet();
            for (Map.Entry<Integer, String> map : set) {
                if (map.getValue().equals(surname)) {
                    System.out.println(map.getValue() + ": " + map.getKey());
                }
            }
        } else {
            System.out.println("Такого имени нет в списке.");
        }
    }
}
