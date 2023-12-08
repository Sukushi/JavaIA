package flux.lambda;

public class Lambdas {

    public static void main(String[] args) {
        Stringifier stringifier = new Stringifier();
        soutCurrencyAmount(stringifier);

        // création d'une classe implémentant l'interface CurrencyStringifier
        // s'épargne la création du fichier
        CurrencyStringifier cs = new CurrencyStringifier() {
            @Override
            public String convert(double amount) {
                return String.format("%.2f $",amount);
            }
        };
        soutCurrencyAmount(cs);

        // Same as
        CurrencyStringifier currencyStringifier = amount -> String.format("%.2f £",amount);
        soutCurrencyAmount(currencyStringifier);

        // Same as
        soutCurrencyAmount(amount -> String.format("%.2f µ",amount));

        soutCurrencyAmount(amount -> String.valueOf(amount));
        // Passage par Method Reference
        soutCurrencyAmount(String::valueOf);
        soutCurrencyAmount(stringifier::convert);
    }

    private static void soutCurrencyAmount(CurrencyStringifier stringifier) {
        double amount = 143.94732567;
        System.out.println(stringifier.convert(amount));
    }

}
