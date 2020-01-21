package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luchuanqing on 2020/1/21.
 */
public class test {

  public static void main(String[] args) {

    List<Integer> fib = new ArrayList<>();

    fib.add(0);
    fib.add(1);
    int cur = 2;
    while (cur < 1000) {
      fib.add(fib.get(cur-1) + fib.get(cur-2));
      cur += 1;
    }

    String URL = "what is the 3th number in Fibonacci sequence";
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(URL);
    if (matcher.find()) {
      Integer idx = Integer.parseInt(matcher.group(0));
      System.out.println(fib.get(idx - 1)); //prints /{item}/
    }
  }
}
