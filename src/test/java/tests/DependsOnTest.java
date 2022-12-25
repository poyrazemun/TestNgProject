package tests;

import org.testng.annotations.Test;

public class DependsOnTest {
    @Test
    public void test1(){
        System.out.println("Test 1 is running");
    }

    @Test(dependsOnMethods = {"test1"})//only if test 1 gecerse test 2 test run edilecek!!!
    public void test2(){
        System.out.println("Test 2 is running");
    }

    @Test
    public void test3(){
        System.out.println("Test 3 is running");
    }
}
