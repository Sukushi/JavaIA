package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV implements Serializer {

    private static final String FILENAME = "annuaire.csv";
    private static final String DELIMITER = ",";
    private static final String PERSON_DELIMITER = ";";

    /*public static void main(String[] args) {
        CSV serializer = new CSV();
        Annuaire annuaire;
        try {
            annuaire = serializer.importAnnuaire();
        } catch (Exception e) {
            System.out.println("Impossible d'importer l'annuaire.\nTentative d'export d'un nouvel annuaire...");
            serializer.exportAnnuaire(Annuaire.create());
            try {
                annuaire = serializer.importAnnuaire();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Impossible d'importer l'annuaire. Fermeture du programme");
                return;
            }
        }
        System.out.println(annuaire);
    }*/


    @Override
    public void exportAnnuaire(Annuaire annuaire) {
        try (FileWriter fw = new FileWriter(FILENAME)) {
            fw.append(annuaire.getName()).append(DELIMITER);
            appendPerson(annuaire.getOwner(),fw);
            annuaire.getContacts().forEach(person -> {
                // les exceptions d'une lambda sont gérées à l'intérieur même
                try {
                    appendPerson(person,fw);
                } catch (IOException e) {
                    System.out.println("Impossible d'insérer le contact : "+person.getName());
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void appendPerson(Person person, FileWriter fw) throws IOException {
        fw.append(person.getName());
        fw.append(PERSON_DELIMITER);
        fw.append(String.valueOf(person.getTel()));
        fw.append("\n");
    }

    @Override
    public Annuaire importAnnuaire() throws IOException, ClassNotFoundException {
        String [] fLine;
        List<Person> contacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            // chaque appel à la fonction readLine passe à la ligne suivante
            fLine = br.readLine().split(DELIMITER);
            br.lines().forEach( line -> contacts.add(getPerson(line)) );
        }
        return new Annuaire(fLine[0],getPerson(fLine[1]),contacts);
    }

    public Annuaire importYannis() throws IOException, ClassNotFoundException {
        String [] fLine;
        String line;
        List<Person> contacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            fLine = br.readLine().split(DELIMITER);
            while ((line = br.readLine()) != null) {
                contacts.add(getPerson(line));
            }
        }
        return new Annuaire(fLine[0],getPerson(fLine[1]),contacts);
    }

    public Annuaire importAnnuaireOpti() throws IOException, ClassNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String [] fLine = br.readLine().split(DELIMITER);
            return new Annuaire(fLine[0],getPerson(fLine[1]),br.lines().map(CSV::getPerson).toList());
        }
    }

    private static Person getPerson(String line) {
        String[] person = line.split(PERSON_DELIMITER);
        return new Person(person[0],Integer.parseInt(person[1]));
    }

}
