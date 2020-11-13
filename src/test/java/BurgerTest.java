import org.example.models.Burger;
import org.junit.Assert;
import org.junit.Test;

public class BurgerTest {

    @Test
    public void verifyTypeNameTest()
    {
        Burger burger = new Burger();

        Assert.assertEquals(burger.getTypeName(), "Burger");
    }
}
