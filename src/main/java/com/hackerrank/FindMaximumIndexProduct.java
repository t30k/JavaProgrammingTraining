package com.hackerrank;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class FindMaximumIndexProduct {
    public static void main(String[] args) {
        try {
//            Scanner sc = new Scanner(System.in);
//            final int n = Integer.parseInt(sc.nextLine());
//            long[] numbers = IntStream.rangeClosed(1, n)
//                    .mapToLong(j -> Long.parseLong(sc.next()))
//                    .toArray();
            File file = new File("../JavaProgrammingTraining/src/main/java/com/hackerrank/text/fmip.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            int n = Integer.parseInt(br.readLine());
            String[] lines = br.readLine().split(" ");
            System.out.println(lines.length);
            long[] numbers = Arrays.stream(lines).mapToLong(s -> Long.parseLong(s)).toArray();
            long[] products = new long[n];
//            products[0] = 0;
            products[n - 1] = 0;

            IntStream.range(1, n).forEach(i -> {
                int l = i;
                // search for left
                long left = IntStream.range(0, l)
                        .boxed()
                        .sorted(Comparator.reverseOrder())
                        .filter(j -> numbers[l] < numbers[j])
                        .mapToLong(j -> j + 1)
                        .findFirst()
                        .orElse(0);

                // search for right
                long right = IntStream.range(l, n)
                        .filter(k -> numbers[l] < numbers[k])
                        .mapToLong(k -> k + 1)
                        .findFirst()
                        .orElse(0);

                products[l] = left * right;
            });

            System.out.println(Arrays.stream(products).max().orElse(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
