package io.javatests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class MathExampleTest {

    MathExample ob;

    @BeforeAll
    public static void beforeAllInit(){
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    public void init(){
        ob = new MathExample();
    }

    @AfterEach
    public void cleanup(){
        System.out.println("Clean Up....");
    }


    @Nested
    class AddTest{

        @Test
        @DisplayName("positive addition")
        void testAddPos(){
            int expect = 2;
            int actual = ob.add(1,1);
            assertEquals(expect,actual,"Add Two Number");
        }

        @Test
        @DisplayName("negative addition")
        void testAddNeg(){
            int expect = -2;
            int actual = ob.add(-1,-1);
            assertEquals(expect,actual,"Add Two Number");
        }
    }



    @Test
    void testComputeCircleArea(){
        assertEquals(314.1592653589793,ob.computeCircleArea(10),"Should return right circle area");
    }

    @Test
    @DisplayName("Multiple Method")
    void testMultiple(){
        assertAll(() -> assertEquals(4,ob.multiply(2,2)),
                 () -> assertEquals(0,ob.multiply(0,2)),
                () -> assertEquals(-2,ob.multiply(2,-1))
        );
    }

    @Test
    void testDivide(){
        assertThrows(ArithmeticException.class, () -> ob.divide(1,0), "divide by zero should throw");
    }

    @Test
    @Disabled
    @DisplayName("New Method")
    public void newMeth(){
        System.out.println("New Method");
    }

}
