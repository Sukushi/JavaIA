package types;

import java.sql.Array;
import java.util.*;

public class Types {

    // déclaration de variable dans une classe : Attribut
    boolean bool; // par défaut à false

    public static void main(String[] args) {
        //region PRIMITIF
        // Les types primitifs représente les valeurs stockées en mémoire dont la taille affectée en mémoire va dépendre de ce type
        boolean aBoolean = false; //1 bit
        byte aByte = 0;                 //8 bits
        short aShort = 0;               //16 bits
        char aChar = '\u0000';          //16 bits
        int anInt = 0;                  //32 bits
        // par défaut les nombres à virgules sont considérés comme des doubles\n
        // on ajoute le f à la fin pour préciser le float
        float aFloat = 0.0f;            //32 bits
        long aLong = 0;                 //64 bits
        double aDouble = 0.0;           //64 bits
        //endregion

        //region REFERENCES
        // par opposition les types références n'ont pas de taille prédéfinie
        // pour représenter leur valeur par défaut, on utilise null
        // en Java TOUS les types références sont des Object
        Object anObject = null;
        // le types String est dit IMMUTABLE
        String aString = "String Content";
        System.out.println("Before : " + aString);
        System.out.println("Replace : " + aString.replace(" ",""));
        System.out.println("After : " + aString);

        // pour conserver les changements sur un type immutable, il faut réaffecter la valeur
        aString = aString.replace(" ","");
        System.out.println("After Reassignment : " + aString);
        //endregion

        //region WRAPPER
        Integer anIntWrapper = Integer.valueOf(0); // boxing (contenir une valeur primitive dans un Object)
        int anIntUnboxed = anIntWrapper.intValue(); // unboxing
        anIntWrapper = 10; // boxing est automatique et passe par valueOf()
        anIntUnboxed = anIntWrapper; // unboxing automatique via intValue()

        String numericString = "500";
        int anIntFromString = Integer.parseInt(numericString); // utile pour valider du texte ou des saisies utilisateur
        System.out.println(anIntFromString);
        //endregion

        //region COLLECTION
        // création du tableau avec des valeurs spécifiées (la taille du tableau dépends des valeurs données)
        // la taille d'un tableau est IMMUTABLE
        int[] anIntArray = {150,12,21};
        System.out.println(anIntArray[0]); // 150 : les index commencent à 0

        // pour créer un tableau dont je ne connais pas encore les valeurs, on précise la taille du tableau
        // la taille n'est pas l'index max car l'index commencent à 0
        String aStringArray[] = new String[10]; // type name[] = new type[length]
        System.out.println(aStringArray[5]);
        aStringArray[5] = "String Content 6";
        System.out.println(aStringArray[5]);
        // System.out.println(aStringArray[15]); génère une 'erreur' : ArrayIndexOutOfBoundsException

        boolean[][] aBooleanTable = {{true,false},{false,true,false},{}};
        System.out.println(aBooleanTable[1][1]); // true
        // assure que chaque ligne possède le même nombre de colones
        aBooleanTable = new boolean[3][5];
        System.out.println(aBooleanTable[2][3]); // false

        List<String> aStringList = new ArrayList<>();
        // System.out.println(aStringList.get(0)); IndexOutOfBoundsException
        aStringList.add("first");
        System.out.println(aStringList.get(0));
        String second = "second";
        aStringList.add(second);
        String third = "third";
        aStringList.add(0,third);
        aStringList.add("fourth");

        System.out.println(aStringList.indexOf("first")); // 1
        System.out.println(aStringList.indexOf(second)); // 2
        System.out.println(aStringList.indexOf("fifth")); // -1

        aStringList.remove(0);
        System.out.println(aStringList);
        aStringList.remove(third);
        System.out.println(aStringList);

        // il faut forcément passer par une méthode pour créer une List
        List<String> anotherStringList = List.of("first",second,third,"fourth");
        List<String> implement = Arrays.asList("first",second,third,"fourth");
        // ceci est une copie de 'aStringList'
        anotherStringList = new ArrayList<>(aStringList);


        Map<String,String> aStringMap = new HashMap<>();
        aStringMap.put("key","value");
        System.out.println(aStringMap.get("key"));
        String secondvalue = "Second Value";
        aStringMap.put(second,secondvalue);

        System.out.println(aStringMap.get(second));
        // ajoute OU remplace une valeur dans la map
        aStringMap.put(second,"New Second Value");
        System.out.println(aStringMap.get(second));
        aStringMap.replace("third",secondvalue); // ne va rien faire car la clé 'third' n'existe pas
        aStringMap.remove(second,"third"); // ne va rien faire car l'association n'existe pas
        aStringMap.remove(second); // retourne en plus la valeur associée qu'on vient de retirer de la Map
        System.out.println(aStringMap);
        //endregion
    }
}
