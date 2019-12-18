package br.com.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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

}
