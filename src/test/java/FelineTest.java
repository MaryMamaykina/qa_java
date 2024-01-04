import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

public class FelineTest {
    @Test
    public void doesFelineEatRightFood() {
        try {
            Feline feline = new Feline();
            Feline felineSpy  = Mockito.spy(feline);
            List<String> expectedFoodForFeline = Arrays.asList("Животные", "Птицы", "Рыба");
            List<String> actual = felineSpy.eatMeat();
            Mockito.verify((Animal)felineSpy, Mockito.times(1)).getFood("Хищник");
            Assert.assertEquals("Feline should eat meat",expectedFoodForFeline, actual);
        }
        catch (Exception exception) {
            Assert.fail("Get food throws error: " + exception.getMessage());
        }
    }
    @Test
    public void doesFelineHaveRightFamily() {
            Feline feline = new Feline();
            String actual = feline.getFamily();
            Assert.assertEquals("Feline have family Feline", "Кошачьи", actual);

    }
    @Test
    public void doesFelineCanGetKitten() {
        Feline feline = new Feline();
        Feline felineSpy  = Mockito.spy(feline);
        int actual = felineSpy.getKittens();
        int defaultNumbersOfKittens = 1;
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
        Assert.assertEquals("Feline can get kitten", defaultNumbersOfKittens, actual);
        }
    @Test
    public void doesFelineCanGetMoreThanOneKitten() {
        Feline feline = new Feline();
        int actual = feline.getKittens(3);
        Assert.assertEquals("Feline can get more than one kitten", 3, actual);
        }

}
