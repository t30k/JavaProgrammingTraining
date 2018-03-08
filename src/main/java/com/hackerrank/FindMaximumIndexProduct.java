package com.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FindMaximumIndexProduct {
    public static void main(String[] args) {
        try {
//            Scanner sc = new Scanner(System.in);
//            final int n = Integer.parseInt(sc.nextLine());
//            long[] numbers = IntStream.rangeClosed(1, n)
//                    .mapToLong(j -> Long.parseLong(sc.next()))
//                    .toArray();
            File file = new File("../JavaProgrammingTraining/src/main/java/com/hackerrank/text/fmip3.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            int n = Integer.parseInt(br.readLine());
            String[] lines = br.readLine().split(" ");
            long[] numbers = Arrays.stream(lines).mapToLong(s -> Long.parseLong(s)).toArray();
            long[] products = new long[n];

            long start = System.currentTimeMillis();

            for (int i = 1; i < n; i++) {
                // search for left
                long left = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (numbers[i] < numbers[j]) {
                        left = j + 1;
                        break;
                    }
                }
                // search for right
                long right = 0;
                for (int k = i; k < n; k++) {
                    if (numbers[i] < numbers[k]) {
                        right = k + 1;
                        break;
                    }
                }
                products[i] = left * right;
            }

            long end = System.currentTimeMillis();
            System.out.println((end - start) + "ms");
            System.out.println(Arrays.stream(products).max().orElse(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
