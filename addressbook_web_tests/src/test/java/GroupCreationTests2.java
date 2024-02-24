import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests2 extends TestBase {


    @Test
    public void canCreateGroup() {
        openGroupsPage();


        createGroup(new GroupData("group name", "group header", "group footer"));
    }


    @Test
    public void canCreateGroupWithEmptyName() {

        openGroupsPage();

        driver.findElement(By.linkText("groups")).click();
        createGroup(new GroupData());

    }
    @Test
    public void canCreateGroupWithNameOnly() {

        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");


        createGroup(groupWithName);

    }
}