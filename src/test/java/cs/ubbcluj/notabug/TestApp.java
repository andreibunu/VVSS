package cs.ubbcluj.notabug;

import app.domain.Student;
import app.service.Service;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        testService.addStudent(student);
        assert (testService.findStudent(student.getID()).getID().equals(student.getID()));
        assert (testService.findStudent(student.getID()).getNume().equals(student.getNume()));
        assert (testService.findStudent(student.getID()).getEmail().equals(student.getEmail()));
        assert (testService.findStudent(student.getID()).getGrupa() == student.getGrupa());
    }

    @Test
    public void test2(){

    }

    @After
    public void after(){
        testService.deleteStudent(TestBuilder.ID);
    }



}
