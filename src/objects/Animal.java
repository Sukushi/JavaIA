package objects;

import java.util.Arrays;
import java.util.Random;

public class Animal {

    /*
    * public    : accessible depuis partout
    * default   : accessible uniquement dans le même package
    * private   : accessible uniquement depuis la class elle-même
    * protected : accessible uniquement dans le même package et aux enfants
    *
    * final     : assure que la valeur ne sera pas modifiée une fois initialisée (et qu'elle doit l'être même dans un constructeur vide)
    * static    : défini un attribut comme appartenant à la classe et non à un objet instancié de la classe
    *             (toutes les instances de cette classe auront cet attribut à la même valeur)
    * */

    private static long count = 0;

    public enum AgeRange { // une énumération dans une classe est static par défaut
        JEUNE,ADULTE,SENIOR
    } // Jeune <3 | Senior >= 6

    public final long id;
    private int age;
    protected String name;
    final Animal[] parents;

    // la déclaration d'un constructeur empêche d'utiliser le constructeur par défaut (hérité de Object)
    // constructeur vide (n'est PAS le constructeur par défaut)
    public Animal() {
        count++;
        this.id = count;
        parents = new Animal[2];
        Veterinaire.declarer(this);
    }
    public Animal(String name) {
        this();
        this.name = name;
    }
    public Animal(String name, int age, Animal parent1, Animal parent2) {
        this(name);
        this.age = age;
        this.parents[0] = parent1;
        this.parents[1] = parent2;
    }

    public AgeRange getAge() {
        if (age < 3) return AgeRange.JEUNE;
        else if (age >= 6) return AgeRange.SENIOR;
        else return AgeRange.ADULTE;
        //return age < 3 ? AgeRange.JEUNE : (age >= 6 ? AgeRange.SENIOR : AgeRange.ADULTE);
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void birthday() {
        this.age++;
        System.out.printf("C'est anniversaire de %s ! Il a %s an(s) aujourd'hui !%n",name,age);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Animal[] getParents() {
        return parents;
    }
    public void setParents(Animal parent1, Animal parent2) {
        parents[0] = parent1;
        parents[1] = parent2;
    }

    @Override
    public String toString() {
        return name == null ? "Animal{nom=inconnu}" : "Animal{nom="+name+"}";
    }
}
