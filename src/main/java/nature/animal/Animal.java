package nature.animal;

import nature.FoodRepository;

public interface Animal extends Comparable<Animal> {

    /**
     * animal should eat only if it hasn't eaten and should it 1% of its body mass
     */
    boolean eat(FoodRepository foodRepository);

    void speak();

    /**
     * animal should poop 1/150 of its size and set animal to hungry
     */
    Poop poop();

    double getSizeKg();


    boolean isHungry();
}
