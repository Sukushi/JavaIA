package operations;

import java.util.Random;

public class MathsOperations {
    public static void main(String[] args) {
        //region Conversion implicite
        int anInt = 10;
        double aDouble = 9.36;
        float aFloat = 5.81f;

        double aDoubleFromInt = anInt;
        float aFloatFromInt = anInt;

        int anIntFromDouble = (int) aDouble; // caster signifie forcer une conversion de type
        float aFloatFromDouble = (float) aDouble;
        System.out.println(anIntFromDouble); // on perd l'arrondi à cause du cast et donc de la précision

        int intResult = anInt + anInt;
        double aDoubleResult = anInt + aDouble;
        int anIntResultFromDouble = anInt + (int) aDouble;
        int anIntResultFromDouble2 = (int) (anInt + aDouble);
        //endregion

        // region STRING
        String aString = "String Content";
        System.out.println(aString + " String added");
        System.out.println(aString + " and an int : " + anInt);
        aString += " and a double : ";
        System.out.println(aString);
        aString += aDouble;
        System.out.println(aString);
        aString = aString.substring(0,14); // ne garde que les caractères d'index 0 à 14
        System.out.println(aString);
        /*
        * %s : String
        * %d : nombre (entier)
        * %f : personnalisable avec le nombre de digits avant et après la virgule
        * %n : saut de ligne
        * */
        System.out.println(String.format("%s and a float : %.3f !",aString,aFloat));
        //endregion

        // region Random
        Random random; // random est déclaré et un nom de variable ne peut pas se déclarer deux fois
        random = new Random(); // random est initialisé (peut se faire sur la ligne de la déclaration)

        boolean randomBoolean = random.nextBoolean();
        int randomInt = random.nextInt();
        int randomIntBound = random.nextInt(10); // bound exclus
        int randomIntRange = random.nextInt(3,10); // origin inclus | bound exclus
        long randomLong = random.nextLong();
        double[] randomDoubleArray = random.doubles(5).toArray(); // tableau de 5 double aléatoire
        int[] randomIntArray = random.ints(5, 21, 101).toArray();

        //endregion
    }
}
