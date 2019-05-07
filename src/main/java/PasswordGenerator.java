import java.util.Random;

public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";

    public String generatePassword(int amountOfLetters) {
        StringBuilder sb = new StringBuilder();
        String set = LOWER + UPPER + DIGITS + PUNCTUATION;
        Random random = new Random();

        for (int i = 0; i < amountOfLetters; i++) {
            int randomtInt = random.nextInt(set.length());
            sb.append(set.charAt(randomtInt));
        }
        return sb.toString();
    }
}
