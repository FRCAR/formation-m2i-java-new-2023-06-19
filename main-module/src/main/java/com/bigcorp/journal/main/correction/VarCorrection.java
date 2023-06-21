package com.bigcorp.journal.main.correction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class VarCorrection {

	public static void main(String[] args) {
		var varCorrection = new VarCorrection();

		// Cette méthode stocke des variables de type var à partir de :
		// types primitifs
		var monInt = 3;
		var monDouble = 3.14;
		var monBooleen = true;

		// objets construits
		var monPremierCaillou = new Caillou();
		monPremierCaillou.setNom("Pierre");

		// appels d’autres méthodes
		var monDeuxiemeCaillou = varCorrection.getCaillou();
		monDeuxiemeCaillou.setNom("The Rock");
		System.out.println(monDeuxiemeCaillou);
		var toto = varCorrection.getToto();

		// Créer aussi une collection et itérer dessus en utilisant var
		List<Caillou> cailloux = new ArrayList<>();
		cailloux.add(monPremierCaillou);
		cailloux.add(monDeuxiemeCaillou);

		for (var caillou : cailloux) {
			System.out.println("J'ai un caillou nommé : " + caillou.getNom());
		}

	}

	public String getToto() {
		return "toto";
	}

	public Caillou getCaillou() {
		return new Caillou();
	}

	public static final class Caillou {

		private String nom;

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

	}

}
