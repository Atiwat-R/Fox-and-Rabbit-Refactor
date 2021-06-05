package io.muic.ooc.fab;

import java.util.*;

public class Hunter extends Carnivore {
    // Characteristics shared by all hunter (class variables).

    // The age at which a hunter can start to breed.
    private static final int BREEDING_AGE = 20;
    // The age to which a hunter can live.
    private static final int MAX_AGE = 50;
    // The likelihood of a hunter breeding.
    private static final double BREEDING_PROBABILITY = 0.001;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a hunter can go before it has to eat again.
    private static final int MAX_FOOD_LEVEL = 9;

    // HashSet containing all edible prey
    private static final Set<Class> preyNames = new HashSet<>() {{
        add( Rabbit.class );
        add( Tiger.class );
        add( Fox.class );
    }};


    /**
     * Override incrementAge(). Now Hunter can no longer die of old age.
     */
    @Override
    protected void incrementAge() { age++; }


    /**
     * Override incrementHunger(). Now Hunter can no longer die of hunger.
     */
    @Override
    protected void incrementHunger() { }



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

    @Override
    public Set<Class> getPreyNames() { return preyNames; }


}