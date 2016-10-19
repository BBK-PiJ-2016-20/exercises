class Patient {
	private String name;
	private int age;
	private String illness;
	private Patient nextPatient;

	public Patient (String name, int age, String illness) {
		this.name = name;
		this.age = age;
		this.illness = illness;
		this.nextPatient = null;
	}

	public Patient getNextPatient (){
		return this.nextPatient;
	}

	public Patient setNextPatient (Patient newPatient) {
		return this.nextPatient = newPatient;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void print() {
		System.out.println("Name: " + name + "  Age: " + age + "  " + "Illness: " + illness);
	}


}