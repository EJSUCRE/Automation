package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.UserPojoFinalTaller;
import steps.UsersFinalTaller;

import java.util.ArrayList;
import java.util.List;

public class SimpleTestFinalTaller {

    private UsersFinalTaller steps;

    private List<UserPojoFinalTaller> users;

    @DataProvider(name = "ids")
    public Object[][] inputData() {
        return new Object[][] {{"200"}, {"201"}};
    }

    @BeforeMethod
    @Parameters({"uri"})
    public void test(String uri){
        steps = new UsersFinalTaller(uri);

       /* users = new ArrayList();

       UserPojoFinalTaller carlos = UserPojoFinalTaller.builder()
        .first_name("Chapo")
        .last_name("Guzman")
        .email("hoyoEnUno@gmail.com")
        .country("Mexico")
        .active(true)
        .telephone("2452345234532")
        .job_title("Minero")
        .build();

        User carla = new User("carla",
                "pondrea",
                "lasdffuidsa@p.com",
                "Colombia",
                "3452345",
                true,
                "Java  dev");

        users.add(carlos);
        users.add(carla);*/
    }


    @Test
    public void getUsersTestAll(){
        steps.getUsersAPIEndpoint();
        steps.getUsers();
        steps.isStatusCode(200);
        steps.showActualUsersList();
    }

    @Test
    public void getUserTestById(){
        steps.getUsersAPIEndpoint();
        steps.getUser("8");
        steps.isStatusCode(200);
        steps.userEmailShouldBe("endersucre@mail.com");
    }

    @Test
    public void putTestById(){
        String newNote="20";
        String newApproved="false";
        steps.getUsersAPIEndpoint();
        steps.updateUserFinalNote("8", newNote);
        steps.updateUserApproved("8", Boolean.parseBoolean(newApproved));
        steps.isStatusCode(200);
        steps.finalNoteChanged(newNote);
        steps.approvedChanged(Boolean.parseBoolean(newApproved));
    }

}
