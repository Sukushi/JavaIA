package operations;

import java.util.Random;

public class Conditions {
    public static void main(String[] args) {
        Random random = new Random();

        // region Two Cases (true/false)
        int a = random.nextInt(), b = random.nextInt(5), c = random.nextInt(2,5);
        System.out.printf("a = %d ; b = %d ; c = %d%n",a,b,c);

        if (a == b && a == c) {
            System.out.println("a == b == c");
        } else {
            if (a == b) {
                System.out.println("a == b");
            } else if (a == c) {
                System.out.println("a == c");
            } else if (b == c) {
                System.out.println("b == c");
            } else {
                System.out.println("a != b != c");
            }
        }

        // plus optimisé car on devrait parcourir moins de conditions
        // toujours essayer de trouver les cas extremes d'abord (en termes de syntaxe)
        if (a == b && a == c) {
            System.out.println("a == b == c");
        } else if (a != b && b != c && a != c) {
            System.out.println("a != b != c");
        } else {
            if (a == c) {
                System.out.println("a == c");
            } else if (b == c) {
                System.out.println("b == c");
            } else {
                System.out.println("a == b");
            }
        }

        boolean condition = random.nextBoolean();
        if (condition) {
            System.out.println("Condition is true");
        } else {
            System.out.println("Condition is false");
        }
        // pareil en plus court
        String result= condition ? "true" : "false";
        System.out.println(result);
        // encore plus court
        System.out.println("Condition : " + (random.nextBoolean() ? "true" : "false"));
        //endregion

        //region Multiple Cases
        switch (random.nextInt(5)) { // From 0 to 4
            case 0:
                System.out.println("min value");
                break;
            case 2 :
                System.out.println("mid value");
                break;
            case 4 :
                System.out.println("max value");
                break;
            default:
                System.out.println("odd value");
        }

        // syntaxe "améliorée"
        switch (random.nextInt(5)) { // From 0 to 4
            case 0 -> System.out.println("min value");
            case 2 -> {
                System.out.println("mid value");
            }
            case 4 -> System.out.println("max value");
            default -> System.out.println("odd value");
        }

        // case avec retour
        System.out.println(switch (random.nextInt(5)) { // From 0 to 4
            case 0 -> "min value";
            case 2 -> {
                String s = "mid value";
                s += " number 2";
                yield s; // équivalent du return mais pour sortir seulement du switch and pas fermer le main
            }
            case 4 -> "max value";
            default -> "odd value";
        });

        System.out.println(switch (b) {
            case 0 -> "Origin Value\nLower Half";
            case 1 -> "Lower Half";
            case 2 -> "Mid Value";
            case 3 -> "Upper Half";
            case 4 -> "Bound Value\nUpper Half";
            default -> "";
        });


        System.out.println("--- Switch Exercice ---");
        b = 4;

        String s = "";
        switch (b) {
            case 0 :
                s += "Origin Value\n";
            case 1:
                s += "Lower Half";
                break;
            case 2 :
                s+="Mid Value";
                break;
            case 4:
                s+="Bound Value\n";
            case 3 :
                s+="Upper Half";
                break;
        }; System.out.println(s);

        System.out.println("-----");

        s = "";
        System.out.println(switch (b) {
            case 0 :
                s = "Origin Value\n";
            case 1:
                s += "Lower Half";
                yield s;
            case 2 :
                yield "Mid Value";
            case 4:
                s="Bound Value\n";
            case 3 :
                s+="Upper Half";
                yield s;
            default:
                yield "Case out of bound";
        });
        //Correction : on pourrait passer le cas 2 en default pour gagner quelques lignes

        //endregion
    }
}
