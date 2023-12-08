package animal.animaux;

import animal.Animal;
import animal.race.Chien;

public final class Malinois extends Animal implements Chien {

    private int pride = 3;

    public Malinois() {
    }
    public Malinois(String name) {
        super(name);
    }
    public Malinois(String name, int age, Animal parent1, Animal parent2) {
        super(name, age, parent1, parent2);
    }

    @Override
    public AgeRange getAgeRange() {
        if (this.getAge() < 3) return AgeRange.JEUNE;
        else if (this.getAge() >= 6) return AgeRange.SENIOR;
        else return AgeRange.ADULTE;
    }

    @Override
    public Malinois getChild(Animal parent) {
        return new Malinois("",0,this,parent);
    }

    @Override
    public String bark() {
        return bark(switch (this.getAgeRange()) {
            case JEUNE -> "HawHaw";
            case ADULTE -> "WafWaf";
            default -> "Wouf";
        });
    }

    @Override
    public String fightFor() {
        return this.getName() + " se bat pour son maître";
    }
    @Override
    public String gagnant() {
        return this.getName() + " saute sur son mâitre";
    }
    @Override
    public String perdant() {
        return this.getName() + " part se cacher";
    }


}
