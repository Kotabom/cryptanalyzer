import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public static void validateFile(String path) {

        if (!Files.exists(Path.of(path))) {

            throw new IllegalArgumentException(
                    "Файл не найден: " + path
            );
        }
    }
}