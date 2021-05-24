import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AppTest extends BaseTest{
    App app = null;
    @BeforeClass
    public void init(){
       app = new App();
    }
    @Test(dataProvider = "dp")
    public void testSum(String a, String b, String rslt){
      //  App app = new App();
        int result = app.sum(Integer.valueOf(a),Integer.valueOf(b));
        assertTrue(result==Integer.valueOf(rslt),"sum function failed");
    }
    @Test(dataProvider = "dp")
    public void testIsEven(String a){
       // App app = new App();
        boolean result = app.isEven(Integer.valueOf(a));
        assertTrue(result,"isEven test failed");
    }
}
