package io.javatests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathExampleTest {

    MathExample ob;

    @BeforeEach
    public void init(){
        ob = new MathExample();
    }

    @Test
    void testAdd(){
        int expect = 2;
        int actual = ob.add(1,1);
        assertEquals(expect,actual,"Add Two Number");
    }

    @Test
    void testComputeCircleArea(){
        assertEquals(314.1592653589793,ob.computeCircleArea(10),"Should return right circle area");
    }

    @Test
    void testDivide(){
        assertThrows(ArithmeticException.class, () -> ob.divide(1,0), "divide by zero should throw");
    }


}
