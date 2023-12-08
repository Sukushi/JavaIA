package objects;

public class BergerAllemand extends Animal {

    private int pride = 5;

    public BergerAllemand() {
    }
    public BergerAllemand(String name) {
        super(name);
    }
    public BergerAllemand(String name, int age, Animal parent1, Animal parent2, int pride) {
        super(name, age, parent1, parent2);
    }

    public void displayPride() {
        System.out.println(name+" démontre sa fierté : "+"WOUF! ".repeat(pride));
    }
}
