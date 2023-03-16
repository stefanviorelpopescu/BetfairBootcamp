package week02.student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto
{
    private String firstName;
    private String lastName;
    private String fullName;
    private int age;

    public StudentDto()
    {
    }

    public StudentDto(String firstName, String lastName, String fullName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.age = age;
    }
}
