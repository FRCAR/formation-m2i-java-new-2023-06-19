package com.bigcorp.journal.main.correction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChildStream {

	public static void main(String[] args) {

		// Création d'une liste de Child
		List<Child> enfants = new ArrayList<>();
		enfants.add(new Child("Norbert", 6));
		enfants.add(new Child("Jean-Michmich", 7));
		enfants.add(new Child("Arthur", 4));
		enfants.add(new Child("Benoit", 3));
		enfants.add(new Child("Charles", 12));
		enfants.add(new Child("Didier", 11));
		enfants.add(new Child("Éléonore", 4));
		enfants.add(new Child("Fanny", 7));
		enfants.add(new Child("Gabriel", 8));
		enfants.add(new Child("Hamid", 5));
		enfants.add(new Child("Isabelle", 7));
		enfants.add(new Child("Jojo", 6));
		enfants.add(new Child("Kadidja", 10));

		// Afficher le nom de chaque enfant avec un stream.
		System.out.println("\r\nLe nom de chaque enfant");
		enfants.stream().forEach(c -> System.out.println(c.getNom()));

		//Afficher la moyenne d’âge des enfants.
		System.out.println("\r\nMoyenne d'âge des enfants");
		double ageMoyen = enfants.stream().mapToInt(c -> c.getAge()).average().orElse(0);
		System.out.println(ageMoyen);
		
		//Les deux lignes ci-dessous équivalent à :
		enfants.stream().mapToInt(c -> c.getAge()).average().ifPresent(System.out::println);

		//Afficher si au moins un enfant a dépassé un âge.
		int minAge = 7;
		System.out.println("\r\nAu moins un enfant a dépassé : " + minAge + " ans");
		boolean auMoinsUnEnfantADepasseLAge = enfants.stream().anyMatch(c -> c.getAge()> minAge);
		System.out.println(auMoinsUnEnfantADepasseLAge);
		

		//Utiliser les streams pour afficher le nom de l’enfant ayant le plus grand âge.
		System.out.println("\r\nEnfant ayant le plus grand age");
		Child enfantLePlusVieux = enfants.stream().max((c1,c2) -> c1.getAge() - c2.getAge()).orElse(null);
		System.out.println(enfantLePlusVieux.getNom() + " a " + enfantLePlusVieux.getAge() + " ans");
		
		//Pareil pour le plus petit age. 
		System.out.println("\r\nEnfant ayant le plus petit age");
		Child enfantLePlusJeune = enfants.stream().min((c1,c2) -> c1.getAge() - c2.getAge()).orElse(null);
		System.out.println(enfantLePlusJeune.getNom() + " a " + enfantLePlusJeune.getAge() + " ans");
		
	}

}
