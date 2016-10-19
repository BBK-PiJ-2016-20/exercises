class HospitalManager {
	private Patient firstPatient = null;

	public void addPatient (Patient newPatient) {
		newPatient.setNextPatient (firstPatient);
		firstPatient = newPatient;
	}

	public void showPatients () {
		Patient current = firstPatient;

		while (current != null) {
			current.print();
			current = current.getNextPatient();
		}
	}

	public boolean deletePatient (String name, int age) {
		if (firstPatient == null) {
			return false;
		} else {
			if (firstPatient.getName().equals(name) && firstPatient.getAge() == age) {
				firstPatient = firstPatient.getNextPatient();
				return true;
			}
			Patient oneBeforeCheck = firstPatient;
			while (oneBeforeCheck != null) {
				Patient nextPatient = oneBeforeCheck.getNextPatient();
				if (nextPatient.getName().equals(name) && nextPatient.getAge() == age) {
					oneBeforeCheck.setNextPatient(nextPatient.getNextPatient());
					return true;
				}
				oneBeforeCheck = oneBeforeCheck.getNextPatient();
			}
		}

		return false;
	}

	public static void main(String[] args){
		Patient[] newEntry = {new Patient("Smith", 30, "Broken Leg"),
								new Patient("Smith", 31, "Broken Leg"),
								new Patient("Smith", 32, "Broken Arm"),
								new Patient("Smith", 14, "Broken Leg"),
								new Patient("Smith", 33, "Broken Leg"),
								new Patient("Smith", 35, "Broken Leg"),
								new Patient("Smith", 19, "Broken Leg"),
								new Patient("Smith", 56, "Broken Leg"),
								new Patient("Smith", 39, "Broken Leg"),
								new Patient("Smith", 28, "Broken Leg")};

		HospitalManager manager = new HospitalManager();
		for (int i = 0; i < newEntry.length; i++) {
			manager.addPatient(newEntry[i]);
		}

		manager.showPatients();

		System.out.print("Name to delete: ");
		String nameToDelete = System.console().readLine();

		System.out.print("Age of patient to delete: ");
		int ageToDelete = Integer.parseInt(System.console().readLine());

		manager.deletePatient(nameToDelete, ageToDelete);

		manager.showPatients();

	}
}