class DoublyLinkedPatient {
	private String name;
	private int age;
	private String illness;
	private DoublyLinkedPatient previousPatient;
	private DoublyLinkedPatient nextPatient;

	public DoublyLinkedPatient(String name, int age, String illness) {
		this.name = name;
		this.age = age;
		this.illness = illness;
		this.previousPatient = null;
		this.nextPatient = null;
	}

	public DoublyLinkedPatient getNextPatient () {
		return this.nextPatient;
	}

	public DoublyLinkedPatient setNextPatient (DoublyLinkedPatient newPatient) {
		return this.nextPatient = newPatient;
	}

	public DoublyLinkedPatient getPreviousPatient () {
		return this.previousPatient;
	}

	public DoublyLinkedPatient setPreviousPatient (DoublyLinkedPatient newPatient) {
		return this.previousPatient = newPatient;
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