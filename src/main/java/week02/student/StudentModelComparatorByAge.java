package week02.student;

import java.util.Comparator;

public class StudentModelComparatorByAge implements Comparator<StudentModel>
{
    @Override
    public int compare(StudentModel o1, StudentModel o2)
    {
        return o1.getAge() - o2.getAge();
    }
}
