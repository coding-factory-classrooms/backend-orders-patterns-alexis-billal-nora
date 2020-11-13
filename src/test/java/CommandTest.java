import org.example.HomeSystem;
import org.example.models.Command;
import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

    @Test
    public void verifyStateOnCreateTest()
    {
        Command command = new Command();

        Assert.assertEquals(command.getState().name(), "NEW");
    }

    @Test
    public void commandEmptyAtInitialTest()
    {
        Assert.assertTrue(HomeSystem.getInstance().getCommands().isEmpty());
    }

    @Test
    public void addCommandSuccessTest()
    {
        HomeSystem homeSystem = HomeSystem.getInstance();
        homeSystem.addCommand(new Command());

        Assert.assertEquals(1, homeSystem.getCommands().size());
    }

    @Test
    public void addCommandTwoSuccessTest()
    {
        HomeSystem homeSystem = HomeSystem.getInstance();
        homeSystem.addCommand(new Command());
        homeSystem.addCommand(new Command());

        Assert.assertEquals(2, homeSystem.getCommands().size());
    }
}
