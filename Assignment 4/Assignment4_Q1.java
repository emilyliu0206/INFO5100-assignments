package Assignment4;
import static java.lang.Math.PI;
import java.awt.geom.Area;

//    Q1​. ​Implement the following four classes using Inheritance (2 mks)

class Shape {
    protected String name = "shape";
    double perimeter;
    double area;


    public void draw(){
            System.out.println("Drawing "+ name);
    }

    void getArea(){};

    void getPerimeter(){};
}


class Circle extends Shape{
    double radius;

    Circle(double radius){
        this.radius = radius;
        this.name = "circle";
    }

    void getArea(){
        area = radius * radius * PI;
        System.out.println(String.format("%.2f",area));
    }

    void getPerimeter(){
        perimeter = radius * 2 * PI;
        System.out.println(String.format("%.2f",perimeter));
    }
}


class Rectangle extends Shape{
    double width;
    double height;

    Rectangle(double w, double h){
        this.width = w;
        this.height = h;
        this.name = "rectangle";
    }

    void getArea(){
        area = width * height;
        System.out.println(area);
    }

    void  getPerimeter(){
        perimeter = 2 * (width + height);
        System.out.println(perimeter);
    }
}

class Square extends Shape{
    double side;

    Square(double side){
        this.side = side;
        this.name = "square";

    }

    void getArea(){
        area = side * side;
        System.out.println(area);
    }

    void getPerimeter(){
        perimeter = side * 4;
        System.out.println(perimeter);
    }
}


