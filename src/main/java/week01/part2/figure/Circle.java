package week01.part2.figure;

public class Circle implements Figure
{
    @Override
    public int getPerimeter()
    {
        return 4;
    }

    @Override
    public int getSurface()
    {
        return 4;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing a circle!");
    }
}
