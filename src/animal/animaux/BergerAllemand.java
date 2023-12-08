package animal.animaux;

import animal.race.Chien;
import animal.Animal;

public class BergerAllemand extends Animal implements Chien {

    private int pride = 4;

    public BergerAllemand() {}
    public BergerAllemand(String name) {
        super(name);
    }
    public BergerAllemand(String name, int age, Animal parent1, Animal parent2) {
        super(name, age, parent1, parent2);
    }

    @Override
    public AgeRange getAgeRange() {
        if (this.getAge() < 3) return AgeRange.JEUNE;
        else if (this.getAge() >= 8) return AgeRange.SENIOR;
        else return AgeRange.ADULTE;
    }

    @Override
    public BergerAllemand getChild(Animal parent) {
        return new BergerAllemand("",0,this,parent);
    }

    @Override // Réécrire un comportement existant
    public String bark() {
        return bark("WofWof! ".repeat(pride));
    }

    @Override
    public String fightFor() {
        return this.getName() + " se bat pour sa fierté";
    }
    @Override
    public String gagnant() {
        pride++;
        return bark();
    }
    @Override
    public String perdant() {
        return null;
    }

}
