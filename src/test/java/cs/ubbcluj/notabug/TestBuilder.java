package cs.ubbcluj.notabug;

import app.repository.NotaXMLRepo;
import app.repository.StudentXMLRepo;
import app.repository.TemaXMLRepo;
import app.service.Service;
import app.validation.NotaValidator;
import app.validation.StudentValidator;
import app.validation.TemaValidator;

import java.time.LocalDate;

public class TestBuilder {
    //student
    static final String VALID_ID = "brie1999";
    static final String VALID_NAME = "Bunu Andrei";
    static final String VALID_EMAIL = "andrei@gmail.com";
    static final int VALID_GROUP = 932;

    //tema
    static final String VALID_TEMA_NR = "123";
    static final String VALID_TEMA_DESCR = "Bunu Andrei";
    static final int VALID_TEMA_DEADLINE = 14;
    static final int VALID__TEMA_PRIMIRE = 14;

    //nota
    //String id, String idStudent, String idTema, double nota, LocalDate data
    static final String VALID_nota_ID = "assign1";
    static final String VALID_nota_ID_TEMA = "123";
    static final String VALID_nota_ID_STUDENT = "brie1999";
    static final double VALID_nota_NOTA = 10;
    static final LocalDate VALID_nota_DATE = LocalDate.of(2019, 1, 1);


    public Service service;

    public TestBuilder() {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
    }



    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
