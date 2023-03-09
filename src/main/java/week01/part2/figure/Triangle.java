package week01.part2.figure;

public class Triangle implements Figure
{
    @Override
    public int getPerimeter()
    {
        return 3;
    }

    @Override
    public int getSurface()
    {
        return 3;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing a triangle!");
    }
}
