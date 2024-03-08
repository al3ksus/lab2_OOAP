package org.example;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FilesHandler firstHandler = new FirstFilesHandler();
        FilesHandler secondHandler = new SecondFilesHandler();
        try {
            //firstHandler.handleFiles(args);
            secondHandler.handleFiles(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}