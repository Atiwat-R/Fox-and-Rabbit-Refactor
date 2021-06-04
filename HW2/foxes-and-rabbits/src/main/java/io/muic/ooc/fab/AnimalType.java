package io.muic.ooc.fab;
import java.awt.*;

public enum AnimalType {
    RABBIT(0.08, Rabbit.class, Color.ORANGE),
    FOX(0.02, Fox.class, Color.BLUE),
    TIGER(0.02, Tiger.class, Color.RED);

    private double breedingProbablitity;
    private Class animalClass;
    private Color color;

    // Constructor
    AnimalType(double breedingProbablitity, Class animalClass, Color color) {
        this.breedingProbablitity = breedingProbablitity;
        this.animalClass = animalClass;
        this.color = color;
    }

    public Class getAnimalClass() { return this.animalClass; }
    public double getBreedingProbablitity() {
        return this.breedingProbablitity;
    }
    public Color getColor() { return this.color; }
}
