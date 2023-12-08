package objects;

import objects.animals.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jardin {
    public static void main(String[] args) {
        //List<Animal> jardin = create();

        BergerAllemand bergerAll = new BergerAllemand("Rex");
        Animal polyBerger = new BergerAllemand("T-Rex");
        //bergerAll.displayPride();
        //polyBerger.displayPride(); // on perd l'accès aux fonctions propres au Berger Allemand (sauf si on cast)

        Chat chat = new Chat("Nounours");
        List<Animal> jardin = new ArrayList<>() {{
            add(bergerAll);
            add(chat);
        }};

        Veterinaire.checkUp();
    }

    public static List<Animal> create() {
        List<Animal> jardin = new ArrayList<>() {{
            add(new Animal("Léopard Tristan"));
            add(new Animal("Léopard Bérangère",3,null,null));
            add(new Animal("Léopard David",4,null,null));

            add(new Chat("Nounours"));
            add(new Chat("Gribouille"));

            add(new BergerAllemand("Rex"));
        }};
        jardin.get(0).setParents(jardin.get(1),jardin.get(2));

        return jardin;
    }
}
