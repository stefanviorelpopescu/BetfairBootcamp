package week01.part2.figure;

public class Square implements Figure
{
    @Override
    public int getPerimeter()
    {
        return 2;
    }

    @Override
    public int getSurface()
    {
        return 2;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing a square!");
    }
}
