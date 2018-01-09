package leetcode;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyPath {

  public static String simplifyPath(String path) {
    List<String> filteredPath = Arrays.stream(path.split("/"))
        .filter(s -> s.length() != 0 && !s.equals("."))
        .collect(Collectors.toList());
    Stack<String> res = new Stack<>();
    for (String e : filteredPath) {
      if (e.equals("..")) {
        if (!res.empty()) {
          res.pop();
        }
      } else {
        res.push(e);
      }
    }
    return res.stream()
        .collect(Collectors.joining("/", "/", ""));
  }
}
