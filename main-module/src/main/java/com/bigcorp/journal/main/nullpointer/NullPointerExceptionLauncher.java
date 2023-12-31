package com.bigcorp.journal.main.nullpointer;

public class NullPointerExceptionLauncher {

	// Tenter de lancer la classe avec les paramètres :
	// -XX:-ShowCodeDetailsInExceptionMessages
	// puis avec -XX:+ShowCodeDetailsInExceptionMessages
	public static void main(String[] args) throws InterruptedException {

		NullPointerExceptionLauncher npel = new NullPointerExceptionLauncher();

		npel.callMethod1();

		System.out.println("Vous n'arriverez jamais ici !");

	}

	private void callMethod1() {
		callMethod2(null);
	}

	private void callMethod2(Object parametre) {
		String other = "coucou";
		System.out.println(parametre.toString() + other.toString());
	}

}
