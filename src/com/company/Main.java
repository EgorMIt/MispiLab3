package com.company;

public class Main {

    public static void main(String[] args) {
        double x = 1;
        double y = 2;
        Point point = new Point(x, y);
        point.setOwner("FirstOwner");
        point.check();
        String answer = point.toString();
        System.out.println(answer);
    }
}
