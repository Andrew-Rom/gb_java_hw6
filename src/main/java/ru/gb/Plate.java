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

    public void increaseFood(int foodToIncrease) {
        food = food + foodToIncrease;
    }

    public Integer qtyFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }

}
