package exceptions;

public class TryCatch {

    /*
    * Les 3 types d'erreur dites 'Throwable'
    * Error            : Ne dépends pas du code, mais de l'environnement d'exécution
    * Exception        : Le cas le plus classique pour indiquer un défaut de programmation
    * RuntimeException : Représente des problèmes liés aux données utilisées durant l'exécution du programme
    * */

    public static void main(String[] args) {
        String nullString = null;
        try {
            nullString.replace(";"," ");
        } catch (NullPointerException e) {
            nullString = "quelque chose";
            nullString.replace(" ","");
            System.out.println("problème régler : "+nullString);
        }

        try {
            int[] anIntArray = new int[5];
            System.out.println("anIntArray = " + anIntArray[5]);
        } catch (Exception e) {
            System.out.println("e.getClass().getSimpleName() = " + e.getClass().getSimpleName());
            System.out.println("e.getMessage() = " + e.getMessage());
            // affiche l'erreur comme d'hab mais sans planter le code
            // et s'affiche toujours à la fin de la console peu importe le code qui suit
            e.printStackTrace();
            // pour afficher "dans l'ordre" mais sans couleur
            e.printStackTrace(System.out);
        }
        System.out.println("Something");

        try {
            throwsException(); // bloque le Run si hors Try ou pas de Throws
            throwRuntimeException(); // peut être mis n'importe où dans le code sans bloquer le Run
        } catch (Exception e) {
            System.out.println("Exception catch");
        }
        try {
            throwsException();
            throwRuntimeException();
            throwError(); // peut être mis n'importe où dans le code sans bloquer le Run
        } catch (Exception e) {
            System.out.println("Exception : "+e);
        } catch (Throwable e) {
            System.out.println("Error catch");
        }
        /* --- Héritage ---
        * Throwable -> Error
        *           -> Exception -> Runtime Exception
        *                       (-> Custom Exception)
        * */

        try {
            throwCustom();
            throwCustomRuntime();
        } catch (CustomException | CustomRuntimeException e) {
            System.out.println(e);
        } finally {
            System.out.println("fait dans tout les cas, qu'on n'ai choppé une erreur ou pas !");
        }

    }

    private static void throwsException() throws Exception {
        throw new Exception("Generic Exception");
    }

    private static void throwRuntimeException() /*throws RuntimeException*/ {
        throw new RuntimeException();
    }

    private static void throwError() /*throws Error*/ {
        throw new Error();
    }

    private static void throwCustomRuntime() throws CustomRuntimeException {
        throw new CustomRuntimeException();
    }

    private static void throwCustom() throws CustomException {
        throw new CustomException();
    }

    private static int addPositive(int a, int b) throws CustomException {
        if (a<0 || b<0) {
            throw new CustomException();
            // throwCustom();
        } else {
            return a+b;
        }
    }

}
