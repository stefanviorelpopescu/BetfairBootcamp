package week01.part2;

import week01.part2.figure.Circle;
import week01.part2.figure.Figure;
import week01.part2.figure.Square;
import week01.part2.figure.Triangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        List<Figure> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Triangle());
        shapes.add(new Triangle());
        shapes.add(new Circle());
        shapes.add(new Triangle());
        shapes.add(new Circle());
        shapes.add(new Square());

        Figure square = new Square();
        int surface = square.getSurface();
        System.out.println(surface);
        square.getSurface();

        ShapeProcessor shapeProcessor = new ShapeProcessor();
        shapeProcessor.drawShapes(shapes);

//        class TempFigure extends Square {
//
//            @Override
//            public int getPerimeter()
//            {
//                return -5;
//            }
//        }

        Figure temp = new Square() {
            @Override
            public int getPerimeter()
            {
                return -5;
            }
        };

        System.out.println(Thread.currentThread().getName());

        Runnable myTask = new MyTask();
        new Thread(myTask).start();

        Runnable otherTask = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println(Thread.currentThread().getName());
            }
        };
        new Thread(otherTask).start();

        shapes.sort(new Comparator<Figure>()
        {
            @Override
            public int compare(Figure o1, Figure o2)
            {
                return o1.getSurface() - o2.getSurface();
            }
        });

        shapes.sort((o1, o2) -> o1.getSurface() - o2.getSurface());

        shapes.sort(Comparator.comparingInt(Figure::getSurface));

        Scanner scanner = new Scanner(System.in);

        NumberProcessor numberProcessor = new NumberProcessor();
        try
        {
            numberProcessor.readNumber(scanner);
        } catch (Exception e)
        {
            System.out.println("The number is invalid !!!");
        }

        numberProcessor.readFromFile("names.txt");

        System.out.println("END");
    }
}
