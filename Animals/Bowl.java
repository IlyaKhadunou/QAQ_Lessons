package Lesson_3.Animals;

public class Bowl {

    private int foodAmount;

    public Bowl(int foodAmount){
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount(){
        return foodAmount;
    }

    // добовление еды в миску
    public void addFood(int amount){
        if(amount > 0){
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " единиц еды в миску.");
        }
    }

    // метод для того, чтобы кот ел из миски
    public boolean eatFromBowl(int amount){
        if(amount <= foodAmount){
            foodAmount -= amount;
            return true;
        } else {
            System.out.println("Недостаточно еды");
            return false;
        }
    }
}
