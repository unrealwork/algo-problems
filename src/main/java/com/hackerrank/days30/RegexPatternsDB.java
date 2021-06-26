package com.hackerrank.days30;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class RegexPatternsDB {
    private static final Pattern GMAIL_PATTERN = Pattern.compile("^[a-z.]+@gmail[.]com$");

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> list = new LinkedList<>();
        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];

                String emailID = firstMultipleInput[1];
                if (GMAIL_PATTERN.matcher(emailID).matches()) {
                    list.add(firstName);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        list.stream().sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);
        bufferedReader.close();
    }
}
