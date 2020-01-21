package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class QueryProcessor {

    private final List<Integer> fib = new ArrayList<>();

    public QueryProcessor() {
        fib.add(0);
        fib.add(1);
        int cur = 2;
        while (cur < 1000) {
            fib.add(fib.get(cur-1) + fib.get(cur-2));
            cur += 1;
        }
    }

    private boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        else if (query.toLowerCase().contains("apple")) {
            return "apppppple";
        }
        else if (query.toLowerCase().contains("what is your team name")) {
            return "lcq";
        }
        else if (query.toLowerCase().contains("plus") || query.toLowerCase().contains("multiplied by")
            || query.toLowerCase().contains("minus")) {
//            Pattern pattern = Pattern.compile("\\w+ (\\d+) \\w+\\s?\\w+ (\\d+)");
//            Matcher plus_matcher = pattern.matcher(query);
//            if (plus_matcher.find()) {
//                Integer first = Integer.parseInt(plus_matcher.group(1));
//                Integer second = Integer.parseInt(plus_matcher.group(2));
//                if (query.toLowerCase().contains("plus")) {
//                    first += second;
//                }
//                else if (query.toLowerCase().contains("multiplied by")) {
//                    first *= second;
//                }
//                else if (query.toLowerCase().contains("minus")) {
//                    first -= second;
//                }
//                return first.toString();
//            }

            query = query.replaceAll("plus", "+");
            query = query.replaceAll("multiplied by", "*");
            query = query.replaceAll("minus", "-");
            query = query.replaceAll("what is", "");

            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            try {
                return engine.eval(query).toString();
            } catch (ScriptException e) {
                e.printStackTrace();
            }

        }
        else if (query.toLowerCase().contains("fibonacci")) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) {
                Integer idx = Integer.parseInt(matcher.group(0));
                return fib.get(idx - 1).toString();
            }
        }
        else if (query.toLowerCase().contains("prime")) {

            List<String> allMatches = new ArrayList<String>();

            Pattern pattern = Pattern.compile("(\\d+)");
            Matcher matcher = pattern.matcher(query);
            while (matcher.find()) {
                allMatches.add(matcher.group());
            }

            List<String> primes = new ArrayList<String>();

            for (String s: allMatches) {
                if (isPrime(Integer.parseInt(s))) {
                    primes.add(s);
                }
            }

            return primes.toString();
        }
        else {
            return "";
        }
        return "";
    }
}
