public class BruteForce {

    public static void decrypt(String text) {

        for (int key = 0;
             key < CaesarCipher.getAlphabetSize();
             key++) {

            System.out.println("\nКлюч: " + key);

            String decrypted =
                    CaesarCipher.decrypt(text, key);

            System.out.println(decrypted);

            System.out.println("----------------");
        }
    }
}