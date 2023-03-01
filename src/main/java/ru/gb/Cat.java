package ru.gb;

public class Cat {

    private String name;
    private int appetite;
    private int satiety = 0;

    public Cat(String name) {
        this(name, 10);
//        this.name = name;
//        this.appetite = 10;
//        satiety = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
//        satiety = false;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                if (satiety > 0) satiety -= 1;
                try {
                    Thread.sleep(5 * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if (satiety < appetite) {
            satiety = plate.decreaseFood(appetite - satiety);
        }
    }

    public void makeHungry() {
        satiety = 0;
    }


    public int getAppetite() {
        return appetite;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int eatenFood) {
        satiety = Math.min((eatenFood + satiety), appetite);
    }

    @Override
    public String toString() {
        return name + "{appetite=" + appetite + ", satiety=" + satiety + "}";
    }
}
