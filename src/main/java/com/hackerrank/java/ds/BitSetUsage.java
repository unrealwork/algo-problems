package com.hackerrank.java.ds;

import java.io.BufferedInputStream;
import java.util.BitSet;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class BitSetUsage {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final int bitSize = scanner.nextInt();
            final int opSize = scanner.nextInt();
            BitSet b1 = new BitSet(bitSize);
            BitSet b2 = new BitSet(bitSize);
            for (int i = 0; i < opSize; i++) {
                final String op = scanner.next();
                final int first = scanner.nextInt();
                final int second = scanner.nextInt();


                switch (op) {
                    case "AND":
                        bitSetBinaryOp(b1, b2, first, second, BitSet::and);
                        break;
                    case "OR":
                        bitSetBinaryOp(b1, b2, first, second, BitSet::or);
                        break;
                    case "XOR":
                        bitSetBinaryOp(b1, b2, first, second, BitSet::xor);
                        break;
                    case "SET":
                        if (first == 1) {
                            b1.set(second, true);
                        } else {
                            b2.set(second, true);
                        }
                        break;
                    case "FLIP":
                        if (first == 1) {
                            b1.flip(second);
                        } else {
                            b2.flip(second);
                        }
                        break;
                    default:
                        continue;
                }
                System.out.println(b1.cardinality() + " " + b2.cardinality());
            }
        }
    }


    private static void bitSetBinaryOp(BitSet b1, BitSet b2, int first, int second, BiConsumer<BitSet, BitSet> bitSetBiConsumer) {
        if (first == 1) {
            if (second == 1) {
                bitSetBiConsumer.accept(b1, b1);
            } else {
                bitSetBiConsumer.accept(b1, b2);
            }
        } else {
            if (second == 1) {
                bitSetBiConsumer.accept(b2, b1);
            } else {
                bitSetBiConsumer.accept(b2, b2);
            }
        }
    }
}
