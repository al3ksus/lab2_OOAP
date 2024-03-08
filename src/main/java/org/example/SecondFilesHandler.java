package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SecondFilesHandler extends FilesHandler {
    @Override
    String process(List<FileReader> readers) throws IOException {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        List<String> words;
        int c = 0;

        while((c = readers.get(0).read()) != -1){
            temp.append((char) c);
        }

        words = List.of(temp.toString().split(" "));
        temp = new StringBuilder();

        for (int i = 1; i < readers.size(); i++) {
            c = 0;
            while((c = readers.get(i).read()) != -1){
                temp.append((char) c);
            }
            for (String word : words) {
                if (temp.toString().contains(word)) {
                    result.append(temp);
                    result.append('\n');
                    break;
                }
            }
            temp = new StringBuilder();
            readers.get(i).close();
        }

        return result.toString();
    }
}
