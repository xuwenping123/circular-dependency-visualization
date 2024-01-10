package org.github.circular.dependency.visualization.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    public static List<String> readerFileLines(String filePath) throws IOException {
        Path path = Paths.get(".", filePath);
        System.out.println(path.toString());
//          InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filePath);
//            new File(inputStream).toPath();
        return Files.readAllLines(path);
    }
}
