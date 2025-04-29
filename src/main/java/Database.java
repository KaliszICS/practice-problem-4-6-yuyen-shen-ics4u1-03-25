class Database {

	//empty since we have no students
	private Student[] students;

	public Database() {
		this.students = new Student[0];
	}

	public Database(Student student) {
		this.students = new Student[]{student.clone()};  //clone the student so it isn't editable externally
	}

	public Database(Student[] students) {
		this.students = students; //this is accessible outside of the array since it a reference.
		//create a copy if you want to keep it seperate
	}

	public void addStudent(Student student) {
		Student[] newStudents = new Student[this.students.length+1];
		for (int i = 0; i < this.students.length; i++) {
			newStudents[i] = this.students[i]; //copy each value over
		}
		newStudents[newStudents.length - 1] = student.clone(); //add a copy of the student to end of new array
		this.students = newStudents; //replace our instance variable array with the new one we made
	}

	//create as many methods as you require
	public void removeStudent(Student student) {
		
	}

	public Student[] getStudents() {
		return this.students;
	}

	@Override
	public String toString() {  //reuse toString method from Student
		String result = "";
		for (int i =0; i < this.students.length; i++) {
			result += this.students[i].toString() + ", ";
		}
		return result;
	}
	
}