import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;

    @Test
    public void doesCatSayMeow(){
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        Assert.assertEquals("Cat should say Meow", "Мяу", actual);
    }
    @Test
    public void doesCatEatRightFood(){
        Cat cat = new Cat(feline);
        List<String> expectedFoodForCat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = new ArrayList<>();
        try {
            Mockito.when(feline.eatMeat()).thenReturn(expectedFoodForCat);
            actual = cat.getFood();
            Mockito.verify(feline, Mockito.times(1)).eatMeat();
        }
        catch (Exception exception){
            Assert.fail("Get food throws error: " + exception.getMessage());
        }
        Assert.assertEquals("Cat should eat meat", expectedFoodForCat, actual);
    }
}
