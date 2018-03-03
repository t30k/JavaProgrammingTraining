package com.hackerrank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindMaximumIndexProduct2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        long[] numbers = IntStream.rangeClosed(1, n)
                .mapToLong(j -> Long.parseLong(sc.next()))
                .toArray();

        long[] products = new long[n];
        long[] left = new long[1];
        long[] right = new long[1];
        products[0] = 0;
        products[n - 1] = 0;

        IntStream.range(1, n).forEach(i -> {
            int l = i;
            left[0] = 0;
            // search for left
            IntStream.range(0, l)
                    .filter(j -> numbers[l] < numbers[j])
                    .forEach(j -> {
                        left[0] = j + 1;
                    });

            // search for right
            right[0] = IntStream.range(l, n)
                    .filter(k -> numbers[l] < numbers[k])
                    .mapToLong(k -> k + 1)
                    .findFirst()
                    .orElse(0);

            products[l] = left[0] * right[0];
        });

        System.out.println(Arrays.stream(products).max().orElse(0));
    }
}
