package com.kklokker.calculator;

public class List<Char> {
    String[] array;
    int start, end;

    public List (String expression) {
        array = new String[expression.length()];
        String elem = "";
        String methods = "+-x/%";
        end = 0;
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (methods.contains(c + "")) {
                array[end] = elem;
                elem = "";
                end++;
                array[end] = c + "";
                end++;
            }
            else
                elem = elem + c;
        }
        array[end] = elem;
        end++;
        start = 0;
    }

    public void tail() {
        start++;
    }

    public String head() {
        return array[start];
    }

    public boolean isEmpty() {
        System.out.println(start + " " + end);
        return start == end;
    }
}