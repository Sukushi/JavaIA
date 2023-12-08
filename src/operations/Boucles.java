package operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Boucles {

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            //System.out.println(i);
        }

        int origin = random.nextInt(1,10), bound = origin + random.nextInt(1,origin+1);
        System.out.printf("Origin : %d | Bound : %d%n",origin,bound);
        for (int i = origin; i < bound; i++) {
            //System.out.println(i);
        }

        //region clinique.exercice affichage d'un int[]
        int[] anIntArray = random.ints(origin,origin,bound).toArray();
        for (int i = 0; i < anIntArray.length; i++) {
            //System.out.printf("Index : %d | Value : %d%n",i,anIntArray[i]);
        }
        // my foreach solution
        String strIntArray = "anIntArray : [";
        for (int value : anIntArray) {
            strIntArray += value + ", ";
        }; strIntArray = strIntArray.substring(0,strIntArray.length()-2)+"]";
        System.out.println(strIntArray);
        // Yannis foreach solution
        System.out.print("anIntArray : [");
        int iteration = 0;
        for (int value : anIntArray) {
            iteration++;
            System.out.print(value + (iteration != anIntArray.length ? ", " : "]\n"));
        };
        // my fori solution
        System.out.print("anIntArray : [");
        for (int i = 0; i < anIntArray.length; i++)
            System.out.print(anIntArray[i] + (i != anIntArray.length-1 ? ", " : "]\n"));
        // Yannis stream solution
        System.out.printf("anIntArray : [%s]%n",Arrays.stream(anIntArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
        // my sadique solution
        System.out.println("anIntArray : "+Arrays.toString(anIntArray));
        //endregion

        //region clinique.exercice affiche d'un boolean[][]
        // true/false table
        boolean[][] aBooleanTable = new boolean[random.nextInt(origin,bound)][random.nextInt(origin,bound)];
        for (int i = 0; i < aBooleanTable.length; i++) {
            for (int j = 0; j < aBooleanTable[i].length; j++) {
                aBooleanTable[i][j] = random.nextBoolean();
            }
        }
        // System.out.println(Arrays.deepToString(aBooleanTable).replace("], ","],\n "));
        // my O/X table
        String aBooleanTableOXString = Arrays.deepToString(aBooleanTable);
        System.out.println(aBooleanTableOXString.substring(1,aBooleanTableOXString.length()-1)
                .replace("], ","]\n")
                .replace("true","O").replace("false","X"));
        // my String answer
        String[][] aBooleanStringTable = new String[random.nextInt(origin,bound)][random.nextInt(origin,bound)];
        for (int i = 0; i < aBooleanStringTable.length; i++) {
            for (int j = 0; j < aBooleanStringTable[i].length; j++) {
                aBooleanStringTable[i][j] = random.nextBoolean() ? "O" : "X";
            }
        }
        // System.out.println(Arrays.deepToString(aBooleanStringTable).replace("], ","],\n "));
        // Yannis true/false table display fori
        for (int i = 0; i < aBooleanTable.length; i++) {
            System.out.print('[');
            for (int j = 0; j < aBooleanTable[i].length; j++) {
                System.out.print(aBooleanTable[i][j] ? 'O':'X');
            }
            System.out.println(']');
        }
        // Yannis true/false table display foreach
        for (boolean[] i : aBooleanTable) {
            System.out.print('[');
            for (boolean j : i) {
                System.out.print(j ? 'O':'X');
            }
            System.out.println(']');
        }
        //endregion

        //region while
        boolean condition = false;
        // while
        while (condition) {
            System.out.println("cannot be reach because condition is false");
        }
        // do while
        do {
            System.out.println("sera exécuté au moins une fois même si condition est toujours faux");
        } while (condition);

        List<Integer> aIntegerList = new ArrayList<>();
        for(int value : anIntArray) {
            aIntegerList.add(value);
        }
        // une boucle avec itération
        int whileItr = 0;
        while(whileItr < aIntegerList.size()) {
            System.out.println(aIntegerList.get(whileItr));
            whileItr++;
        }
        // comment faire une boucle infinie
        while(true) {
            break;
        }

        System.out.print("aIntegerList : [");
        aIntegerList.forEach(value -> System.out.print(value));
        System.out.println("]");
        //endregion

    }
}
