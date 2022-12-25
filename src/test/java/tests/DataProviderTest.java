package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {


    @DataProvider (name = "myData")
    public Object [][] provideData(){

        return new Object[][]{
                {"Adam"},
                {"Susan"},
                {"Mary"},
                {"Alice"},

        };
    }

    @Test(dataProvider = "myData")
    public void testMultipleData(String name){
        System.out.println(name);
    }

    @DataProvider (name = "TwoSetOfData")
    public Object [][] provide2Data(){

        return new Object[][]{
                {"Adam",20},
                {"Susan",80},
                {"Mary",90},
                {"Alice",156},

        };
    }

    @Test(dataProvider = "TwoSetOfData")
    public void testMultipleData2(String name,int number){
        System.out.println(name + " : "+number);
    }

}
