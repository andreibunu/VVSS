package cs.ubbcluj.notabug;

import app.domain.Student;
import app.service.Service;
import app.validation.ValidationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestApp {
    private Service testService;

    @Before
    public void before(){
        TestBuilder testBuilder = new TestBuilder();
        this.testService = testBuilder.getService();
    }

    @Test
    public void test1(){
        Student student = new Student(TestBuilder.VALID_ID, TestBuilder.VALID_NAME, 0, TestBuilder.VALID_EMAIL);
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
        assert (testService.findStudent(student.getID()).getID().equals(student.getID()));
        assert (testService.findStudent(student.getID()).getNume().equals(student.getNume()));
        assert (testService.findStudent(student.getID()).getEmail().equals(student.getEmail()));
        assert (testService.findStudent(student.getID()).getGrupa() == student.getGrupa());
    }

    @Test
    public void test2(){
        Student student = new Student(TestBuilder.VALID_ID, TestBuilder.VALID_NAME, 1, TestBuilder.VALID_EMAIL);
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
        assert (testService.findStudent(student.getID()).getID().equals(student.getID()));
        assert (testService.findStudent(student.getID()).getNume().equals(student.getNume()));
        assert (testService.findStudent(student.getID()).getEmail().equals(student.getEmail()));
        assert (testService.findStudent(student.getID()).getGrupa() == student.getGrupa());
    }

    @Test (expected = ValidationException.class)
    public void test3(){
        Student student = new Student(TestBuilder.VALID_ID, TestBuilder.VALID_NAME, -1, TestBuilder.VALID_EMAIL);
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
    }


    @Test
    public void test4(){
        Student student = new Student(TestBuilder.VALID_ID, TestBuilder.VALID_NAME, TestBuilder.VALID_GROUP, TestBuilder.VALID_EMAIL);
        testService.addStudent(student);
        assert (testService.findStudent(student.getID()).getNume().equals(student.getNume()));
        String updatedName =  TestBuilder.VALID_NAME + "updated";
        Student updatedStudent = new Student(TestBuilder.VALID_ID, updatedName, TestBuilder.VALID_GROUP, TestBuilder.VALID_EMAIL);
        testService.addStudent(updatedStudent);
        assert (testService.findStudent(student.getID()).getNume().equals(student.getNume()));
    }


    @Test (expected = ValidationException.class)
    public void test5(){
        Student student = new Student(null, TestBuilder.VALID_NAME, TestBuilder.VALID_GROUP, TestBuilder.VALID_EMAIL);
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
    }

    @Test (expected = ValidationException.class)
    public void test6(){
        Student student = new Student("", TestBuilder.VALID_NAME, TestBuilder.VALID_GROUP, TestBuilder.VALID_EMAIL);
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
    }


    @Test (expected = ValidationException.class)
    public void test7(){
        Student student = new Student(TestBuilder.VALID_ID, null, TestBuilder.VALID_GROUP, TestBuilder.VALID_EMAIL);
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
    }

    @Test (expected = ValidationException.class)
    public void test8(){
        Student student = new Student(TestBuilder.VALID_ID, "", TestBuilder.VALID_GROUP, TestBuilder.VALID_EMAIL);
        testService.addStudent(student);
    }

    @Test (expected = ValidationException.class)
    public void test9(){
        Student student = new Student(TestBuilder.VALID_ID, TestBuilder.VALID_NAME, TestBuilder.VALID_GROUP, null);
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
    }

    @Test (expected = ValidationException.class)
    public void test10(){
        Student student = new Student(TestBuilder.VALID_ID, TestBuilder.VALID_NAME, TestBuilder.VALID_GROUP, "");
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
    }

    @After
    public void after(){
        testService.deleteStudent(TestBuilder.VALID_ID);
    }



}
