package io.muic.ooc.fab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FieldPopulator {

    // Random generator
    private static final Random RANDOM = new Random();

    // HashMap housing all entity's breeding probability.
    private Map<AnimalType, Double> probabilityMap = new HashMap<AnimalType, Double>() {{
        // Initiate and fill up HashMap housing breeding probability of each entity, as specified in AnimalType.
        AnimalType[] animalTypes = AnimalType.values();
        for (int i = 0; i < animalTypes.length; i++) {
            put(animalTypes[i], animalTypes[i].getBreedingProbablitity());
        }
    }};

    /**
     * Randomly populate the field with foxes and rabbits.
     */
    public void populate(Field field, List<Animal> animals) {

        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {

                for (Map.Entry<AnimalType, Double> entry : probabilityMap.entrySet()) {
                    if (RANDOM.nextDouble() <= entry.getValue()) {
                        Location location = new Location(row, col);
                        Animal animal = AnimalFactory.createAnimal(entry.getKey(), field, location);
                        animals.add(animal);
                        break;
                    }
                }

            }
        }
    }

}
