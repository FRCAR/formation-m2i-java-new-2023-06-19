package com.bigcorp.journal.main.lambda;

@FunctionalInterface
public interface Traitement {
	
	void traite(Matiere m);

}
