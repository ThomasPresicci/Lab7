import org.junit.Assert;
import org.junit.Test;

public class HospitalTest {
	@Test
	public void SickPersonTest() {
		SickPerson p = new SickPerson("Jeff", 30, 5);
		Assert.assertTrue("Name incorrect.", p.getName().equals("Jeff"));
		Assert.assertEquals("Age incorrect.", 30, p.getAge());
	}
	
	@Test
	public void HealthyPersonTest() {
		HealthyPerson p = new HealthyPerson("Jeff", 30, "Flu");
		Assert.assertTrue("Name incorrect.", p.getName().equals("Jeff"));
		Assert.assertEquals("Age incorrect.", 30, p.getAge());
	}
	
	@Test
	public void AnimalTest() {
		Animal a = new Animal("Pug", 6);
		Assert.assertTrue("Breed incorrect.", a.getBreed().equals("Pug"));
		Assert.assertEquals("Age incorrect.", 6, a.getAge());
	}
	
	@Test
	public void QueueHospitalTest() {
		HealthyPerson p = new HealthyPerson("Jeff", 30, "Flu");
		SickPerson p2 = new SickPerson("Lara", 35, 5);
		SickPerson p3 = new SickPerson("Cloe", 27, 7);
		
		HealthyPerson p4 = new HealthyPerson("Gram", 41, "Cold");
		
		QueueHospital<Person> q = new QueueHospital<Person>();
		
		q.addPatient(p);
		q.addPatient(p2);
		q.addPatient(p3);
		
		Assert.assertTrue("hospitalType incorrect.", q.hospitalType().equals("QueueHospital"));
		Assert.assertTrue("nextPatient incorrect.", q.nextPatient().getName().equals(p.getName()));
		Assert.assertTrue("addPatient incorrect.", q.allPatientInfo().equals(p + "" + p2 + "" + p3));
		Assert.assertEquals("numPatients incorrect.", 3, q.numPatients());
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p.getName()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p2.getName()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p3.getName()));
		Assert.assertEquals("numPatients incorrect.", 0, q.numPatients());
		
		q.addPatient(p4);
		
		Assert.assertEquals("numPatients incorrect.", 1, q.numPatients());
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p4.getName()));
		Assert.assertEquals("numPatients incorrect.", 0, q.numPatients());
	}
	
	@Test
	public void StackHospitalTest() {
		HealthyPerson p = new HealthyPerson("Jeff", 30, "Flu");
		SickPerson p2 = new SickPerson("Lara", 35, 5);
		SickPerson p3 = new SickPerson("Cloe", 27, 7);
		
		HealthyPerson p4 = new HealthyPerson("Gram", 41, "Cold");
		
		StackHospital<Person> q = new StackHospital<Person>();
		
		q.addPatient(p);
		q.addPatient(p2);
		q.addPatient(p3);
		
		Assert.assertTrue("hospitalType incorrect.", q.hospitalType().equals("StackHospital"));
		Assert.assertTrue("nextPatient incorrect.", q.nextPatient().getName().equals(p3.getName()));
		Assert.assertTrue("addPatient incorrect.", q.allPatientInfo().equals(p + "" + p2 + "" + p3));
		Assert.assertEquals("numPatients incorrect.", 3, q.numPatients());
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p3.getName()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p2.getName()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p.getName()));
		Assert.assertEquals("numPatients incorrect.", 0, q.numPatients());
		
		q.addPatient(p4);
		
		Assert.assertEquals("numPatients incorrect.", 1, q.numPatients());
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p4.getName()));
		Assert.assertEquals("numPatients incorrect.", 0, q.numPatients());
	}
	
	@Test
	public void PriorityQueueHospitalTest() {
		HealthyPerson p = new HealthyPerson("Jeff", 30, "Flu");
		HealthyPerson p4 = new HealthyPerson("Aaron", 41, "Cold");
		SickPerson p2 = new SickPerson("Lara", 35, 5);
		SickPerson p3 = new SickPerson("Cloe", 27, 7);
		
		HealthyPerson p5 = new HealthyPerson("Gram", 55, "Yearly checkup");
		
		PriorityQueueHospital<Person> q = new PriorityQueueHospital<Person>();
		
		q.addPatient(p);
		q.addPatient(p4);
		q.addPatient(p2);
		q.addPatient(p3);
		
		Assert.assertTrue("hospitalType incorrect.", q.hospitalType().equals("PriorityQueueHospital"));
		Assert.assertTrue("nextPatient incorrect.", q.nextPatient().getName().equals(p4.getName()));
		Assert.assertTrue("addPatient incorrect.", q.allPatientInfo().equals(p4 + "" + p + "" + p2 + "" + p3));
		Assert.assertEquals("numPatients incorrect.", 4, q.numPatients());
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p4.getName()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p3.getName()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p2.getName()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p.getName()));
		Assert.assertEquals("numPatients incorrect.", 0, q.numPatients());
		
		q.addPatient(p5);
		
		Assert.assertEquals("numPatients incorrect.", 1, q.numPatients());
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p5.getName()));
		Assert.assertEquals("numPatients incorrect.", 0, q.numPatients());
		
		q.addPatient(p2);
		q.addPatient(p3);
		
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p3.getName()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getName().equals(p2.getName()));
	}
	
	@Test
	public void PriorityQueueHospitalAnimalTest() {
		Animal a = new Animal("Pug", 6);
		Animal a2 = new Animal("Bulldog", 10);
		Animal a3 = new Animal("Chihuahua", 3);
		
		PriorityQueueHospital<Animal> q = new PriorityQueueHospital<Animal>();
		
		q.addPatient(a);
		q.addPatient(a2);
		q.addPatient(a3);
		
		Assert.assertTrue("hospitalType incorrect.", q.hospitalType().equals("PriorityQueueHospital"));
		Assert.assertTrue("nextPatient incorrect.", q.nextPatient().getBreed().equals(a2.getBreed()));
		Assert.assertTrue("addPatient incorrect.", q.allPatientInfo().equals(a2 + "" + a + "" + a3));
		Assert.assertEquals("numPatients incorrect.", 3, q.numPatients());
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getBreed().equals(a2.getBreed()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getBreed().equals(a.getBreed()));
		Assert.assertTrue("treatNextPatient incorrect.", q.treatNextPatient().getBreed().equals(a3.getBreed()));
		Assert.assertEquals("numPatients incorrect.", 0, q.numPatients());
	}
}
