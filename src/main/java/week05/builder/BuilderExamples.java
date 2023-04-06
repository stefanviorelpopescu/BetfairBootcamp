package week05.builder;

import java.util.Arrays;
import java.util.List;

public class BuilderExamples
{
    public static void main(String[] args)
    {
        PersonWithActualBuilder personWithActualBuilder = new PersonWithActualBuilder("Gigel", 33, false, false, "123456", null);
        PersonWithActualBuilder personWithActualBuilder2 = new PersonWithActualBuilder("Gigel", 33, false, false, "123456");
        PersonWithActualBuilder personWithActualBuilder3 = new PersonWithActualBuilder("Gigel", false, true, "123456");

        PersonWithActualBuilder p4 = new PersonWithActualBuilder.PersonBuilder("Doru", "123456")
                .withAge(45)
                .isEmployed(false)
//                .withAddress("address")
//                .isMarried(true)
                .build();
        System.out.println("test");

        Person p5 = new Person.PersonBuilder()
                .withName("Doru")
                .withCnp("123456")
                .withAge(45)
                .withEmployed(false)
                .build();

        Person p6 = p5.toBuilder()
                .withEmployed(true)
                .build();

        Person [] persons = new Person [] {p5, p6};
        List<Person> personList = Arrays.asList(persons);

        Integer i1 = 500;
        Integer i2 = 500;
        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);

        Integer i3 = 5;
        Integer i4 = 5;
        System.out.println(i3.equals(i4));
        System.out.println(i3 == i4);

    }
}
