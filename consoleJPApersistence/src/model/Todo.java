package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the todo database table.
 * 
 */
@Entity
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String libelle;

	public Todo() {
	}


	@Id
//	@SequenceGenerator(name="TODO_ID_GENERATOR", sequenceName="TODO_ID_SEQ")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TODO_ID_GENERATOR")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}