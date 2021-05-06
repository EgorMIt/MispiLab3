package com.company;

public class Point {
    private final double x;
    private final double y;
    private String res;
    private String owner;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Owner: " + this.owner + " has a point X: " + this.x + " Y: " + this.y + " Result: " + this.res;
    }

    public void check() {
        float r = 1;
        if ((x * x + y * y <= r * r && x <= 0 && y <= 0) ||
                (y - 2 * x >= -r && x >= 0 && y <= 0) ||
                (y <= r && x >= -r / 2 && x <= 0 && y >= 0)) {
            res = "True";
        } else {
            res = "False";
        }
    }
}
