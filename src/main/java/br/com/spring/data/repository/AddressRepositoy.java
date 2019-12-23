package br.com.spring.data.repository;

import java.util.List;

import javax.print.attribute.standard.MediaSize.NA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.spring.data.entity.Address;

public interface AddressRepositoy extends JpaRepository<Address, Long>{
	
	/**
	 * busca por city conforme o inicio da palavra.
	 * @param city
	 * @return
	 */
	List<Address> findByCityStartingWith(String city);
	
	/**
	 * busca por street conforme o termino da palavra.
	 * @param street
	 * @return
	 */
	List<Address> findByStreetEndingWith(String street);
	
	/**
	 * busca por street que contem palavra passada no parametro.
	 * @param street
	 * @return
	 */
	List<Address> findByStreetContaining(String street);
	
	/**
	 * Busca por city ou street conforme a igualdade da sequencia de caracteres.
	 * @param city
	 * @param street
	 * @return
	 */
	List<Address> findByCityStartingWithOrStreetEndingWith(String city,String street);
	
	/**
	 * Busca por city e ordena por type de forma descendente.
	 * @param city
	 * @return
	 */
	List<Address> findByCityOrderByTypeDesc(String city);
	
	/**
	 * Usando @NamedQuery na entidade.
	 * @param cidade
	 * @return
	 */
	List<Address> buscaPorCidade(String cidade);
	
	/**
	 * Usando @NamedNativeQuery na entidade.
	 * @param cidade
	 * @return
	 */
	Address buscaPorEndereco(String city, String street);
	
	@Query(	value = "select * from Addresses where city like ?1 and street like ?2",
			nativeQuery = true)
	Address buscaPorCidadeRua(String city, String street);

}
