package Lesson_3.Animals;

public class Cat extends Animal {

    static int totalCats = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false; // создаваем кот голодный
        totalCats++;
    }

    @Override
    public void run(int runningDistance) {
        if (runningDistance <= 200) {
            System.out.println(name + " пробежал " + runningDistance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 200 м.");
        }
    }

    @Override
    public void swim(int swimmingDistance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (!isFull && bowl.eatFromBowl(foodAmount)) {
            isFull = true;
            System.out.println(name + " покушал и стал сытым.");
        } else if (!isFull){
            System.out.println(name + " не стал есть, недостаточно еды.");
        } else {
            System.out.println(name + " уже сыт.");
        }
    }

    public boolean isFull(){
        return isFull;
    }


}
