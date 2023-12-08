package animal.exercice;

/*
* Tout chien créé doit être dans une liste du FightClub.
* Il faut une méthode qui annonce les participants
* -> pour tous les chiens de la liste :
*      'Combattant 1 : '
*      bark()
*
*
* Chien :
* les chiens sont capables de se battre
* -> void fight (Chien adversaire)
*      les bergers allemands se battent pour leur fierté
*      les malinois se battent pour l'honneur de leur maitre
*      désigner un vainqueur avec un random boolean
*      si le berger allemand gagne pride++ ET montre sa fierté
*      si le malinois gagne : nom + saute sur son maitre sinon nom + part se cacher
* */

import animal.animaux.BergerAllemand;
import animal.animaux.Malinois;
import animal.race.*;

import java.util.ArrayList;
import java.util.List;

public class FightClub {

    public static void main(String[] args) {
        Chien berger = new BergerAllemand("Béranger");
        Chien berger2 = new BergerAllemand("Rex");
        Chien malinois = new Malinois("Lali",2,null,null);
        Chien malinois2 = new Malinois("Noix",5,null,null);

        annonce();

        berger.combat(berger);

        berger.combat(malinois);

        malinois.combat(berger);

        malinois.combat(malinois2);

        berger2.combat(berger);
    }


    public static List<Chien> combattants = new ArrayList<>();

    public static void inscription(Chien chien) {
        combattants.add(chien);
    }

    public static void annonce() {
        System.out.println("--- Les combattants sont ---");
        for (int i = 0; i < combattants.size(); i++) {
            Chien combattant = combattants.get(i);
            System.out.printf("Combattant %s : %s %n%s %n%n",i+1,combattant,combattant.bark());
        }
    }
}
