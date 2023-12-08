import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // objet pouvant récupérer une saisie dans la console
        Scanner scanner = new Scanner(System.in);

        // Saisir du texte
        //System.out.println("Saisir du texte : ");
        /*String userStr = scanner.nextLine(); // .next() ne récupère que le prochain mot
        System.out.println(userStr);*/

        // Saisir un entier
        System.out.println("Saisir un entier : ");
        /*int userInt = scanner.nextInt();
        System.out.println(userInt);*/

        // Assurer la saisie d'un entier
        /*boolean test = true;
        do {
            try {
                scanner = new Scanner(System.in); // on doit remettre le scanner à zéro sinon sa valeur est bloqué et on boucle à l'infini
                int userIntWhile = scanner.nextInt();
                test = false;
            } catch (Exception e) {
                System.out.println("Saisie invalide");
            }
        } while (test); // fait comme une méthode récursive*/

        // Utilisation d'une fonction récursive (une vraie cette fois)
        System.out.println(getUserInt());

    }

    private static int getUserInt() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Saisie invalide");
            return getUserInt();
        }
    }
}