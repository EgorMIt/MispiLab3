package com.company;

public class Point {
    private double x;
    private double y;
    private float r = 1;
    private String res;
    private String owner;

    public String getOwner() {
        return owner;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRes() {
        return res;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Owner: " + this.owner + " has a point X: " + this.x + " Y: " + this.y + " Result: " + this.res;
    }

    public void check() {
        if ((x * x + y * y <= r * r && x <= 0 && y <= 0) ||
                (y - 2 * x >= -r && x >= 0 && y <= 0) ||
                (y <= r && x >= -r / 2 && x <= 0 && y >= 0)) {
            res = "True";
        } else {
            res = "False";
        }
    }
}
