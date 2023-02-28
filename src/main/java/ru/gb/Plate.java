package ru.gb;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int foodToDecrease) {
        if (food >= foodToDecrease) {
            food = food - foodToDecrease;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }

}
