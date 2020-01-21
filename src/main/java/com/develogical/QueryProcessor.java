package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

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
            Pattern pattern = Pattern.compile("\\w+ (\\d+) \\w+\\s?\\w+ (\\d+)");
            Matcher plus_matcher = pattern.matcher(query);
            if (plus_matcher.find()) {
                Integer first = Integer.parseInt(plus_matcher.group(1));
                Integer second = Integer.parseInt(plus_matcher.group(2));
                if (query.toLowerCase().contains("plus")) {
                    first += second;
                }
                else if (query.toLowerCase().contains("multiplied by")) {
                    first *= second;
                }
                else if (query.toLowerCase().contains("minus")) {
                    first -= second;
                }
                return first.toString();
            }
        }
        else {
            return "";
        }
        return "";
    }
}
