public class Students {
	/*
	 * This creates getter and setters for the firsName, lastName, and id.
	 * It makes them private so no other methods outside of this class can call on them.
	 */
	private String firstName;
	private String lastName;
	private String studentId;
	public Students(String first, String last, String id){
		firstName=first;
		lastName=last;
		studentId=id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/*
	 * Compares the id of the faculty members to the new member.
	 */
	public boolean equals(String id){
		return id.equals(studentId);
	}
	/*
	 * This method compares the last name and alphabetizes it.
	 * If the last names are the same then compare the first names.
	 * If both the first and last names are the same then it is the same person being entered twice.
	 */
	public int compareTo(Students s){
		if(s.getLastName().compareToIgnoreCase(lastName)<0)
			return 1;
		else if(s.getLastName().compareToIgnoreCase(lastName)>0)
			return -1;
		else if(s.getLastName().compareToIgnoreCase(lastName)==0){
			if(s.getFirstName().compareToIgnoreCase(firstName)<0)
				return 1;
			else if(s.getFirstName().compareToIgnoreCase(firstName)>0)
				return -1;
			else
				throw new IllegalArgumentException("The same student entered twice.");
		}
		return 0;
	}
	/*
	 * This simply just returns the first name, last name and id number to be displayed.
	 */
	public String toString() {
		String temp ="Student: "+lastName + ", "+firstName + " ID: "+studentId;
		return temp;
	}
	public int last4(){
		int temp = Integer.parseInt(studentId.substring(4, studentId.length()));
		return temp;
	}
}
