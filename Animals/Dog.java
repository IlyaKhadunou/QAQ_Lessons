package Animals;

public class Dog extends Animal {

    static int totalDogs = 0;

    public Dog(String name){
        super(name);
        totalDogs++;
    }

    @Override
    public void run(int runningDistance){
        if(runningDistance <= 500){
            System.out.println(name + " пробежал " + runningDistance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 500 м.");
        }
    }

    @Override
    public void swim(int swimmingDistance){
        if(swimmingDistance <= 10){
            System.out.println(name + " проплыл " + swimmingDistance + " м.");
        } else {
            System.out.println(name + " не может проплыть больше 10 м.");
        }
    }
}
