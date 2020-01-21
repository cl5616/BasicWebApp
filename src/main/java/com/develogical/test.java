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


    String URL = "which of the following numbers are primes:389, 6";

    List<String> allMatches = new ArrayList<String>();


    Pattern pattern = Pattern.compile("(\\d+)");
    Matcher matcher = pattern.matcher(URL);
    while (matcher.find()) {
      allMatches.add(matcher.group());
    }

    System.out.println(allMatches);
  }
}
