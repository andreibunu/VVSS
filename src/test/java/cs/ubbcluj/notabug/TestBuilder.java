package cs.ubbcluj.notabug;

import app.repository.NotaXMLRepo;
import app.repository.StudentXMLRepo;
import app.repository.TemaXMLRepo;
import app.service.Service;
import app.validation.NotaValidator;
import app.validation.StudentValidator;
import app.validation.TemaValidator;

public class TestBuilder {
    static final String VALID_ID = "brie1999";
    static final String VALID_NAME = "Bunu Andrei";
    static final String VALID_EMAIL = "andrei@gmail.com";
    static final int VALID_GROUP = 932;

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
