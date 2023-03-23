package week03.student.dao;

import week03.student.model.StudentModel;

import java.util.Optional;

public class StudentDao
{

    public boolean createStudent(StudentModel studentModel)
    {
        try
        {
            Thread.sleep(20000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateStudent(StudentModel studentModel)
    {
        try
        {
            Thread.sleep(20000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public Optional<StudentModel> getStudentById(Long id)
    {
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return Optional.ofNullable(StudentModel.builder()
                .withId(id)
                .build());
    }
}
