package io.muic.ooc.fab;

import java.util.*;

public abstract class Carnivore extends Animal {

    // HashSet of the class of all the Animals it can eat.
    // It is different for each Animal, which will be set during initialization()
    private static Set<Class> preyNames = new HashSet<>();

    // Random generator
    private static final Random RANDOM = new Random();

    // The carnivore's food level, which is increased by eating its prey.
    private int foodLevel;

    public void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

//    @Override
//    public void initialize(boolean randomAge, Field field, Location location) {
//        setPreyNames(preyNames); // Though the same, it cannot be moved up to carnivore
//        super.initialize(randomAge, field, location);
//        setFoodLevel(RANDOM.nextInt(getMaxFoodLevel()));
//    }


    @Override
    public void act(List<Animal> newAnimals) {
        incrementHunger();
        super.act(newAnimals);
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = findFood();
        if (newLocation == null) {
            // No food found - try to move to a free location.
            newLocation = field.freeAdjacentLocation(location);
        }
        return newLocation;
    }

    /**
     * Look for prey adjacent to the current location. Only the first live
     * prey is eaten.
     *
     * @return Where food was found, or null if it wasn't.
     */
    public Location findFood() {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            // Captures what's in range
            Location where = it.next();
            Object captured = field.getObjectAt(where);
            // Analyze what its caught: get its Class
            Animal animal = (Animal) captured;
            Class capturedClass = null;
            try { capturedClass = animal.getClass(); }
            catch (NullPointerException e) { continue; };

            for (Class preyClass : preyNames) {
                if (capturedClass == preyClass) {
                    if (animal.isAlive()) {
                        animal.setDead();
                        setFoodLevel(getMaxFoodLevel());
                        return where;
                    }
                }
            }

        }
        return null;
    }




    // Getters
    public int getFoodLevel() {
        return foodLevel;
    }
    public static Set<Class> getPreyNames() {
        return preyNames;
    }

    public abstract int getMaxFoodLevel();

    // Setters
    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }
    public static void setPreyNames(Set<Class> animalsPrey) {
        preyNames = animalsPrey;
    }


}
