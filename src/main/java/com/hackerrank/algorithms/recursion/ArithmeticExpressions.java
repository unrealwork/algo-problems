import java.util.Scanner;

public class ArithmeticExpressions {
  static public void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();

    int[] numbers = new int[n];

    for (int i = 0; i < n; ++i) {
      numbers[i] = in.nextInt();
    }

    char[] operators = new char[n - 1];

    solve(numbers, operators);

    printResult(numbers, operators);
  }

  private static void solve(int[] numbers, char[] operators) {

    memo = new boolean[2 * 101][operators.length]; // 2x is required to include negative values too
    solve(numbers, operators, 0, numbers[0]);
  }

  static boolean[][] memo;

  private static boolean solve(int[] numbers, char[] operators, int i, int result) {

    result %= 101;

    if (result == 0) {
      while (i < operators.length) operators[i++] = '*';
      return true;
    }

    if (i == operators.length) return false;

    if (memo[101 + result][i]) return false;

    int current = numbers[i + 1] % 101;

    operators[i] = '+';
    int plusRes = (result + current);
    if (solve(numbers, operators, i + 1, plusRes)) return true;

    operators[i] = '-';
    int minusRes = (result - current);
    if (solve(numbers, operators, i + 1, minusRes)) return true;

    operators[i] = '*';
    int mulRes = (result * current);
    if (solve(numbers, operators, i + 1, mulRes)) return true;

    memo[101 + result][i] = true;
    return false;
  }

  private static void printResult(int[] numbers, char[] operators) {
    StringBuilder sb = new StringBuilder(3 * numbers.length + operators.length);
    for (int i = 0; i < operators.length; ++i) {
      sb.append(numbers[i]);
      sb.append(operators[i]);
    }

    sb.append(numbers[numbers.length - 1]);
    System.out.println(sb.toString());
  }
}