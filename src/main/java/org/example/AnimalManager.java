package org.example;

public class AnimalManager {
    AnimalDAO animalDAO;

    public AnimalManager(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public void manage(){
        Animal a = new Animal("crocodile", 20, Animal.genderType.MALE);
        animalDAO.saveAnimal(a);
        Animal b = new Animal("parrot", 80, Animal.genderType.FEMALE);
        animalDAO.saveAnimal(b);

        for (Animal animal : animalDAO.getAnimals()){
            System.out.println(animal);
        }

        Animal c = new Animal("snake", 50, Animal.genderType.FEMALE);

        Zoo zoo = new Zoo("Debrecen Zoo");
        zoo.getAnimals().add(a);
        zoo.getAnimals().add(b);
        zoo.getAnimals().add(c);
        animalDAO.saveZoo(zoo);
    }
}
