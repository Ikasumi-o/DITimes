package de.riagade.bot.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class ResourcesHelper {

    public static String getResourceFileContent(ClassLoader classLoader, String fileName){
        try {
            File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
            return fileName;
        }
    }
}
