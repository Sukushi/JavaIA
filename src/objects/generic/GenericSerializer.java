package objects.generic;

import serialization.*;

import java.io.IOException;

public class GenericSerializer<TYPE extends Serializer> {

    private final TYPE serializer;

    public GenericSerializer(TYPE serializer) {
        this.serializer = serializer;
    }

    public static void main(String[] args) {
        /*GenericSerializer<Integer> intSerializer = new GenericSerializer<>(1);
        GenericSerializer<String> stringSerializer = new GenericSerializer<>("");
        GenericSerializer<Person> personSerializer = new GenericSerializer<>(new Person());*/

        GenericSerializer<Serializer> txtSerializer = new GenericSerializer<>(new TXT());
        txtSerializer.serialize();

        System.out.println("-----");

        GenericSerializer<Serializer> csvSerializer = new GenericSerializer<>(new CSV());
        csvSerializer.serialize();
    }

    public void serialize() {
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
    }
}
