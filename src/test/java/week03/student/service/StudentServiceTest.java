package week03.student.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import week03.student.dao.StudentDao;
import week03.student.dto.StudentDto;
import week03.student.model.StudentModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest
{
    @Mock
    StudentDao studentDao;
    @InjectMocks
    StudentService studentService;

//    static StudentService studentService;
//
//    @BeforeAll
//    public static void setUp() {
//        StudentDao studentDao = Mockito.mock(StudentDao.class);
//        studentService = new StudentService(studentDao);
//    }

    @Test
    public void whenPayloadIsValidStudentIsSaved() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withName("Gigel")
                .withAge(42).build();
        when(studentDao.createStudent(any())).thenReturn(true);

        //when
        boolean created = studentService.createStudent(studentDto);

        //then
        assertTrue(created);
    }

    @Test
    public void whenCreatePayloadHasIdThenThrowException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withId(5L)
                .withName("Gigel")
                .withAge(42).build();

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.createStudent(studentDto));

        //then
    }

    @Test
    public void wheUpdatePayloadHasInvalidAgeThenThrowException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withId(5L)
                .withName("Gigel")
                .withAge(7).build();

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(studentDto));

        //then
    }

    @Test
    public void wheUpdatePayloadIdNotFoundThenExceptionIsThrown() {
        //given
        Long studentId = 5L;
        StudentDto studentDto = StudentDto.builder()
                .withId(studentId)
                .withName("Gigel")
                .withAge(25)
                .withGpa(5d)
                .build();
        when(studentDao.getStudentById(eq(studentId))).thenReturn(Optional.empty());

        //when
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> studentService.updateStudent(studentDto));

        //then
        verify(studentDao, times(1)).getStudentById(eq(studentId));
        verify(studentDao, times(0)).updateStudent(any());
    }

    @Test
    public void wheUpdatePayloadIdFoundThenModelIsSaved() {
        //given
        Long studentId = 5L;
        StudentDto studentDto = StudentDto.builder()
                .withId(studentId)
                .withName("Gigel")
                .withAge(25)
                .withGpa(5d)
                .build();
        StudentModel foundStudent = StudentModel.builder()
                .withId(studentId)
                .build();
        when(studentDao.getStudentById(eq(studentId))).thenReturn(Optional.of(foundStudent));
        when(studentDao.updateStudent(any())).thenReturn(true);

        //when
        boolean updated = studentService.updateStudent(studentDto);

        //then
        assertTrue(updated);
        verify(studentDao, times(1)).getStudentById(eq(studentId));
        verify(studentDao, times(1)).updateStudent(any());
    }


}