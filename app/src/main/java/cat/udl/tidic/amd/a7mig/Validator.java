package cat.udl.tidic.amd.a7mig;

public class Validator {

    public static boolean nomValidator(String nom) {
        return nom.matches ("^[a-z]{3,7}$");
    }

    public static boolean apostesValidator(int aposta) {
        return aposta >= 5 && aposta <= 1000;
    }

    public static boolean isValid(String nom, int aposta) {
        return nomValidator(nom) && apostesValidator(aposta);
    }
}
