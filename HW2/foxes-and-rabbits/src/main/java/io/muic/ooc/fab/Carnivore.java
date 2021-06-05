package io.muic.ooc.fab;

import java.util.*;

public abstract class Carnivore extends Animal {

    // Random generator
    private static final Random RANDOM = new Random();
    // The carnivore's food level, which is increased by eating its prey.
    private int foodLevel;

    protected void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    /**
     * Create an entity. An entity can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     *
     * @param randomAge If true, the entity will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge, field, location);
        setFoodLevel(RANDOM.nextInt(getMaxFoodLevel()));
    }


    /**
     * Do the same thing with superclass Animal's act,
     * but with the addition of incrementing hunger.
     * @param newAnimals A list to return newly born animals.
     */
    @Override
    public void act(List<Animal> newAnimals) {
        incrementHunger();
        super.act(newAnimals);
    }

    /**
     * Move to a new location, based on food.
     * @return
     */
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
    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            // Captures what's in range
            Location where = it.next();
            Object captured = field.getObjectAt(where);

            // Analyze what is caught: get its Class
            Animal animal = (Animal) captured;
            Class capturedClass;
            try { capturedClass = animal.getClass(); }
            catch (NullPointerException e) { continue; };

            // See if it's in preyNames. If so, kill it can eat it.
            if (getPreyNames().contains(capturedClass)) {
                if (animal.isAlive()) {
                    animal.setDead();
                    setFoodLevel(getMaxFoodLevel());
                    return where;
                }
            }

        }
        return null;
    }




    // Getters
    public abstract Set<Class> getPreyNames();

    public abstract int getMaxFoodLevel();

    // Setters
    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }
//    public static void setPreyNames(Set<Class> animalsPrey) {
//        preyNames = animalsPrey;
//    }


}
