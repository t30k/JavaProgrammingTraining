package com.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SparseArrays {

    public static void main(String[] args) {
        try {
            File file = new File("../JavaProgrammingTraining/src/main/java/com/hackerrank/text/sa.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            final int n = Integer.parseInt(br.readLine());
            if (isSizeMissMatch(n)) return;
            List<String> list = new ArrayList<>();
            Stream<String> nlines = br.lines();
            nlines.limit(n).forEach(l -> {
                list.add(l);
            });
            final int q = Integer.parseInt(br.readLine());
            if (isSizeMissMatch(q)) return;
            Stream<String> qlines = br.lines();
            qlines.limit(q).forEach(l -> {
                long count = queryMatchCount(list, l);
                output(count);
            });
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean isSizeMissMatch(int num) {
        return !(num >= 1 && num <= 1000);
    }

    static long queryMatchCount(List<String> list, String l) {
        return list.stream().filter(v -> v.equals(l)).count();
    }

    static void output(long count) {
        System.out.println(count);
    }
}
