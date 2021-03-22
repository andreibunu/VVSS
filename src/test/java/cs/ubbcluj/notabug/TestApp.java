package cs.ubbcluj.notabug;

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

    }

    @Test
    public void test2(){

    }

    @After
    public void after(){

    }
    
}
