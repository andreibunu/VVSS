package cs.ubbcluj.notabug;

import app.domain.Student;
import app.service.Service;
import app.validation.ValidationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
        Student student = new Student(TestBuilder.ID, TestBuilder.name, TestBuilder.group, TestBuilder.email);
        assert (testService.findStudent(student.getID()) != student);
        testService.deleteStudent(TestBuilder.ID);
        testService.addStudent(student);
        assert (testService.findStudent(student.getID()).getID().equals(student.getID()));
        assert (testService.findStudent(student.getID()).getNume().equals(student.getNume()));
        assert (testService.findStudent(student.getID()).getEmail().equals(student.getEmail()));
        assert (testService.findStudent(student.getID()).getGrupa() == student.getGrupa());
    }

    @Test
    public void test2(){
        Student student = new Student(TestBuilder.ID, TestBuilder.name, TestBuilder.group, TestBuilder.email);
        testService.deleteStudent(student.getID());
        testService.addStudent(student);
        AtomicInteger numberOfStudents = new AtomicInteger();
        testService.getAllStudenti().forEach(st-> numberOfStudents.addAndGet(1));
        student.setNume("updatedTestName");
        testService.updateStudent(student);
        testService.getAllStudenti().forEach(st-> numberOfStudents.getAndDecrement());
        assert (numberOfStudents.compareAndSet(0, 0));
    }

    @Test (expected = ValidationException.class)
    public void test3(){
        Student student = new Student(TestBuilder.ID, TestBuilder.name, TestBuilder.group, "");
        testService.addStudent(student);
    }

    @After
    public void after(){
        testService.deleteStudent(TestBuilder.ID);
    }



}
