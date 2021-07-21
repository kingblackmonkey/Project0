package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exceptions.InvalidCredentials;
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





//create users from input console constructor
	public  User(String  first_name, String last_name, String  password) {
		
		this.first_name =  first_name;
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
	
	
	


public User() {
	// TODO Auto-generated constructor stub
}

//get a user
public User getAuser(int userId) {
	
	List<User>userList= new ArrayList<User>();
	try {
		Connection con = conUtil.getConnection();

		
		
		String sql = "SELECT * FROM  users where id =" + "'" + userId + "';" ;
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
		

		

		
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

	
	return userList.get(0);
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
	



public List<User> getAllUsersExeptSenderAndEmployee(int sender) {
	
	List<User> userList = new ArrayList<User>();
	
	try {
		Connection con = conUtil.getConnection();
		//To create a simple statment we write our query as a string
		String sql = "SELECT * FROM users where users.id !=" + sender+ "and users.typeOfUser="+ "'" +"customer'";
		
		//We need to create a statement with this sql string
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}

		
		
		return userList;
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	return null;
	
}
	


//sign up 
	
	
public User signUp (User customer, User user) throws SQLException {
	
	
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
	Connection con = conUtil.getConnection();
	String sql = "insert into users(first_name, last_name,  username, typeOfUser ,password) values"
			+ "(?,?,?,?,?)";
	PreparedStatement ps = con.prepareStatement(sql);
	
	ps.setString(1, customer.getFirst_name());
	ps.setString(2, customer.getLast_name());
	ps.setString(3, customer.getUsername());
	ps.setString(4,customer.getTypeOfUser());
	ps.setString(5, customer.getPassword());
	
	ps.execute();
//	return new created user after checking for existing user
	return customer;
}


//login 

public User login (  String username,  String password) throws SQLException {
	//create a user 
	
//	User user = this;
	
	//rececie user name and pas word
	//make connection
	Connection con = conUtil.getConnection();
	//make a query to get the user name where pass word and user name match
	String sql = "SELECT * FROM users WHERE users.username = '" + username + "'" + "and users.password= '"  + password + "'" ;

//	System.out.println(sql);
//	String sql = "SELECT * FROM users WHERE users.username  = ? and user.password= ?";
//	PreparedStatement ps = con.prepareStatement(sql);
//	ps.setString(1, username);
//	ps.setString(2, password);
//	ResultSet rs =  ps.execute(); =>this function return boolean but i want result set
	Statement s = con.createStatement();
	ResultSet rs = s.executeQuery(sql);

	//if no user then id is default zero 
	while(rs.next()) {
		this.setId(rs.getInt(1));
		this.setFirst_name(rs.getString(2));
		this.setLast_name(rs.getString(3));
		this.setUsername(rs.getString(4));
		
	
		this.setTypeOfUser(rs.getString(5));
		this.setPassword(rs.getString(6));
		
		
	}
	
	//throw invalid credentials
	
	if(this.getId() == 0) {
	
		throw new InvalidCredentials();
	
	}
//return user ; this means user sucessful logging in
//	 System.out.println(user.getUsername());
	
	
	return this;
}







	public void setId(int id) {
	this.id = id;
}
	public int getId() {
	return id;
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
		return "User [ id=" + id + ", firstName = " + first_name + ", lastName = " +last_name + ", username = " + username
				+    ", typeOfUser = " +  typeOfUser  + ", password = " + password +  " ] " + "\n";
	}


	
	

}
