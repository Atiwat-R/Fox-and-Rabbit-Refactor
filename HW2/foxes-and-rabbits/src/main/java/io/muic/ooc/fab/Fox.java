package io.muic.ooc.fab;

import java.util.*;

public class Fox extends Carnivore {
    // Characteristics shared by all foxes (class variables).

    // The age at which a fox can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a fox can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.08;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int MAX_FOOD_LEVEL = 9;

    // HashSet containing all edible prey
    private static final Set<Class> preyNames = new HashSet<>() {{
        add( Rabbit.class );
    }};


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
