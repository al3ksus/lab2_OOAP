package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FirstFilesHandler extends FilesHandler {
    @Override
    String process(List<FileReader> readers) throws IOException {
        StringBuilder result = new StringBuilder();
        int c;

        for (FileReader reader : readers) {
            c = 0;
            while((c = reader.read()) != -1){
                result.append((char) c);
            }
            result.append('\n');
            reader.close();
        }

        return result.toString().toUpperCase();
    }
}
