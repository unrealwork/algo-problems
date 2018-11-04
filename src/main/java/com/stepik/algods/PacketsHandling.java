package com.stepik.algods;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PacketsHandling {

    static class Packet {
        private final long arrival;
        private final long duration;
        private final long startTime;
        private final long endTime;

        Packet(long arrival, long duration, long startTime, long endTime) {
            this.arrival = arrival;
            this.duration = duration;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int bufferSize = scanner.nextInt();
            final int packetsAmount = scanner.nextInt();
            final Deque<Packet> buffer = new LinkedList<>();
            for (int i = 0; i < packetsAmount; i++) {
                final long arrival = scanner.nextLong();
                final long duration = scanner.nextLong();
                while (!buffer.isEmpty() && buffer.getLast().endTime <= arrival) {
                    buffer.removeLast();
                }

                if (buffer.size() == bufferSize) {
                    System.out.println(-1);
                } else {
                    final long startTime = buffer.isEmpty() ? arrival : buffer.getFirst().endTime;
                    final Packet curPacket = new Packet(arrival, duration, startTime, startTime + duration);
                    System.out.println(startTime);
                    buffer.addFirst(curPacket);
                }
            }
        }
    }
}
