import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Students a = new Students("Elijah", "Stone", "S1001044");
		Students b = new Students("Janice", "Casey", "S3001031");
		Students c = new Students("Elsie", "Castillo", "S8001043");
		Students d = new Students("Wendell", "Bailey", "S5001032");
		Students e = new Students("Edgar", "Cohen", "S6001038");
		Students f = new Students("Korusake", "Ichigo", "S2001047");
		Students g = new Students("All", "Might", "S4001046");
		Students h = new Students("Shaer","Hasan", "S8001002");
		
		Faculty A = new Faculty("Adam", "Sandler", "S1000033");
		Faculty B = new Faculty("Bart", "Simpson", "S3000012");
		Faculty C = new Faculty("Fares", "Beuler", "S8000013");
		Faculty D = new Faculty("Jack", "Frost", "S5000034");
		Faculty E = new Faculty("Hiraga", "Saito", "S6000026");
		Faculty F = new Faculty("Timothy", "Moore", "S2000028");
		Faculty G = new Faculty("Eric", "Obrien", "S4000024");
		Faculty H = new Faculty("Shaer","Hasan", "S2321001");

		
		BinarySearchTree s = new BinarySearchTree();
		BinarySearchTree n = new BinarySearchTree();
		
		s.addStudent(a);
		s.addStudent(b);
		s.addStudent(c);
		s.addStudent(d);
		s.addStudent(e);
		s.addStudent(f);
		s.addStudent(g);
		s.addStudent(h);
		n.addFaculty(A);
		n.addFaculty(B);
		n.addFaculty(C);
		n.addFaculty(D);
		n.addFaculty(E);
		n.addFaculty(F);
		n.addFaculty(G);
		n.addFaculty(H);
		
		
		s.displayStudentInfo(s);
		s.printStudent("Students.txt");
		System.out.println();
		s.displayFacultyInfo(n);
		s.printFacluty("Faculty.txt");

		HashTable ht = new HashTable(50);
		ht.add(a.last4(), a);
		ht.add(b.last4(), b);
		ht.add(c.last4(), c);
		ht.add(d.last4(), d);
		ht.add(e.last4(), e);
		ht.add(f.last4(), f);
		ht.add(g.last4(), g);
		ht.add(h.last4(), h);
		ht.add(A.last4(), A);
		ht.add(B.last4(), B);
		ht.add(C.last4(), C);
		ht.add(D.last4(), D);
		ht.add(E.last4(), E);
		ht.add(F.last4(), F);
		ht.add(G.last4(), G);
		ht.add(H.last4(), H);
		ht.dump();
		
	}

}
