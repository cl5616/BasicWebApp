package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by luchuanqing on 2020/1/21.
 */
public class test {

  public static void main(String[] args) {


    String URL = "what is 201 multiplied by 2016 plus 200 minus 100";

    List<String> allMatches = new ArrayList<String>();

    URL = URL.replaceAll("plus", "+");
    URL = URL.replaceAll("multiplied by", "*");
    URL = URL.replaceAll("minus", "-");
    URL = URL.replaceAll("what is", "");

    System.out.println(URL);

    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    try {
      System.out.println(engine.eval(URL));
    } catch (ScriptException e) {
      e.printStackTrace();
    }

    Pattern pattern = Pattern.compile("(\\d+)");
    Matcher matcher = pattern.matcher(URL);
    while (matcher.find()) {
      allMatches.add(matcher.group());
    }

    System.out.println(allMatches);
  }
}
