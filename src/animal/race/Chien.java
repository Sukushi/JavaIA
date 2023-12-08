package animal.race;

/*
* D'origine une interface définit un 'contrat/structure' que doit respecter une classe
* On y écrit des 'signatures' de méthode qui doivent être présente dans la classe qui implémente l'interface
*/

import java.util.Random;

public interface Chien {

    // se comporte comme une variable static ET final
    // on considère cette variable comme une constante (d'où la nomenclature en MAJ)
    Random RANDOM = new Random();

    String bark(); // signature de méthode (visibilité par défaut : public)

    // une méthode avec le même nom et le même type de retour qu'une autre est dite 'surchargée' si elle possède différents paramètres
    default String bark(String voice) { // default dans une interface permet de fournir un corps de méthode commun aux classes qui l'implémente
        return (this + " : " + voice);
    }

    default Chien result(Chien combattant, Chien adversaire) {
        return RANDOM.nextBoolean() ? combattant : adversaire;
    }

    default void combat(Chien adversaire) {
        System.out.printf("--- Combat %s VS %s ---%n",this,adversaire);
        if (adversaire != this) {
            Chien gagnant = result(this,adversaire);
            System.out.printf("%s %n%s %n -> Le gagnant est %s ! %n",
                    this.fightFor(),adversaire.fightFor(), gagnant);
            String reactWin = gagnant==this ? this.gagnant() : adversaire.gagnant();
            String reactLose = gagnant!=this ? this.perdant() : adversaire.perdant();
            System.out.print(reactWin!=null ? reactWin+'\n' : "");
            System.out.print((reactLose!=null ? reactLose+ '\n' : "")+'\n');
        } else {
            System.out.printf("%s ne veut pas se battre contre lui même %n%n",this);
        }
    }
    String fightFor();
    String gagnant();
    String perdant();

}
