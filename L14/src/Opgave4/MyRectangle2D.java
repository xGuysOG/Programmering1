package Opgave4;

import java.util.logging.Level;

public class MyRectangle2D {

    //https://prnt.sc/gmORcDtWw5OF
    double x;
    double y;
    double width;

    double height;

    public MyRectangle2D() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return  width + width + height + height;
    }

    public boolean contains(double x, double y) {
        //20
        System.out.println("Called with x " + x + " and y " + y);

        //x1 y1 = bottom left
        //x2 y2= top right

        double x1 = this.x;
        double y1 = this.y - height;

        double x2 = this.x + width;
        double y2 = this.y;

//        System.out.println("x1 " + x1);
//        System.out.println("x2 " + x2);
//        System.out.println("y1 " + y1);
//        System.out.println("y2 " + y2);
//
//        System.out.println("x " + x);
//        System.out.println("y " + y);

        //0 , 0
        //-10, 0
        //0, 20
        //-10, 20

        //if it satisfies the condition
        //we have 3, 3 as the point

        //start point 4 4

        //B L
        //4, - 1

        //4, 9

        //3, 3

        //        if (x > x1 && x < x2 && y > y1 && y < y2) {

//        if (x < x1 && x < x2 && y > y1 && y < y2) {
//            //then return true
//            return true;
//        } else {
//            return false;
//        }
        if (x > x1 && x < x2 && y > y1 && y < y2) {
            //then return true
            return true;
        } else {
          return false;
        }
    }

    public boolean contains(MyRectangle2D r) {
        //not correct
        if (contains(r.x, r.y) && contains(r.x + r.width, r.y - r.height) && contains(r.x + r.width, r.y) && contains(r.x, r.y - r.height )) {
            return true;
        } else {
            return false;
        }
    }

    public boolean overlaps(MyRectangle2D r) {
        //
        if (contains(r.x, r.y) || contains(r.x + r.width, r.y - r.height) || contains(r.x + r.width, r.y) || contains(r.x, r.y - r.height )) {
            return true;
        } else {
            return false;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
