package flux;

import java.text.DateFormatSymbols;
import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    static String[] months = DateFormatSymbols.getInstance().getMonths();

    public static void main(String[] args) {
        System.out.println("--- display le tableau en foreach ---");
        // Example 1
        for (String month : months) System.out.println(month);

        // Same as this
        System.out.println("--- display le tableau en stream ---");
        // Consumer : prends un paramètre d'un type et ne retourne rien (void)
        // le flux fait gagner en perf
        Arrays.stream(months).forEach(System.out::println); // .forEach(month -> System.out.println(month));

        System.out.println("--- sous forme de tableau ---");
        // Les streams permettent d'enchaîner les actions jusqu'à une opération dite 'terminale'
        List<String> monthsList = Arrays.stream(months).toList();
        System.out.println(monthsList);

        System.out.println("--- mois Upper Case ---");
        // le stream est 'tampon' : les modifications qu'il apporte ne sont pas conservés par défaut
        monthsList.stream()
                .map(String::toUpperCase) // a -> a.toUpperCase()
                .forEach(System.out::println);

        // si on veut garder les modifications il faut expliquer le dire
        List<String> monthsUpper = monthsList.stream().map(String::toUpperCase).toList();

        System.out.println("--- mois dont la taille du nom est égal à 4 ---");
        // filter récupère des données en fonction d'une condition
        // prédicat : prends un paramètre et attends un boolean en retour
        monthsList.stream().filter(a -> a.length() == 4).forEach(System.out::println);

        System.out.println("--- nombre de string vide dans la liste ---");
        System.out.println(monthsList.stream().filter(String::isEmpty).count()); // ou '.isBlank' qui compte aussi les "   "

        System.out.println("--- remplacer par une liste contenant les mois non 'Blank' ---");
        // on ne peut pas utiliser l'opposé d'un prédicat dans une Method Reference
        List<String> monthsBlank = monthsList.stream().filter(a -> !a.isBlank()).toList();
        System.out.println(monthsBlank);

        System.out.println("--- mars avril mai juin aout ---");
        System.out.println(monthsBlank.stream().filter(a -> a.length() <= 5).collect(Collectors.joining(", ")));

        System.out.println("--- y-a-t'il un caractère spécial ? ---");
      //System.out.println(monthsBlank.stream().filter(a -> !a.matches("[a-z]*")).count() > 0)
        System.out.println(monthsBlank.stream().anyMatch(a -> a.matches(".*[ûéè].*")));

        System.out.println("--- nombre total de lettre(s) ---");
        System.out.println(monthsBlank.stream()
                .map(String::length)
                // réduire l'ensemble des éléments de la liste en un seul du même type
                .reduce(0, Integer::sum) // 0 : valeur de départ (identity) | sum : (a,b) -> a + b
                // ou '.mapToInt(Integer::intValue).sum()' qui passe par un stream de type primitif 'int' avec un accès à de nouvelles méthodes spécifiques
                // ou 'collect (Collectors.joining("")).length()' qui crée une String concaténant tous les mois et qui prend sa taille
        );

        System.out.println("--- les trois mois ayant le plus grand nombre de lettres : ---");
        monthsBlank.stream()
                // le tri se base sur une valeur numérique :
                // -> négative : 'a' doit être avant 'b'
                // -> positive : 'a' doit être après 'b'
                // -> zéro : 'a' vaut 'b'
                .sorted((a,b) -> b.length() - a.length())
                .limit(3)
                // .toList().subList(0,3) si on veut s'embêter
                .forEach(System.out::println);
        // si on veut trier dans l'autre sens
        monthsBlank.stream()
                .sorted(Comparator.comparingInt(String::length)) // '(a,b) -> a.length() - b.length()'
                .skip(monthsBlank.size() - 3);



    }

}
