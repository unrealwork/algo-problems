package com.hackerrank.algorithms.recursion;

import com.hackerrank.Solution;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;

// TODO: Refactor
public class CrosswordPuzzle implements Solution {

  private static char[][] solution;

  static String[] crosswordPuzzle(String[] crossword, String hints) {
    char[][] startCrossword = new char[10][];
    for (int i = 0; i < 10; i++) {
      startCrossword[i] = crossword[i].toCharArray();
    }
    List<String> words = Arrays.asList(hints.split(";"));
    PriorityQueue<String> restWords = queue(words);
    crosswordPuzzleRec(startCrossword,
        restWords, Optional.empty(),
        false, 0, 0);
    return Arrays.stream(solution).map(String::new)
        .toArray(String[]::new);
  }

  private static PriorityQueue<String> queue(Collection<String> words) {
    PriorityQueue<String> restWords = new PriorityQueue<>();
    restWords.addAll(words);
    return restWords;
  }

  public static char[][] cloneCrossword(char[][] input) {
    char[][] copy = new char[input.length][];
    for (int i = 0; i < input.length; i++) {
      copy[i] = new char[input[i].length];
      for (int j = 0; j < input[i].length; j++) {
        copy[i][j] = input[i][j];
      }
    }
    return copy;
  }

  static boolean fitWord(char[][] crossword, String currentWord,
      boolean isHorizontal, int curI, int curJ) {
    int length = currentWord.length();
    if (isHorizontal) {
      int j = curJ;
      int lastIndex = length + curJ;
      if (lastIndex > 10) {
        return false;
      }
      while (j < 10 && j < lastIndex) {
        char symbol = crossword[curI][j];
        int wordIndex = j - curJ;
        if (symbol == '-') {
          //empty - fill with letter
          crossword[curI][j] = currentWord.charAt(wordIndex);
        } else {
          // edge
          if (symbol == '+') {
            return false;
          } else {
            // letter
            if (symbol != currentWord.charAt(wordIndex)) {
              return false;
            }
          }
        }
        j++;
      }
      // Finish word
      if (j >= 10 || crossword[curI][j] == '+') {
        return true;
      }
    } else {
      int i = curI;
      int lastIndex = length + curI;
      if (lastIndex > 10) {
        return false;
      }
      while (i < 10 && i < lastIndex) {
        char symbol = crossword[i][curJ];
        int wordIndex = i - curI;
        if (symbol == '-') {
          //empty - fill with letter
          crossword[i][curJ] = currentWord.charAt(wordIndex);
        } else {
          // edge
          if (symbol == '+') {
            return false;
          } else {
            // letter
            if (symbol != currentWord.charAt(wordIndex)) {
              return false;
            }
          }
        }
        i++;
      }
      // Finish word
      if (i >= 10 || crossword[i][curJ] == '+') {
        //correct word - try to fit next word
        return true;
      }
    }
    return false;
  }

  static void crosswordPuzzleRec(char[][] crossword,
      PriorityQueue<String> restWords,
      Optional<String> wordOptional,
      boolean isHorizontal,
      int curI, int curJ
  ) {
    if (!wordOptional.isPresent() && restWords.size() == 0) {
      solution = crossword;
    } else {
      if (wordOptional.isPresent()) {
        if (fitWord(crossword, wordOptional.get(), isHorizontal, curI, curJ)) {
          crosswordPuzzleRec(crossword, restWords, Optional.empty(),
              false, 0, 0);
        }
      } else {
        for (int i = curI; i < 10; i++) {
          for (int j = curJ; j < 10; j++) {
            char symbol = crossword[i][j];
            if (symbol != '+') {
              if (j + 1 < 10 && crossword[i][j + 1] == '-' && ((j == 0)
                  || crossword[i][j - 1] == '+')) {
                for (String nextWord : restWords) {
                  PriorityQueue<String> nextWords = new PriorityQueue<>(
                      restWords);
                  nextWords.remove(nextWord);
                  char[][] copy = cloneCrossword(crossword);
                  crosswordPuzzleRec(copy, queue(nextWords),
                      Optional.of(nextWord), true, i, j);
                }
              }
              if (i + 1 < 10 && crossword[i + 1][j] == '-' && ((i == 0)
                  || crossword[i - 1][j] == '+')) {
                for (String nextWord : restWords) {
                  PriorityQueue<String> nextWords = new PriorityQueue<>(
                      restWords);
                  nextWords.remove(nextWord);
                  char[][] copy = cloneCrossword(crossword);
                  crosswordPuzzleRec(copy, queue(nextWords),
                      Optional.of(nextWord), false, i, j);
                }
              }
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    new CrosswordPuzzle().solve(System.in, System.out);
  }

  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    Scanner in = new Scanner(is);
    String[] crossword = new String[10];
    for (int crossword_i = 0; crossword_i < 10; crossword_i++) {
      crossword[crossword_i] = in.next();
    }
    String hints = in.next();
    String[] result = crosswordPuzzle(crossword, hints);
    for (int i = 0; i < result.length; i++) {
      os.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    os.println("");

    in.close();
    return os;
  }
}