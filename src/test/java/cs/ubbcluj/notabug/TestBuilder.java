package cs.ubbcluj.notabug;

import app.repository.NotaXMLRepo;
import app.repository.StudentXMLRepo;
import app.repository.TemaXMLRepo;
import app.service.Service;
import app.validation.NotaValidator;
import app.validation.StudentValidator;
import app.validation.TemaValidator;

public class TestBuilder {
    public static final String ID = "1";
    public static final String name = "andrei";
    public static final String email = "andrei@yahoo.com";
    public static final int group = 932;

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


    public static String getID() {
        return ID;
    }

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static int getGroup() {
        return group;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
