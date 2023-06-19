package com.bigcorp.journal.main.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionToStream {

	public static void main(String[] args) {
		
		//Création d'une liste
		List<Integer> intList = new ArrayList<>();
		intList.add(6);
		intList.add(4);
		intList.add(5);
		
		//Transformation en stream pour filtre et affichage
		intList.stream()
			.filter((Integer e) -> {return e > 4;})
			.forEach((Integer e) -> {System.out.println(e);});
		
		//Transformation en stream pour filtre et affichage
		//avec une syntaxe de lambdas plus concises 
		intList.stream()
			.filter(e -> e > 4)
			.forEach(System.out::println);
		
		//Re transformation d'un stream en Collection via collect
		List<Integer> filteredList = intList.stream().filter(e -> e > 4).collect(Collectors.toList());
		System.out.println("Affichage de la liste filtrée");
		for (Integer i : filteredList) {
			System.out.println(i);
		}
		
		//Transformation en intstream pour faire des fonctions mathématiques
		System.out.println("La somme des éléments de la map vaut : " + 
				intList.stream().mapToInt(Integer::intValue).sum());
		
	}

}
