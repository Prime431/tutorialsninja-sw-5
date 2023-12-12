package resources.testdata;

import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.annotations.DataProvider;

public class TestData extends BaseTest {

    @DataProvider(name = "data set")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"HTC Touch HD" ,"1","3Success: You have added HTC Touch HD to your shopping cart! ","HTC Touch HD" ,"Product 1"    ,"£74.73"},
                {"iPhone"       ,"2","Success: You have added iPhone to your shopping cart!"        ,"iPhone"       ,"Product 11"   ,"£150.92"}  ,
                {"HTC Touch HD" ,"3","Success: You have added Palm Treo Pro to your shopping cart! ","Palm Treo Pro","Product 2"    ,"£1,242.11"},

        };
        return data;
    }
}
