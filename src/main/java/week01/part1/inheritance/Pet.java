package week01.part1.inheritance;

import week01.part1.Animal;

public class Pet implements Animal
{
    public static final boolean IS_ALIVE = true;

    private String name;
    private int age;
    private boolean isAdopted;

    @Override
    public void talk() {
        System.out.println("Pet is talking ...");

    }

    @Override
    public void walk() {
        System.out.println("Pet is walking ...");
    }

    @Override
    public void sleep()
    {
        String zzz = "Zzz Zzz ...";
        System.out.println(zzz);
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public boolean isAdopted()
    {
        return isAdopted;
    }
}
