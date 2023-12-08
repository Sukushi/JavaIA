package objects.animals;

import objects.Animal;

public class Chat extends Animal {

    private String couleur;

    public Chat() {
        super();
    }

    public Chat(String name) {
        super(name);
    }

    public Chat(String name, int age, Animal parent1, Animal parent2, String couleur) {
        super(name, age, parent1, parent2);
        this.couleur = couleur;
    }
}
