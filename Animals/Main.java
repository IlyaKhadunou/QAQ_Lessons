package Lesson_3.Animals;

public class Main {
    public static void main(String[] args) {
        Dog dogSharik = new Dog("Шарик");
        dogSharik.run(350);
        dogSharik.swim(8);

        Cat catBarsik = new Cat("Барсик");
        catBarsik.run(180);
        catBarsik.swim(2);

        System.out.println("Всего животных: " + Animal.totalAnimals);
        System.out.println("Всего собак: " + Dog.totalDogs);
        System.out.println("Всего котов: " + Cat.totalCats);
        System.out.println();



        Bowl bowl = new Bowl(25);

        Cat[] cats = {
                new Cat("Бутч"),
                new Cat("Марсик"),
                new Cat("Бублик"),
                new Cat("Васька"),
                new Cat("Мурзик"),
        };

        // коты пытются поесть
        for (Cat cat : cats) {
            cat.eat(bowl, 8);
        }

        // вывод информации о сытости котов
        for (Cat cat : cats) {
            System.out.println(cat.name + ((cat.isFull()) ? " сыт." : " голоден."));
        }

        // добовляем еду в миску
        bowl.addFood(21);

        // повторяем покормить голодных котов
        for (Cat cat : cats) {
            if (!cat.isFull()){
                cat.eat(bowl, 10);
            }
        }

        // повторная проверка сытости котов
        for(Cat cat : cats){
            System.out.println(cat.name + ((cat.isFull()) ? " сыт." : " голоден."));
        }


    }
}
