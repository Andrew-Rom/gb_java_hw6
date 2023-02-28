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

        Cat murzik = new Cat("Murzik", 15);
        Cat barsik = new Cat("Barsik"); // appetite = 10

        Plate plate = new Plate(200);

//        while (true) {
            murzik.makeHungry();
            barsik.makeHungry();

            murzik.eat(plate);
            barsik.eat(plate);

            System.out.println(plate);
            System.out.println(murzik);
            System.out.println(barsik);

            Thread.sleep(1000);
//        }
    }

}