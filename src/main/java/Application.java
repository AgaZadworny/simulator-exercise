import nature.NatureSimulator;
import nature.animal.Animal;
import nature.animal.Chicken;
import nature.animal.Elephant;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            animals.add(new Elephant());
        }
        for (int i = 0; i < 10; i++) {
            animals.add(new Chicken());

        }
        NatureSimulator simulator = new NatureSimulator(100, animals);

        simulator.simulate(2);
        System.out.println(simulator.toString());


    }
}
