import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
        try {
            Lion lion = new Lion(feline, "Самка");
            Mockito.when(feline.getKittens()).thenReturn(1);
            int actual = lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
            Assert.assertEquals("By default, a lion should have one lion cub", 1, actual);
        } catch (Exception exception) {
            Assert.fail("Get food throws error: " + exception.getMessage());
        }
    }
    @Test
    public void doesLionEatRightFood(){
        try {
            List<String> expectedFoodForLion = Arrays.asList("Животные", "Птицы", "Рыба");
            Lion lion = new Lion(feline, "Самец");
            Mockito.when(feline.eatMeat()).thenReturn(expectedFoodForLion);
            List<String> actual = lion.getFood();
            Mockito.verify(feline, Mockito.times(1)).eatMeat();
            Assert.assertEquals("Lion should eat meat", expectedFoodForLion, actual);
        }
        catch (Exception exception){
            Assert.fail("Get food throws error: " + exception.getMessage());
        }
    }
    @Test
    public void checkThrowExceptionForLionWithWrongSex(){
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion(feline,"Другое"));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}


