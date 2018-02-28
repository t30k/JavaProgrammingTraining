package com.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SparseArrays {

    public static void main(String[] args) {
        try {
            File file = new File("../JavaProgrammingTraining/src/main/java/com/hackerrank/text/sa.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();
            String n[] = new String[Integer.parseInt(str)];
            str = br.readLine();
            for (int i = 0; i < n.length; i++) {
                n[i] = str;
                str = br.readLine();
            }
            int querySize = Integer.parseInt(str);
            str = br.readLine();
            for (int i = 0; i < querySize; i++) {
                long count = queryMatchCount(n, str);
                output(count);
                str = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static long queryMatchCount(String[] n, String q) {
        return Arrays.stream(n).filter(v -> v.equals(q)).count();
    }

    static void output(long count) {
        System.out.println(count);
    }
}
