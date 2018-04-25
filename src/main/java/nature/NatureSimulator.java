package nature;

import nature.animal.Animal;
import nature.animal.Poop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NatureSimulator {

    private final FoodRepository foodRepository;
    private final List<Animal> animals;
    private final List<Poop> poops;
    private final double size;


    public NatureSimulator(double initialFoodSupply, List<Animal> animals) {
        this.animals = animals;
        this.foodRepository = new FoodRepository(initialFoodSupply);
        this.size = animals.stream()
                .mapToDouble(Animal::getSizeKg)
                .reduce(0, (a, b) -> (a + b) / 10);
        this.poops = new ArrayList<>();
    }


    /**
     * Every animal should perform one action
     */
    public void simulate(int iterations) {
        for (int i = 0; i < iterations; i++)
            for (Animal a : animals) {
                switch (new Random().nextInt(2)) {
                    case 0:
                        a.eat(foodRepository);
                        break;
                    case 1:
                        poops.add(a.poop());
                        break;
                    default:
                }
            }
    }


    @Override
    public String toString() {
        return "Environment" +
                "\ncontamination " + calculateContamination() + '%' +
                "\nfoodState " + foodRepository.getState() +
                "\nhungry animals count " + countHungryAnimals();
    }

    private double calculateContamination() {
        return (poops.stream().mapToDouble(Poop::getSize).sum() / size) * 100;
    }

    private long countHungryAnimals() {
        return (animals.stream().filter(Animal::isHungry)).count();
    }
}
