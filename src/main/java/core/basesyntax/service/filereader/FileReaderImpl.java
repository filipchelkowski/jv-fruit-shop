package core.basesyntax.service.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String fileName) {
        Path filePath = Path.of(fileName);
        List<String> result;

        try {
            result = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        return result;
    }
}
