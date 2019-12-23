package br.com.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.spring.data.entity.Person;

public interface PersonRepositoy extends JpaRepository<Person, Long>{
	
	/**
	 * Busca por age igual ao parametro fornecido.
	 * 
	 * @param age
	 * @return
	 */
	List<Person> findByAge(Integer age);
	
	/**
	 * Busca por age diferente do parametro fornecido.
	 * @param age
	 * @return
	 */
	List<Person> findByAgeNot(Integer age);
	
	/**
	 * Busca por firstName igual ao parametro fornecido.
	 * @param firstName
	 * @return
	 */
	List<Person> findByFirstNameLike(String firstName);
	
	/**
	 * Busca por firstName diferente do parametro fornecido.
	 * @param firstName
	 * @return
	 */
	List<Person> findByFirstNameNotLike(String firstName);
	
	/**
	 * Retorna pessoa atraves dos parametros de firstName e lastName.
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	/**
	 * Busca por age OR firstName via parametros.
	 * @param age
	 * @param firstName
	 * @return
	 */
	List<Person> findByAgeOrFirstName(Integer age, String firstName);
	
	/**
	 * Busca por age usando Between
	 * @param min
	 * @param max
	 * @return
	 */
	List<Person> findByAgeBetween(int min, int max);
	
	/**
	 * Busca por LastName AND age between.
	 * @param lastName
	 * @param min
	 * @param max
	 * @return
	 */
	List<Person> findByLastNameAndAgeBetween(String lastName, int min, int max);
	
	/**
	 * Busca por Age maior que o parametro.
	 * @param age
	 * @return
	 */
	List<Person> findByAgeGreaterThan(Integer age);
	
	/**
	 * Busca por Age menor que o parametro.
	 * @param age
	 * @return
	 */
	List<Person> findByAgeLessThan(Integer age);
	
	/**
	 * Busca por Age maior ou igual que o parametro.
	 * @param age
	 * @return
	 */
	List<Person> findByAgeGreaterThanEqual(Integer age);
	
	/**
	 * Busca por Age menor ou igual que o parametro.
	 * @param age
	 * @return
	 */
	List<Person> findByAgeLessThanEqual(Integer age);
	
	/**
	 * Busca por firstName maior que o valor informado.
	 * @param firstName
	 * @return
	 */
	List<Person> findByFirstNameGreaterThan(String firstName);
	
	/**
	 * Busca por Age baseada em uma lista de parametros.
	 * @param ages
	 * @return
	 */
	List<Person> findByAgeIn(Integer... ages);
	
	/**
	 * Busca por Age baseada em uma lista de parametros que sera negada.
	 * @param ages
	 * @return
	 */
	List<Person> findByAgeNotIn(Integer... ages);
	
	/**
	 * Busca por firstName ignorando letras maiusculas e minusculas.
	 * @param firstName
	 * @return
	 */
	List<Person> findByFirstNameIgnoreCase(String firstName);
	
	/**
	 * Busca por linhas em person que tenham document_id null
	 * @return
	 */
	List<Person> findByDocumentIsNull();
	
	/**
	 * Busca por linhas em person que não contenham o document_id iguais a null
	 * @return
	 */
	List<Person> findByDocumentIsNotNull();
	
	/**
	 * Busca por number via phones mapeado em person.
	 * @param number
	 * @return
	 */
	List<Person> findByPhonesNumberStartingWith(String number);
	
	/**
	 * Busca pela idade maior que o parametro, ordenando pelo firstName e LastName de forma ascendente
	 * @param age
	 * @return
	 */
	List<Person> findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(Integer age);
	
	@Query("select p from Person p where p.firstName like ?1")
	List<Person> findByFirstName(String firstName);
	
	@Query("select p from Person p where p.firstName like ?1 or p.age = ?2")
	List<Person> findByFirstNameOrAge(String firstName, Integer ager);
	
	@Query("select p from Person p where p.firstName like ?2 and p.age = ?1")
	List<Person> findByFirstNameAndAge(Integer age, String firstName);
	
	@Query("select p from Person p where p.document.cpf like %?1")
	List<Person> findByDocumentCPFEndsWith(String value);
	
	@Query("select p from Person p where p.age >= :min and p.age <= :max")
	List<Person> findByAgeBetweenParams(@Param("min") Integer start, @Param("max") Integer end);
	
	@Query("select p from Person p where p.firstName in :names order by p.age asc")
	List<Person> findByFirstNames(@Param("names") String ... firstsNames);

}
