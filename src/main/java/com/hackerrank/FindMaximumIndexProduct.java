package com.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FindMaximumIndexProduct {
    public static void main(String[] args) {
        try {
            File file = new File("../JavaProgrammingTraining/src/main/java/com/hackerrank/text/fmip.txt");
            BufferedReader bf = new BufferedReader(new FileReader(file));
            int n = Integer.parseInt(bf.readLine());
            String numbers = bf.readLine();
            String[] splitNumbers = numbers.split(" " );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
