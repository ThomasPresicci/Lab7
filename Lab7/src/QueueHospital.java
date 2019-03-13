import java.util.LinkedList;
import java.util.Queue;

public class QueueHospital<PatientType> extends Hospital<PatientType> {

	private Queue<PatientType> patients;
	
	/**
	 * Initializes the Patient Queue.
	 */
	public QueueHospital() {
		patients = new LinkedList<PatientType>();
	}
	
	/**
	 * Add a patient to the Hospital.
	 * 
	 * @param patient The patient to be added.
	 */
	@Override
	public void addPatient(PatientType patient) {
		patients.add(patient);
	}

	/**
	 * Find and return the patient who will next be treated. Does not 
	 * treat the patient (i.e. it is notremoved from the collection of 
	 * patients that the hospital still must treat).
	 * 
	 * @return The patient who would be next treated.
	 */
	@Override
	public PatientType nextPatient() {
		return patients.peek();
	}

	/**
	 * Treats the next patient and removes them from the Hospital. 
	 * Once someone is healed theyno longer need to stay in the Hospital.
	 * 
	 * @return The patient receiving treatment.
	 */
	@Override
	public PatientType treatNextPatient() {
		return patients.poll();
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
		return "QueueHospital";
	}

	/**
	 * Prints all patient information.
	 * 
	 * return The toString of all patients, concatenated (don't add spaces, newlines, etc...).
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
