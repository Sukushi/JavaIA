import exceptions.TryCatch;
import flux.Streams;
import objects.Jardin;
import operations.MathsOperations;
import types.Types;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Exercice {

    private static final List<String> contents = List.of(
            "Types",
            "Operations",
            "Objects",
            "Flux",
            "Exceptions"
    );

    private static final List<Method> contentsClass;
    static {
        try {
            contentsClass = List.of(
                    Types.class.getMethod("main", String[].class),
                    MathsOperations.class.getMethod("main", String[].class),
                    Jardin.class.getMethod("main", String[].class),
                    Streams.class.getMethod("main", String[].class),
                    TryCatch.class.getMethod("main", String[].class)
            );
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private final static Map<String, Consumer<String[]>> contentsNamed = Map.of(
        "Types",Types::main,
        "Operations",MathsOperations::main,
        "Objects",Jardin::main,
        "Flux",Streams::main,
        "Exceptions",TryCatch::main
    );

    private static final List<String> keys = contentsNamed.keySet().stream().toList();

    public static void main(String[] args) throws Exception {
        //int userChoice = getUserChoice();

        /*switch (userChoice) {
            case 0:
                Types.main(null);
                main(null);
                break;
            case 1:
                MathsOperations.main(null);
                main(null);
                break;
            case 2:
                Jardin.main(null);
                main(null);
                break;
            case 3:
                Streams.main(null);
                main(null);
                break;
            case 4:
                TryCatch.main(null);
                main(null);
                break;
            case -1:
                break;
            default:
                System.out.println("L'index ne correspond à aucun choix valide");
                main(null);
                break;
        }*/

        /*if (userChoice >= 0 && userChoice < contentsClass.size()) {
            try {
                contentsClass.get(userChoice).invoke(null, (Object) null);
                main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (userChoice != -1) {
            System.out.println("L'index ne correspond pas");
            main(null);
        }*/

        displayYannis(args);
        // args dans le cas où une des méthodes main qu'on va appeler a besoin d'une entrée
    }

    private static int getUserChoice() {
        Scanner scanner;
        try {
            scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Saisie invalide, veuillez réessayer");
            return getUserChoice();
        }
    }

    private static void displayContents() {
        System.out.println("Saisissez le programme à lancer");
        for (int i = 0; i < contents.size(); i++) {
            System.out.printf(" %s -> %s%n",i,contents.get(i));
        }
    }

    private static void displayYannis(String[] args) {
        System.out.println("Saisissez le programme à lancer");
        for (String key : keys) {
            System.out.printf(" %d -> %s%n",keys.indexOf(key),key);
        }
        System.out.println("-1 -> Quitter");
        startMain(getUserChoice(), args);
    }

    private static void startMain(int index, String[] args) {
        // faire un return dans un void permet de sortir de la méthode
        if (index == -1) return;
        try {
            contentsNamed.get(keys.get(index)).accept(args);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Veuillez saisir un nombre valide !");
        }
        displayYannis(args);
    }

}
