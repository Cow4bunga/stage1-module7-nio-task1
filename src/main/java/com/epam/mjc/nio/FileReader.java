package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile=new Profile();
        Path path= Paths.get(file.toURI());
        try(BufferedReader inputStream= Files.newBufferedReader((path), StandardCharsets.UTF_8)) {
            profile.setName(inputStream.readLine().substring(6));
            profile.setAge(Integer.parseInt(inputStream.readLine().substring(5)));
            profile.setEmail(inputStream.readLine().substring(7));
            profile.setPhone(Long.parseLong(inputStream.readLine().substring(7)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
