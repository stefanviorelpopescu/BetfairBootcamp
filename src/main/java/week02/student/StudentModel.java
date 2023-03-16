package week02.student;

import java.util.Objects;

public class StudentModel implements Comparable<StudentModel>
{
    long id;
    String firstName;
    String lastName;
    int age;


    public StudentModel(long id, String firstName, String lastName, int age)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public StudentDto convertToDto() {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(this.getFirstName());
        studentDto.setLastName(this.getLastName());
        studentDto.setFullName(this.getFirstName() + " " + this.getLastName());
        studentDto.setAge(this.getAge());
        return studentDto;
    }

    @Override
    public int compareTo(StudentModel other)
    {
        return Long.compare(this.getId(), other.getId());
    }

    @Override
    public String toString()
    {
        return "StudentModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return id == that.id && age == that.age && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName, age);
    }
}
