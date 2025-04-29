class Student {
	private String name;
	private int age;
	private int studentNumber;

	public Student(String name, int age, int studentNumber) {
		this.name = name;
		this.age = age;
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
	public int getStudentNumber() {
		return this.studentNumber;
	}

	@Override
	public Student clone() {
		Student student = new Student(this.name, this.age, this.studentNumber);
		return student;
	}

	@Override
	public String toString() {
		return this.name + " " + this.age + " " + this.studentNumber;
	}
}