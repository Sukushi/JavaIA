package serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Annuaire implements Serializable {

    private String name;
    private Person owner;
    private List<Person> contacts;

    public Annuaire() {
    }
    public Annuaire(String name, Person owner, List<Person> contacts) {
        this.name = name;
        this.owner = owner;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public List<Person> getContacts() {
        return contacts;
    }
    public void setContacts(List<Person> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return String.format("Nom : %s%nOwner : %s%nContacts : {%n\t%s%n}",
                name,
                owner, // utilise son propre toString()
                contacts.stream().map(Objects::toString).collect(Collectors.joining("\n\t")));
    }

    public static Annuaire create() {
        List<Person> contacts = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            contacts.add(new Person(("Person "+i), random.nextInt(0,Integer.MAX_VALUE)));
        }
        return new Annuaire("Mon annuaire",new Person("Sukushi",217349),contacts);
    }
}
