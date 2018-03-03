package com.hackerrank;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SparseArrays2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            List<String> numbers = getStrings(sc, getNumber(sc));
            List<String> queries = getStrings(sc, getNumber(sc));
            queries.stream().forEach(s -> {
                long count = queryMatchCount(numbers, s);
                output(count);
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    static int getNumber(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine());
        if (isSizeMissMatch(n)) {
            System.exit(0);
        }
        return n;
    }

    static List<String> getStrings(Scanner sc, int l) {
        return IntStream.rangeClosed(1, l)
                .mapToObj(s -> sc.nextLine())
                .collect(Collectors.toCollection(LinkedList::new));
    }

    static boolean isSizeMissMatch(int num) {
        return !(num >= 1 && num <= 1000);
    }

    static long queryMatchCount(List<String> numbers, String s) {
        return numbers.stream()
                .filter(v -> v.equals(s))
                .count();
    }

    static void output(long count) {
        System.out.println(count);
    }
}
