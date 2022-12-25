package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void testOnePlusFive() {

        Assert.assertEquals(1 + 5, 6);


    }




}
