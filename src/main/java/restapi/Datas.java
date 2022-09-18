package restapi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Datas {

    static ObjectMapper objectMapper;
    static StringBuilder contentBuilder;

    static String readJsonData() {

        String dataFileName;
        String dataFilePath;
        String filePath;

        dataFileName = Util.getProperty("DATA", true);

        filePath = Util.getFilePath(Util.getProperty("path", false));

        dataFilePath = System.getProperty("user.dir") + filePath + dataFileName;

        contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(dataFilePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
