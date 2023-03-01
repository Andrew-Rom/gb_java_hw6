package ru.gb;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int catQuantity = 10;
        Cat[] cats = new Cat[catQuantity];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat-" + (i + 1), 10 + 2 * i);
        }

        Plate plate = new Plate(181);

        while (true) {
            int foodOnPlate = plate.qtyFood();
            int eatenFoodCounter = 0;
            while (plate.qtyFood() > 0) {
                for (Cat cat : cats) {
                    System.out.println("Quantity of food before feeding: " + plate.qtyFood());
                    System.out.println(cat + "is hungry.");
                    if (cat.getSatiety() == cat.getAppetite()) {
                        System.out.println(cat + " does not want to eat.");
                    } else {
                        cat.eat(plate);
                        if (cat.getSatiety() != cat.getAppetite()) {
                            System.out.println(cat + " is still hungry because there is not enough food on plate");
                            eatenFoodCounter += (foodOnPlate - plate.qtyFood());
                            foodOnPlate = plate.qtyFood();
                            break;
                        } else {
                            System.out.println(cat + " is well-fed.");
                            System.out.println("Quantity of food after feeding: " + plate.qtyFood() + "\n");
                            eatenFoodCounter += (foodOnPlate - plate.qtyFood());
                            foodOnPlate = plate.qtyFood();
                        }
                    }
                }
                plate.increaseFood(eatenFoodCounter);
                System.out.println("The plate was refilled with " + eatenFoodCounter + " food, " +
                        "but cats are hungry again. \n");
                Thread.sleep(7000);
            }
        }
    }
}