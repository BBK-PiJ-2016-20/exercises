class DoublyLinkedList {
	DoublyLinkedPatient firstPatient = null;

	public void addPatient(DoublyLinkedPatient newPatient) {
		newPatient.setNextPatient (firstPatient);
		if (firstPatient != null) {
			firstPatient.setPreviousPatient (newPatient);
		}
		firstPatient = newPatient;
	}

	public void showPatients () {
		DoublyLinkedPatient current = firstPatient;

		while (current != null) {
			current.print();
			current = current.getNextPatient();
		}
	}

	public void showPatientsBackwards() {
		if (firstPatient == null) {
			return;
		}

		DoublyLinkedPatient lastPatient = firstPatient;

		while (lastPatient.getNextPatient() != null) {
			lastPatient	= lastPatient.getNextPatient();
		}

		DoublyLinkedPatient current = lastPatient;

		while (current != null) {
			current.print();
			current = current.getPreviousPatient();
		}
	}

	public boolean deletePatient (String name, int age) {
			if (firstPatient == null) {
				return false;
			} else {
				if (firstPatient.getName().equals(name) && firstPatient.getAge() == age) {
					firstPatient = firstPatient.getNextPatient();
					firstPatient.setPreviousPatient (null);
					return true;
				}
				DoublyLinkedPatient oneBeforeCheck = firstPatient;
				while (oneBeforeCheck != null) {
					DoublyLinkedPatient toCheck = oneBeforeCheck.getNextPatient();
					if (toCheck.getName().equals(name) && toCheck.getAge() == age) {
						oneBeforeCheck.setNextPatient(toCheck.getNextPatient());
						toCheck.getNextPatient().setPreviousPatient(oneBeforeCheck);

						return true;
					}
					oneBeforeCheck = oneBeforeCheck.getNextPatient();
				}
			}

			return false;
	}

	public static void main(String[] args){
		DoublyLinkedPatient[] newEntry = {new DoublyLinkedPatient("Smith", 30, "Broken Leg"),
								new DoublyLinkedPatient("Smith", 31, "Broken Leg"),
								new DoublyLinkedPatient("Smith", 32, "Broken Arm"),
								new DoublyLinkedPatient("Smith", 14, "Broken Leg"),
								new DoublyLinkedPatient("Smith", 33, "Broken Leg"),
								new DoublyLinkedPatient("Smith", 35, "Broken Leg"),
								new DoublyLinkedPatient("Smith", 19, "Broken Leg"),
								new DoublyLinkedPatient("Smith", 56, "Broken Leg"),
								new DoublyLinkedPatient("Smith", 39, "Broken Leg"),
								new DoublyLinkedPatient("Smith", 28, "Broken Leg")};

		DoublyLinkedList manager = new DoublyLinkedList();
		for (int i = 0; i < newEntry.length; i++) {
			manager.addPatient(newEntry[i]);
		}

		manager.showPatients();

		System.out.println("And now backwards");

		manager.showPatientsBackwards();

		System.out.print("Name to delete: ");
		String nameToDelete = System.console().readLine();

		System.out.print("Age of patient to delete: ");
		int ageToDelete = Integer.parseInt(System.console().readLine());

		manager.deletePatient(nameToDelete, ageToDelete);

		manager.showPatients();
	}
}