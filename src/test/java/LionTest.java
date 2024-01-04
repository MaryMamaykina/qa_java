import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LionTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;

    @Test
    public void doesLionGetOneKitten() {
        int actual = 0;
        try {
            Lion lion = new Lion(feline, "Самка");
            Mockito.when(feline.getKittens()).thenReturn(1);
            actual = lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
        } catch (Exception exception) {
            Assert.fail("Get food throws error: " + exception.getMessage());
        }
        Assert.assertEquals("By default, a lion should have one lion cub", 1, actual);
    }
    @Test
    public void doesLionEatRightFood(){
        List<String> expectedFoodForLion = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = new ArrayList<>();
        try {
            Lion lion = new Lion(feline, "Самец");
            Mockito.when(feline.eatMeat()).thenReturn(expectedFoodForLion);
            actual = lion.getFood();
            Mockito.verify(feline, Mockito.times(1)).eatMeat();
        }
        catch (Exception exception){
            Assert.fail("Get food throws error: " + exception.getMessage());
        }
        Assert.assertEquals("Lion should eat meat", expectedFoodForLion, actual);
    }
    @Test
    public void checkThrowExceptionForLionWithWrongSex(){
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion(feline,"Другое"));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}


