package com.bigcorp.journal.main.recordd;

import java.util.Objects;

import com.bigcorp.journal.main.sealedd.Celeste;

public class DtoAsClass {
	
	private final Integer identifiant;
	private final String nom;
	private final Celeste objetCeleste;

	public DtoAsClass(Integer identifiant, String nom, Celeste objetCeleste) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.objetCeleste = objetCeleste;
		
	}

	public Integer getIdentifiant() {
		return identifiant;
	}

	public String getNom() {
		return nom;
	}

	public Celeste getObjetCeleste() {
		return objetCeleste;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identifiant, nom, objetCeleste);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoAsClass other = (DtoAsClass) obj;
		return Objects.equals(identifiant, other.identifiant) && Objects.equals(nom, other.nom)
				&& Objects.equals(objetCeleste, other.objetCeleste);
	}

	@Override
	public String toString() {
		return "TestRecord [identifiant=" + identifiant + ", nom=" + nom + ", objetCeleste=" + objetCeleste + "]";
	}

}