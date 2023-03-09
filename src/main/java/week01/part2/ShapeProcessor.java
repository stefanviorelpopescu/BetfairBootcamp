package week01.part2;

import week01.part2.figure.Figure;

import java.util.List;

public class ShapeProcessor
{
    public void drawShapes(List<Figure> shapes) {
        for (Figure figure : shapes) {
            figure.draw();
        }
    }
}
