package animal;

import animal.clinique.Clinique;
import animal.exercice.FightClub;
import animal.race.*;

public abstract class Animal {
// la classe abstraite permet d'instancier les class enfants mais pas la class actuelle, elle doit donc forcément être héritée pour être utilisé
// à l'inverse une class final ne peut plus être héritée par la suite

    static long count = 0;

    public enum AgeRange {
        JEUNE,ADULTE,SENIOR
    } // Jeune <3 | Senior >= 6

    private final long id;
    private String name;
    private int age;
    private final Animal[] parents;

    public Animal() {
        count++;
        this.id = count;
        parents = new Animal[2];
        Clinique.declarer(this);
        if (this instanceof Chien) {
            FightClub.inscription((Chien) this);
        }
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

    public long getId() {
        return id;
    }

    public abstract AgeRange getAgeRange();
    protected int getAge() {
        return age;
    }
    public void birthday() {
        this.age++;
        System.out.printf("C'est anniversaire de %s ! Il a %s an(s) aujourd'hui !%n",this.getName(),age);
    }

    public String getName() {
        return name==null ? "Inconnu" : name;
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
        return this.getName();
    }

    // méthode abstraite qui oblige les class héritée à définir la méthode
    // PS : le type de retour peut être changé pour une class enfant
    public abstract Animal getChild(Animal parent);

}
