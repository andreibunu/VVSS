package cs.ubbcluj.notabug;

import app.domain.Nota;
import app.domain.Student;
import app.domain.Tema;
import app.service.Service;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

public class BigBangTestApp {
    private Service testService;

    @Before
    public void before(){
        TestBuilder testBuilder = new TestBuilder();
        this.testService = testBuilder.getService();
    }

    @Test
    public void addStudentTest(){
        Student student = new Student(TestBuilder.VALID_ID, TestBuilder.VALID_NAME, 0, TestBuilder.VALID_EMAIL);
        testService.deleteStudent(TestBuilder.VALID_ID);
        testService.addStudent(student);
        assert (testService.findStudent(student.getID()).getID().equals(student.getID()));
        assert (testService.findStudent(student.getID()).getNume().equals(student.getNume()));
        assert (testService.findStudent(student.getID()).getEmail().equals(student.getEmail()));
        assert (testService.findStudent(student.getID()).getGrupa() == student.getGrupa());
    }


    @Test
    public void addAssignmentTest(){
        Tema tema = new Tema(TestBuilder.VALID_TEMA_NR, TestBuilder.VALID_TEMA_DESCR,
                TestBuilder.VALID_TEMA_DEADLINE, TestBuilder.VALID__TEMA_PRIMIRE);
        testService.deleteTema(TestBuilder.VALID_TEMA_NR);
        testService.addTema(tema);
        assert (testService.findTema(tema.getID()).getDescriere().equals(tema.getDescriere()));
        assert (testService.findTema(tema.getID()).getDeadline() == tema.getDeadline());
        assert (testService.findTema(tema.getID()).getPrimire() == tema.getPrimire());
    }
    @Test
    public void addGradeTest(){
        Nota nota = new Nota(TestBuilder.VALID_nota_ID, TestBuilder.VALID_nota_ID_STUDENT, TestBuilder.VALID_nota_ID_TEMA,
                TestBuilder.VALID_nota_NOTA, TestBuilder.VALID_nota_DATE);
        testService.deleteNota(TestBuilder.VALID_nota_ID);
        testService.addNota(nota, "some feedback");
        assert (testService.findNota(nota.getID()).getNota() == (nota.getNota()));
        assert (testService.findNota(nota.getID()).getIdStudent().equals(nota.getIdStudent()));
        assert (testService.findNota(nota.getID()).getIdTema().equals(nota.getIdTema()));
        assert (testService.findNota(nota.getID()).getData().equals(nota.getData()));
    }

    @Test
    @AfterAll
    public void addIntegrationTest(){
        addStudentTest();
        addAssignmentTest();
        addGradeTest();
    }

}
