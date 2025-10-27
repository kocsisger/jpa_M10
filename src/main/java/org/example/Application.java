package org.example;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();

        AnimalDAO animalDAO = new JpaAnimalDAO();
        Animal a = new Animal("crocodile", 20, Animal.genderType.MALE);
        animalDAO.saveAnimal(a);
        Animal b = new Animal("parrot", 80, Animal.genderType.FEMALE);
        animalDAO.saveAnimal(b);

        for (Animal animal : animalDAO.getAnimals()){
            System.out.println(animal);
        }

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
