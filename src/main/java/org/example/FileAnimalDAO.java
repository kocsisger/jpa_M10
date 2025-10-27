package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAnimalDAO implements AnimalDAO {
    @Override
    public void saveAnimal(Animal a) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("data.txt", true);
            PrintWriter printWriter = new PrintWriter(fos);
            printWriter.println(a);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Animal> getAnimals() {
        Scanner sc = new Scanner("data.txt");
        List<Animal> animals = new ArrayList<>();
        int i=0;
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
            //TODO implement reading of real animals
            animals.add(new Animal("Animal"+ (i++), 0, Animal.genderType.MALE));
        }
        return animals;
    }

    @Override
    public void updateAnimal(Animal a) {
//TODO
    }

    @Override
    public void deleteAnimal(Animal a) {
//TODO
    }
}
