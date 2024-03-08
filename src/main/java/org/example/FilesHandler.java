package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FilesHandler {

    final public void handleFiles(String[] files) throws IOException {
        writeResult(process(openFiles(files)), files[files.length - 1]);
    }

    abstract String process(List<FileReader> readers) throws IOException;

    private List<FileReader> openFiles(String[] files) throws FileNotFoundException {
        List<FileReader> list = new ArrayList<>();

        for (int i = 0; i < files.length - 1; i++) {
            FileReader reader = new FileReader(files[i]);
            list.add(reader);
        }

        return list;
    }

    private void writeResult(String result, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(result);
        writer.close();
    }
}
