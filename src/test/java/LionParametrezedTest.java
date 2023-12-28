import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParametrezedTest {
    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameter(0)
    public String sex;
    @Parameterized.Parameter(1)
    public Boolean hasMane;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Mock
    Feline feline;

    @Test
    public void checkDependenceHavingManeFromSex(){
        try {
            Lion lion = new Lion(feline,sex);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals("lion with sex Самец should has Mane and with sex Самка shouldn't", hasMane, actual);
        } catch (Exception exception) {
            Assert.fail("Get sex throws error: " + exception.getMessage());
        }

    }


}
