package io.muic.ooc.fab;

import java.util.*;

public class Tiger extends Carnivore {
    // Characteristics shared by all tigers (class variables).

    // The age at which a tiger can start to breed.
    private static final int BREEDING_AGE = 20;
    // The age to which a tiger can live.
    private static final int MAX_AGE = 200;
    // The likelihood of a tiger breeding.
    private static final double BREEDING_PROBABILITY = 0.03;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a tiger can go before it has to eat again.
    private static final int MAX_FOOD_LEVEL = 9;

    // HashSet containing all edible prey
    private static final Set<Class> preyNames = new HashSet<>() {{
        add( Rabbit.class );
        add( Fox.class );
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
