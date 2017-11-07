import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Node{
	/*
	 * The Node class creates the nodes for the binary search tree.
	 * The studentFile and facultyFile calls the methods from the classes Student and Faculty.
	 * This class also creates a left and right node to indicate which way the data should go. Either a left or right.
	 */
	Students studentFile;
	Faculty facultyFile;
	Node left;
	Node right;
	public Node(Students data){
		studentFile=data;
		left = null;
		right= null;
	}
	public Node(Faculty data){
		facultyFile=data;
		left=null;
		right=null;
	}
}

public class BinarySearchTree {
	static ArrayList<String> studentList = new ArrayList<String>();
	static ArrayList<String> facultyList = new ArrayList<String>();

	Node root;
	/*
	 * The addFaculty and addStudent method recursively calls itself to add the students or faculty to the tree.
	 * The methods that do all the calculations are private as to not let outside methods mess with the calculation.
	 * So it calls itself from another method to be able to go into the method that does all the work of adding the students or faculty left or right.
	 * The method that does most of the work also tests to see if the id starts with an S or F and also checks if it is 8 digits long.
	 * It also calls on the compareTo method that is built in the Student or Faculty classes to alphabetize the last names in order.
	 * If the last names are the same then it goes to the first names.
	 */
	public void addFaculty(Faculty s){
		root = addFaculty(s, root);
	}
	
	private Node addFaculty(Faculty s, Node n){
		if((s.getFacultyId().charAt(0) !='S') || (s.getFacultyId().length() != 8) == true){
			System.out.println(s);
			throw new IllegalArgumentException("YOur FacuLty iD iS MeSseD Up.");
		}
		else if(n != null){
			if(s.compareTo(n.facultyFile)<0)
				n.left = addFaculty(s, n.left);
			else if(s.compareTo(n.facultyFile)>0)
				n.right = addFaculty(s, n.right);
		} else
			n = new Node(s);
		
		return n;
	}
	
	public void addStudent(Students s){
		root = addStudent(s, root);
	}
	private Node addStudent(Students s, Node n){
		if((s.getStudentId().charAt(0) !='S') || (s.getStudentId().length() != 8) == true){
			System.out.println(s);
			throw new IllegalArgumentException("YOur StudEnDT iD iS MeSseD Up.");
		}
		else if(n != null){
			if(s.compareTo(n.studentFile)<0)
				n.left = addStudent(s, n.left);
			else if(s.compareTo(n.studentFile)>0)
				n.right = addStudent(s, n.right);
		} else
			n = new Node(s);
		
		return n;
	}
	/*
	 * The deleteFaculty and deleteStudents deletes the specific student or faculty member from there individual trees.
	 * It searches through the tree using the compareTo method from either the Student or Faculty classes.
	 */
	public void deleteFaculty(Faculty s){
		root = deleteFaculty(s, root);
	}
	private Node deleteFaculty(Faculty s, Node n){
		if( n != null){
			if(s.compareTo(n.facultyFile)< 0)
				n.left=deleteFaculty(s, n.left);
			else if (s.compareTo(n.facultyFile)>0)
				n.right = deleteFaculty(s, n.right);
			else if(n.left == null)
				return n.right;
			else if(n.right == null)
				return n.left;
		}
		return n;
	}
	public void deleteStudent(Students s){
		root = deleteStudent(s, root);
	}
	private Node deleteStudent(Students s, Node n){
		if( n != null){
			if(s.compareTo(n.studentFile)< 0)
				n.left=deleteStudent(s, n.left);
			else if (s.compareTo(n.studentFile)>0)
				n.right = deleteStudent(s, n.right);
			else if(n.left == null)
				return n.right;
			else if(n.right == null)
				return n.left;
		}
		return n;
	}
	/*
	 * These methods simply recursively calls itself to display the data in the trees in order.
	 * It finds the root and starts from there calling itself over and over again until there is nothing left in the tree then displays.
	 * It then stores each value in order into an array list.
	 * The arrayList is then printed out onto a text file.
	 */
	public void displayFacultyInfo(BinarySearchTree bst){
		facultyInOrder(bst.root);
	}
	public void facultyInOrder(){
		facultyInOrder(root);
	}
	private static void facultyInOrder(Node n){
		if( n != null){
			facultyInOrder(n.left);
			System.out.println(n.facultyFile.toString());
			facultyList.add(n.facultyFile.toString());
			facultyInOrder(n.right);
		}
	}
	
	public void displayStudentInfo(BinarySearchTree bst){
		studentsInOrder(bst.root);
	}
	public void studentsInOrder(){
		studentsInOrder(root);
	}
	private static void studentsInOrder(Node n){
		if( n != null){
			studentsInOrder(n.left);
			System.out.println(n.studentFile.toString());
			studentList.add(n.studentFile.toString());
			studentsInOrder(n.right);
		}
	}
	
	public void printFacluty(String name){
		printToTextfile(name,facultyList);
	}
	public void printStudent(String name){
		printToTextfile(name,studentList);
	}
	public static void printToTextfile(String filename, ArrayList<String> list ){
		try{
			BufferedWriter output = new BufferedWriter(new FileWriter(filename));
			for(int i = 0; i<list.size();i++){
				output.write(list.get(i));
				output.newLine();
			}
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
