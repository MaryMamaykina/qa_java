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
public class LionParameterizedTest {
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
        boolean actual = false;
        try {
            Lion lion = new Lion(feline,sex);
            actual = lion.doesHaveMane();
        } catch (Exception exception) {
            Assert.fail("Get sex throws error: " + exception.getMessage());
        }
        Assert.assertEquals("Lion with sex Самец should has Mane and with sex Самка shouldn't", hasMane, actual);
    }
}
