package io.muic.ooc.fab;

public enum AnimalType {
    RABBIT(0.08, Rabbit.class),
    FOX(0.02, Fox.class);

    private double breedingProbablitity;
    private Class animalClass;

    // Constructor
    AnimalType(double breedingProbablitity, Class animalClass) {
        this.breedingProbablitity = breedingProbablitity;
        this.animalClass = animalClass;
    }

    public Class getAnimalClass() {
        return this.animalClass;
    }

    public double getBreedingProbablitity() {
        return this.breedingProbablitity;
    }
}
