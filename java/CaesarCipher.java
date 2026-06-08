public class CaesarCipher {

    private static final String ALPHABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "abcdefghijklmnopqrstuvwxyz" +
                    "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
                    "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
                    "0123456789 .,!?;:-()\"'\n";

    public static String encrypt(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (char symbol : text.toCharArray()) {

            int index = ALPHABET.indexOf(symbol);

            if (index != -1) {

                int newIndex =
                        (index + key) % ALPHABET.length();

                if (newIndex < 0) {
                    newIndex += ALPHABET.length();
                }

                result.append(ALPHABET.charAt(newIndex));

            } else {
                result.append(symbol);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, -key);
    }

    public static int getAlphabetSize() {
        return ALPHABET.length();
    }
}