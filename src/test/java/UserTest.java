

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;



import model.User;

public class UserTest {

	private User user = new User();
	
	@Test
	public void testUserList() {
		List<User> userList =  user.getAllUsers();
		assertNotEquals(0,userList.size());
	}
	
}
