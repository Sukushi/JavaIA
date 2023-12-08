package animal.clinique;

import animal.Animal;
import animal.race.*;

import java.util.ArrayList;
import java.util.List;

public class Clinique {

    public static List<Animal> animaux = new ArrayList<>();

    public static void declarer(Animal animal) {
        animaux.add(animal);
    }
    public static void soigner(Animal animal) {
        animaux.remove(animal);
    }

    public static void checkUp() {
        for (Animal animal:animaux) {
            System.out.println(animal.getName() + " : " + animal.getAgeRange());
            if (animal instanceof Chien) ((Chien) animal).bark();
        }
    }
}
