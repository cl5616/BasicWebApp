package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luchuanqing on 2020/1/21.
 */
public class test {

  public static void main(String[] args) {
    String URL = "what is 20 plus 25";
    Pattern pattern = Pattern.compile("\\w+ (\\d+) \\w+\\s?\\w+ (\\d+)");
    Matcher matcher = pattern.matcher(URL);
    if (matcher.find()) {
      System.out.println(matcher.group(1)); //prints /{item}/
      System.out.println(matcher.group(2)); //prints /{item}/
    } else {
      System.out.println("Match not found");
    }
  }
}
