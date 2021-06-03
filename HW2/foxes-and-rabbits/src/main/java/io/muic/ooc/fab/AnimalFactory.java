package io.muic.ooc.fab;

import java.util.HashMap;
import java.util.Map;

public class AnimalFactory {

    // HashMap housing all entity's breeding probability.
    private static Map<AnimalType, Class> animalClassMap = new HashMap<AnimalType, Class>() {{
        // Initiate and fill up HashMap housing breeding probability of each entity, as specified in AnimalType.
        AnimalType[] animalTypes = AnimalType.values();
        for (int i = 0; i < animalTypes.length; i++) {
            put(animalTypes[i], animalTypes[i].getAnimalClass());
        }
    }};

    public static Animal createAnimal(AnimalType animalType, Field field, Location location)  {
        Class animalClass = animalClassMap.get(animalType);
        return createAnimal(animalClass, field, location);
    }

    public static Animal createAnimal(Class animalClass, Field field, Location location)  {
        if (animalClass != null) {
            try {
                Animal animal = (Animal) animalClass.newInstance();
                animal.initialize(true, field, location);
                return animal;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown animalType");
    }
}
