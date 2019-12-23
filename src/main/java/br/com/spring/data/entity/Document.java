package br.com.spring.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "DOCUMENTS",
	indexes = {@Index(columnList = "CPF, RG", name = "IDX_CPF_RG", unique = true)}
		)
@NamedStoredProcedureQuery(
			name = "Document.procedureReplaceCPF",
			procedureName = "procReplaceCPF",
			parameters = {
					@StoredProcedureParameter(
							mode = ParameterMode.IN, name = "ID_IN", type = Integer.class
				),
					@StoredProcedureParameter(
							mode = ParameterMode.OUT, name = "CPF_OUT", type = String.class
				)
			}
		)
public class Document implements Serializable{
	
	@Id
	@SequenceGenerator(name = "seqDocument", initialValue = 1, sequenceName = "seqDocument", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqDocument")
	@Column(name = "ID_DOCUMENT")
	private Long id;
	
	@Column(name = "CPF", nullable = false, length = 14)
	private String cpf;
	
	@Column(name = "RG")
	private Integer rg;
	
	public Document() {
		super();
	}
	
	public Document(String cpf, Integer rg) {
		this.cpf = cpf;
		this.rg = rg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
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
		Document other = (Document) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", cpf=" + cpf + ", rg=" + rg + "]";
	}
	
	
}
