package io.muic.ooc.fab;

import java.util.*;

public class Tiger extends Carnivore {
    // Characteristics shared by all tigers (class variables).

    // The age at which a tiger can start to breed.
    private static final int BREEDING_AGE = 30;
    // The age to which a tiger can live.
    private static final int MAX_AGE = 200;
    // The likelihood of a tiger breeding.
    private static final double BREEDING_PROBABILITY = 0.08;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a tiger can go before it has to eat again.
    private static final int MAX_FOOD_LEVEL = 9;
    // Random generator
    private static final Random RANDOM = new Random();

    // HashSet containing all edible prey
    private static final Set<Class> preyNames = new HashSet<>() {{
        add( Rabbit.class );
        add( Fox.class );
    }};


    /**
     * Create a fox. A fox can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        setPreyNames(preyNames); // Cannot be moved up to carnivore
        super.initialize(randomAge, field, location);
        setFoodLevel(RANDOM.nextInt(getMaxFoodLevel()));
    }



    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected double getBreedingProbability() {
        return BREEDING_PROBABILITY;
    }

    @Override
    protected int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }

    @Override
    protected int getBreedingAge() {
        return BREEDING_AGE;
    }


    @Override
    public int getMaxFoodLevel() { return MAX_FOOD_LEVEL; };


}
