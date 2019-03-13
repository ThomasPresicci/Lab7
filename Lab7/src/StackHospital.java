import java.util.Stack;

public class StackHospital<PatientType> extends Hospital<PatientType>{

	Stack<PatientType> patients;
	
	/**
	 * Initializes the Patient Stack.
	 */
	public StackHospital() {
		patients = new Stack<PatientType>();
	}
	
	/**
	 * Add a patient to the Hospital.
	 * 
	 * @param patient The patient to be added.
	 */
	@Override
	public void addPatient(PatientType patient) {
		patients.push(patient);		
	}

	/**
	 * Find and return the patient who will next be treated. Does not treat the 
	 * patient (i.e. it is notremoved from the collection of patients that the 
	 * hospital still must treat).
	 * 
	 * @return The patient who would be next treated.
	 */
	@Override
	public PatientType nextPatient() {
		return patients.lastElement();
	}

	/**
	 * Treats the next patient and removes them from the Hospital. Once someone is 
	 * healed theyno longer need to stay in the Hospital.
	 * 
	 * @return The patient receiving treatment.
	 */
	@Override
	public PatientType treatNextPatient() {
		return patients.pop();
	}

	/**
	 * Calculate and return the number of patients still in the hospital (untreated).
	 * 
	 * @return The number of patients in the Hospital.
	 */
	@Override
	public int numPatients() {
		return patients.size();
	}

	/**
	 * Gives a String for the hospital type.
	 * 
	 * @return A string exactly matching the class name.
	 */
	@Override
	public String hospitalType() {
		return "StackHospital";
	}

	/**
	 * Prints all patient information.
	 * 
	 * @return The toString of all patients, concatenated (don't add spaces, newlines, etc...).
	 */
	@Override
	public String allPatientInfo() {
		String info = "";
		for (PatientType patient : patients) {
			info += patient;
		}
		return info;
	}

}
