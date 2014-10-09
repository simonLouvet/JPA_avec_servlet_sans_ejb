package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the todo database table.
 * 
 */
@Entity
@Table(name="todo")
@Access(AccessType.FIELD)
public class Titi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="TODO_ID_GENERATOR", sequenceName="TODO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TODO_ID_GENERATOR")
	private Long identifiant;

	@Column(name="libelle")
	private String texte;


	/**
	 * @return the texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * @param texte the texte to set
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}

	/**
	 * @return the identifiant
	 */
	public Long getIdentifiant() {
		return identifiant;
	}

	

}