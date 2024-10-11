package Lesson_5;

import java.util.HashMap;
import java.util.Map;

public class FirstTask {

    public static void main(String[] args) {

        String[] words = {"Яблоко", "Апельсин", "Лимон", "Ананас", "Арбуз", "Персик", "Яблоко", "Мандарин",
                "Грейпфрут", "Персик", "Виноград", "Финик", "Апельсин", "Яблоко", "Дыня",
                "Яблоко", "Морковь", "Яблоко", "Ананас", "Нектарин"};


        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова: " + wordCount.keySet());

        System.out.println("Количество дубликатов: ");
        for (Map.Entry<String, Integer> map : wordCount.entrySet()) {
            System.out.println(map.getKey() + ": " + map.getValue());
        }


    }


}
