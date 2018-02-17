package com.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class StreamUtils {

  public static String toString(InputStream stream) {
    return new BufferedReader(new InputStreamReader(stream))
        .lines().collect(Collectors.joining(System.lineSeparator()));
  }
}
