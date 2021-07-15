package fileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.User;


public class FileIO <T> {
	 public String fileName;
	
//	constructor
	
	public FileIO(String fileName) {
		this.fileName = fileName;
	}
	
	//read method
	

	public ArrayList<T> readObject() throws FileNotFoundException, IOException{
		ArrayList<T> dynamicObjectsArrayList;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		try {
			dynamicObjectsArrayList= (ArrayList<T>) ois.readObject();
			return dynamicObjectsArrayList;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			ois.close();
		}
		return dynamicObjectsArrayList = new ArrayList<T>();
	}
	
	//	write method
	
	
	public void writeObject(ArrayList<T> users) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(users);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
