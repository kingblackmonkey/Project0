package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exceptions.UserNameAlreadyExistsException;

//import com.example.exceptions.UserNameAlreadyExistsException;
//import com.example.logging.Logging;
//import com.example.models.User;

import fileIO.ConnectionUtil;

//import java.io.Serializable;
public class User  {

/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	
	//userlist 
	
	 	List <User>  users;
	 	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();	
	





private int id;
private  String first_name;
private  String last_name;
private String username;
private String typeOfUser;
private  String password;


public User() {
	
}


//create users from input console constructor
	public  User(String  first_name, String last_name, String  password) {
		
		this. first_name =  first_name;
		this.last_name = last_name;
		this.username =  first_name +  last_name + (new Random().nextInt(9000)+1000);
		this.password =  password;
	
	
	}

	
	
//receive users from database  constructor
	
public  User(int id  ,String  first_name, String last_name, String username,   String typeOfUser  , String  password) {
		this.id = id;
		this. first_name =  first_name;
		this.last_name = last_name;
		this.username =  username;
		this.typeOfUser = typeOfUser;
		this.password =  password;
	
	
	}
	
	
	
public List<User> getAllUsers() {
	
	List<User> userList = new ArrayList<User>();
	
	try {
		Connection con = conUtil.getConnection();
		//To create a simple statment we write our query as a string
		String sql = "SELECT * FROM users";
		
		//We need to create a statement with this sql string
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
//		save in user list in user 
		users = userList ;
		
		
		return userList;
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	return null;
	
}
	

	public int getId() {
	return id;
}

//sign up 
	
	
public User signUp (User customer, User user) {
	
	
	//Check to see if the users username already exist
	for(int i=0; i<user.users.size(); i++) {
		if(user.users.get(i).getUsername().equals(customer.getUsername())) {
		
			
//			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		
		
		
	}
	
//	add new created user after checking for existing user to users list
	user.users.add(customer);
	
//	should add new row to user table in db before return user
	
//	return new created user after checking for existing user
	return customer;
}




	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}


	
	
	

	public String getTypeOfUser() {
		return typeOfUser;
	}



	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	
	




	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + first_name + ", lastName=" +last_name + ", username=" + username
				+  ", password=" + password +  "]";
	}


	
	

}
