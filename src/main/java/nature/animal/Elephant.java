package nature.animal;

import nature.FoodRepository;

public class Elephant implements Animal {


    private double sizeKg = 3000;
    private boolean hasEaten = false;

    @Override
    public boolean eat(FoodRepository foodRepository) {

        double amountToEat = sizeKg / 100;

        if (foodRepository.consume(amountToEat)) {
            sizeKg += amountToEat;
            return hasEaten = true;
        } else return hasEaten;
    }

    @Override
    public void speak() {
        System.out.println("trump");
    }

    @Override
    public Poop poop() {

        if (hasEaten) {
            hasEaten = false;
            return new Poop(sizeKg / 150);
        } else return new Poop(0);
    }

    @Override
    public double getSizeKg() {
        return sizeKg;
    }

    @Override
    public boolean isHungry() {
        return !hasEaten;
    }

    @Override
    public int compareTo(Animal o) {
        return Double.compare(sizeKg, o.getSizeKg());
    }
}
