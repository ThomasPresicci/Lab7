public class SickPerson extends Person {

	private int severity;
	
	/**
	 * Stores information about the HealthyPerson.
	 *
	 * @param name The Person's name.
	 * @param age The Person's age, in years.
	 * @param severity The severity of the illness in the SickPerson. The higher the value, the more severe theillness.
	 */
	public SickPerson(String name, int age, int severity) {
		super(name, age);
		this.severity = severity;
	}
	
	/**
	 * Implementation method for Person's compareTo
	 * method(). Does the actual legwork of comparison to
	 * compare a SickPerson (self) vs. another Person (o).
	 * 
	 * @param p The other Person to compare self to.
	 */
	@Override
	protected int compareToImpl(Person p) {
		if (p instanceof SickPerson) {
			SickPerson other = (SickPerson) p;
			return other.severity - this.severity;
		}
		return 0;
	}
	
	/**
	 * Gives some information about the SickPerson.
	 * 
	 * @return The String "%s Severity level %d" with
	 * replacements of the super's toString and
	 * the SickPerson severity.
	 */
	@Override
	public String toString() {
		return String.format("%s Severity level %d", super.toString(), severity);
	}
}
