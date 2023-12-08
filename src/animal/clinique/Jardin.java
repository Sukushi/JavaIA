package animal.clinique;

import animal.animaux.*;
import animal.race.*;

public class Jardin {

    public static void main(String[] args) {
        Chien chienBerger = new BergerAllemand("Béranger",6,null,null);
        BergerAllemand berger = new BergerAllemand("Clara",2,null,null);
        Malinois malinois = new Malinois("Justin",8,null,null);

        Clinique.checkUp();
    }

}
