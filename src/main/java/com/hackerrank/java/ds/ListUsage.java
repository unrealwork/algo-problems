package com.hackerrank.java.ds;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListUsage {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final int n = scanner.nextInt();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }
            final int operationsNumber = scanner.nextInt();
            for (int i = 0; i < operationsNumber; i++) {
                final String operation = scanner.next();
                if (operation.equals("Insert")) {
                    final int index = scanner.nextInt();
                    final int elem = scanner.nextInt();
                    list.add(index, elem);
                } else {
                    if (operation.equals("Delete")) {
                        final int index = scanner.nextInt();
                        list.remove(index);
                    } else {
                        throw new IllegalStateException("Not supported operation");
                    }
                }
            }
            System.out.println(list.stream()
                    .reduce(new StringBuilder(),
                            (sb, e) -> sb.append(e).append(' '),
                            (sb1, sb2) -> sb1
                    )
            );
        }
    }
}
