import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== ШИФР ЦЕЗАРЯ =====");
            System.out.println("1. Шифрование");
            System.out.println("2. Расшифровка");
            System.out.println("3. Brute Force");
            System.out.println("0. Выход");

            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    encrypt(scanner);
                    break;

                case "2":
                    decrypt(scanner);
                    break;

                case "3":
                    bruteForce(scanner);
                    break;

                case "0":
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void encrypt(Scanner scanner) {

        try {

            System.out.print("Введите путь к входному файлу: ");
            String input = scanner.nextLine();

            System.out.print("Введите путь к выходному файлу: ");
            String output = scanner.nextLine();

            System.out.print("Введите ключ: ");
            int key = Integer.parseInt(scanner.nextLine());

            Validator.validateFile(input);

            String text = FileManager.read(input);

            String encrypted =
                    CaesarCipher.encrypt(text, key);

            FileManager.write(output, encrypted);

            System.out.println("Файл зашифрован.");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void decrypt(Scanner scanner) {

        try {

            System.out.print("Введите путь к входному файлу: ");
            String input = scanner.nextLine();

            System.out.print("Введите путь к выходному файлу: ");
            String output = scanner.nextLine();

            System.out.print("Введите ключ: ");
            int key = Integer.parseInt(scanner.nextLine());

            Validator.validateFile(input);

            String text = FileManager.read(input);

            String decrypted =
                    CaesarCipher.decrypt(text, key);

            FileManager.write(output, decrypted);

            System.out.println("Файл расшифрован.");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void bruteForce(Scanner scanner) {

        try {

            System.out.print("Введите путь к файлу: ");
            String input = scanner.nextLine();

            Validator.validateFile(input);

            String text = FileManager.read(input);

            BruteForce.decrypt(text);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}