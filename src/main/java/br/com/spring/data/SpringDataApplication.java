package br.com.spring.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.com.spring.data.entity.Address;
import br.com.spring.data.entity.Address.TypeAddress;
import br.com.spring.data.entity.Document;
import br.com.spring.data.entity.Person;
import br.com.spring.data.entity.Phone;
import br.com.spring.data.entity.Phone.TypePhone;
import br.com.spring.data.repository.AddressRepositoy;
import br.com.spring.data.repository.DocumentRepositoy;
import br.com.spring.data.repository.PersonRepositoy;
import br.com.spring.data.repository.PhoneRepositoy;

@SpringBootApplication
@ImportResource(value = "spring-data.xml")
public class SpringDataApplication implements CommandLineRunner{
	
	@Autowired
	private PersonRepositoy personRepositoy;
	
	@Autowired
	private AddressRepositoy addressRepositoy;
	
	@Autowired
	private DocumentRepositoy documentRepositoy;
	
	@Autowired
	private PhoneRepositoy phoneRepositoy;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		testConfiguration();
//		testSave();
//		testUpdate();
//		testDelete();
//		testSavePerson();
//		testSaveAddress();
//		testDeletePerson();
//		testFindAndSort();
//		testFindByIds();
//		testExists();
//		testPagination();
		
//		testByAge();
//		testByFirstNameLike();
//		testByAndOr();
//		testByBetween();
//		testByLastNameAndBetween();
//		testByGreaterAndLess();
//		testByGreaterAndLessEquals();
//		testByFirstNameGreaterThan();
		
//		testByStartAndEnd();
//		testContaining();
//		testByAddressStartAndEnding();
		
	}

	private void testByAddressStartAndEnding() {
		List<Address> a1 = addressRepositoy.findByCityStartingWithOrStreetEndingWith("Rio", "1022");
		a1.forEach(System.out::println);
	}

	private void testContaining() {
		List<Address> a1 = addressRepositoy.findByStreetContaining("Rio");
		a1.forEach(System.out::println);
	}

	private void testByStartAndEnd() {
		List<Address> a1 = addressRepositoy.findByCityStartingWith("Rio");
		a1.forEach(System.out::println);
		
		System.out.println("********************************************");
		
		List<Address> a2 = addressRepositoy.findByStreetEndingWith("1022");
		a2.forEach(System.out::println);
	}

	private void testByFirstNameGreaterThan() {
		List<Person> p1 = personRepositoy.findByFirstNameGreaterThan("V");
		p1.forEach(System.out::println);
		
	}

	private void testByGreaterAndLessEquals() {
		List<Person> p1 = personRepositoy.findByAgeGreaterThanEqual(19);
		p1.forEach(System.out::println);
		
		System.out.println("********************************************");
		
		List<Person> p2 = personRepositoy.findByAgeLessThanEqual(19);
		p2.forEach(System.out::println);
	}

	private void testByGreaterAndLess() {
		List<Person> p1 = personRepositoy.findByAgeGreaterThan(29);
		p1.forEach(System.out::println);
		
		System.out.println("********************************************");
		
		List<Person> p2 = personRepositoy.findByAgeLessThan(29);
		p2.forEach(System.out::println);
		
	}

	private void testByLastNameAndBetween() {
		
		List<Person> p1 = personRepositoy.findByLastNameAndAgeBetween("Souza", 19, 29);
		p1.forEach(System.out::println);

		
	}

	private void testByBetween() {
		List<Person> p1 = personRepositoy.findByAgeBetween(19, 29);
		p1.forEach(System.out::println);
		
		
	}

	private void testByAndOr() {
		
		Person p1 = personRepositoy.findByFirstNameAndLastName("Vinicius", "Carvalho");
		System.out.println(p1.toString());
		
		System.out.println("********************************************");
		
		List<Person> p2 = personRepositoy.findByAgeOrFirstName(19, "Fabio");
		p2.forEach(System.out::println);
	}

	private void testByFirstNameLike() {
		
		List<Person> p1 = personRepositoy.findByFirstNameLike("Vinicius");
		p1.forEach(System.out::println);
		
		System.out.println("********************************************");
		
		
		List<Person> p2 = personRepositoy.findByFirstNameNotLike("Vinicius");
		p2.forEach(System.out::println);
		
	}

	private void testByAge() {
		
		List<Person> p1 = personRepositoy.findByAge(19);
		
		p1.forEach(System.out::println);
		
		System.out.println("********************************************");
		
		List<Person> p2 = personRepositoy.findByAgeNot(19);
		
		p2.forEach(System.out::println);

		
	}

	private void testPagination() {
		
		Page<Person> pages = personRepositoy.findAll(PageRequest.of(0, 5));
		pages.getContent().forEach(System.out::println);
		
		pages = personRepositoy.findAll(PageRequest.of(1, 5));
		pages.getContent().forEach(System.out::println);
		
		pages = personRepositoy.findAll(PageRequest.of(2, 5));
		pages.getContent().forEach(System.out::println);
		
	}

	private void testExists() {
		
		Boolean p1 = personRepositoy.existsById(13L);
		System.out.println(p1);
		
		Boolean p2 = personRepositoy.existsById(113L);
		System.out.println(p2);
		
	}

	private void testFindByIds() {
		List<Person> persons = personRepositoy.findAllById(Arrays.asList(6L,7L,13L));
		persons.forEach(System.out::println);
	}

	private void testFindAndSort() {
		
		System.out.println("ORDEM ASCENDENTE :");
		List<Person> persons = personRepositoy.findAll(Sort.by("firstName").ascending());
		persons.forEach(System.out::println);
		
		System.out.println("ORDEM DECRECENTE :");
		List<Person> persons1 = personRepositoy.findAll(Sort.by("firstName").descending());
		persons1.forEach(System.out::println);
		
	}

	private void testDeletePerson() {
		Person p1 = personRepositoy.findById(37L).get();
//		Person p2 = personRepositoy.findById(9L).get();
//		Person p3 = personRepositoy.findById(10L).get();
		
		personRepositoy.deleteAll(Arrays.asList(p1));
		
		System.out.println("****************************************************************");
//		
//		Person p4 = personRepositoy.findById(11L).get();
//		Person p5 = personRepositoy.findById(12L).get();
//		Person p6 = personRepositoy.findById(12L).get();
//		
//		personRepositoy.deleteInBatch(Arrays.asList(p4,p5,p6));
		
		
	}

	private void testSavePerson() {
		Person p1 = new Person();
		p1.setFirstName("Alisson");
		p1.setLastName("Souza");
		p1.setAge(25);
		p1.setDocument(new Document("123.123.123-59",123456789));
		
		Person p2 = new Person();
		p2.setFirstName("Bruno");
		p2.setLastName("Pereira");
		p2.setAge(63);
		p2.setDocument(new Document("223.123.123-59",123456789));
		
		Person p3 = new Person();
		p3.setFirstName("Carlos Ricardo");
		p3.setLastName("Pereira");
		p3.setAge(45);
		p3.setDocument(new Document("323.123.123-59",123456789));
		
		Person p4 = new Person();
		p4.setFirstName("Fabio");
		p4.setLastName("Guimaraes");
		p4.setAge(33);
		p4.setDocument(new Document("413.123.123-59",123456789));
		
		Person p5 = new Person();
		p5.setFirstName("Vinicius");
		p5.setLastName("Carvalho");
		p5.setAge(19);
		p5.setDocument(new Document("513.123.123-59",123456789));
		
		Person p6 = new Person();
		p6.setFirstName("Carla");
		p6.setLastName("Souza");
		p6.setAge(23);
		p6.setDocument(new Document("613.123.123-59",123456789));
		
		List<Person> persons = 		
		personRepositoy.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		persons.forEach(System.out::println);
	}
	
	private void testSaveAddress() {
		Person p1 = personRepositoy.findById(35L).get();
		Person p2 = personRepositoy.findById(6L).get();
		
		Address address = new Address();
		address.setCity("Rio de Janeiro");
		address.setPersons(Arrays.asList(p1));
		address.setStreet("Av Copacabana, 33");
		address.setType(TypeAddress.RESIDENCIAL);
		
		Address address1 = new Address();
		address1.setCity("Rio de Janeiro");
		address1.setPersons(Arrays.asList(p1));
		address1.setStreet("Av Rio Grande, 13");
		address1.setType(TypeAddress.RESIDENCIAL);
		
		Address address2 = new Address();
		address2.setCity("Diadema");
		address2.setPersons(Arrays.asList(p2));
		address2.setStreet("Rua Quito, 82");
		address2.setType(TypeAddress.RESIDENCIAL);
		
		Address address3 = new Address();
		address3.setCity("São Paulo");
		address3.setPersons(Arrays.asList(p2));
		address3.setStreet("Av Domingo de Morais, 1022");
		address3.setType(TypeAddress.COMERCIAL);
		
		addressRepositoy.saveAll(Arrays.asList(address,address1,address2,address3));
		
	}

	private void testDelete() {
		personRepositoy.deleteById(1l);
		
		Person person = personRepositoy.findById(4l).get();
		
		personRepositoy.delete(person);
		
		List<Person> persons = personRepositoy.findAll();
		persons.forEach(p -> System.out.println(p.getFirstName()));
	}

	private void testUpdate() {
		Person person = personRepositoy.findById(1L).get();
		
		System.out.println(person.toString());
		
		person.setLastName("Souza");
		
		personRepositoy.save(person);
		
		Person person2 = personRepositoy.findById(1L).get();
		
		System.out.println(person2.toString());

	}

	private void testSave() {
		Person person = new Person();
		person.setFirstName("Gustavo");
		person.setLastName("Carvalho");
		person.setAge(55);
		person.setDocument(new Document("423.456.789-59", 123456789));
		
		Address address = new Address();
		address.setCity("SBC");
		address.setStreet("Rua Paulo Machado de Carvalho, 9");
		address.setType(TypeAddress.RESIDENCIAL);
		
		person.setAddresses(Arrays.asList(address));
		person.addPhone(new Phone(TypePhone.CELULAR,"993224532"));
		
		personRepositoy.save(person);
		
		Person ps = personRepositoy.findById(person.getId()).get();
		
		System.out.println(ps.toString());
		
	}

	private void testConfiguration() {
		
		long total = personRepositoy.count();
		System.out.println("Total of persons = " + total);
		
		long total1 = addressRepositoy.count();
		System.out.println("Total of address = " + total1);
		
		long total2 = documentRepositoy.count();
		System.out.println("Total of documents = " + total2);
		
		long total3 = phoneRepositoy.count();
		System.out.println("Total of phones = " + total3);
		
		List<Person> persons = personRepositoy.findAll();
		persons.forEach(p -> System.out.println(p.getFirstName()));
		
		List<Address> addresses = addressRepositoy.findAll();
		addresses.forEach(System.out::println);
		
		List<Document> documents = documentRepositoy.findAll();
		documents.forEach(System.out::println);
		
		List<Phone> phones = phoneRepositoy.findAll();
		phones.forEach(System.out::println);
		
	}

}
