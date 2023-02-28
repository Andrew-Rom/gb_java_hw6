package ru.gb;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Кот (имя, аппетит, сытность)
        // Тарелка (содержит какое-то количество еды)
        // Кот ест из тарлеки. Если в тарелке недостаточно еды - кот ее не трогает

        // ДЗ:
        // while (true) -> while (!plate.isEmpty())
        // 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной тарелки.
        // В конце каждого цикла мы досыпаем в тарелку еду.
        // Для досыпания еды сделать метод increaseFood в классе Plate.
        // 2. Поменять поле satiety у кота с boolean на int.
        // Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
        // 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал сытость кота на 1.

//        Cat murzik = new Cat("Murzik", 15);
//        Cat barsik = new Cat("Barsik"); // appetite = 10

        int catQuantity = 10;
        Cat[] cats = new Cat[catQuantity];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("cat-" + (i + 1), 10 + 2 * i);
        }

        Plate plate = new Plate(200);

        while (true) {
            boolean plateIsEmpty = false;
            while (!plateIsEmpty) {
                for (Cat cat : cats) {
                    System.out.println("Quantity of food before feeding: " + plate);
                    System.out.println(cat);
                    cat.eat(plate);
                    if (cat.isHungry()) {
                        plateIsEmpty = true;
                        System.out.println(cat + " is still hungry because the plate was empty");
                        break;
                    } else {
                        System.out.println(cat + " is fed up");
                        System.out.println("Quantity of food after feeding: " + plate + "\n");
                        cat.makeHungry();
                    }
                }
            }
            plate.increaseFood(200);
            System.out.println("The plate was refilled but other cats is hungry again. \n");
            Thread.sleep(1000);
        }
    }

}