package br.com.spring.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESSES")
@NamedQueries(value = {
		@NamedQuery(
				name = "Address.buscaPorCidade",
				query = "select a from Address a where a.city like ?1"
		)
})

@NamedNativeQueries(value = {
		@NamedNativeQuery(
				name = "Address.buscaPorEndereco",
				query = "select * from addresses where city like ?1 and street like ?2",
				resultClass = Address.class
		),
		@NamedNativeQuery(
				name = "Address.functionConcatenaEndereco",
				query ="select funcConcat(?1)"
		)
})
public class Address implements Serializable{
	
	public enum TypeAddress{
		COMERCIAL,RESIDENCIAL
	}
	
	@Id
	@SequenceGenerator(name = "seqAddress", initialValue = 1, sequenceName = "seqAddress", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqAddress")
	@Column(name = "ID_ADDRESS")
	private Long id;
	
	@Column(name = "CITY", nullable = false)
	private String city;
	
	@Column(name = "STREET", nullable = false)
	private String street;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_ADDRESS", nullable = false)
	private TypeAddress type;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PERSONS_ADDRESSES",
		joinColumns = @JoinColumn(name = "ID_ADDRESS"),
		inverseJoinColumns = @JoinColumn(name = "ID_PERSON")
	)
	private List<Person> persons;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public TypeAddress getType() {
		return type;
	}

	public void setType(TypeAddress type) {
		this.type = type;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street + ", type=" + type + "]";
	}
}
