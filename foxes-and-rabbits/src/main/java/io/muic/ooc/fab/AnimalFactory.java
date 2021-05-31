package io.muic.ooc.fab;

public class AnimalFactory {

    public static Animal createAnimal(AnimalType animalType, Boolean randomAge, Field field, Location location) {
        switch(animalType) {
            case RABBIT:
                return new Rabbit(randomAge, field, location);
            case FOX:
                return new Fox(randomAge, field, location);
            default:
                throw new IllegalArgumentException("Unknown Animal Type");
        }
    }
}
