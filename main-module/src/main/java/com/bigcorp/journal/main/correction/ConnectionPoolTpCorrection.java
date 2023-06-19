package com.bigcorp.journal.main.correction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import com.bigcorp.journal.main.concurrent.HeavyResource;

/**
 * Une correction du TP : pool de connexions
 * 
 * La classe com.bigcorp.concurrent.HeavyResource existe dans le squelette du
 * projet. Elle représente une ressource sur laquelle on fait des opérations
 * longues. Pour chaque ressource, on peut appeler beginTransaction() et
 * endTransaction(). Appeler endTransaction() sur une ressource avant d’appeler
 * beginTransaction() (ou l’inverse) lance une exception. endTransaction() et
 * beginTransaction() mettent 100ms à s’exécuter chacune. La classe
 * ConnectionPoolTP contient une méthode main qui des appelle en série
 * heavyResourceA, B, ou C (aléatoirement). Mais avec ce fonctionnement, on perd
 * trop de temps à attendre que les HeavyResources répondent. Faire en sorte que
 * le main passe par une méthode qui gère en parallèle, et sans erreur l’accès
 * aux trois ressources.
 */
public class ConnectionPoolTpCorrection {

	private static final int NUMBER_OF_TRANSACTIONS_TO_PROCEED = 20;

	public static void main(String args[]) {
		HeavyResource heavyResourceA = new HeavyResource("A");
		HeavyResource heavyResourceB = new HeavyResource("B");
		HeavyResource heavyResourceC = new HeavyResource("C");

		runSequentially(heavyResourceA, heavyResourceB, heavyResourceC);
		runConcurrently(heavyResourceA, heavyResourceB, heavyResourceC);

	}

	private static void runConcurrently(HeavyResource heavyResourceA, HeavyResource heavyResourceB,
			HeavyResource heavyResourceC) {

		HeavyResourceRunnable heavyResourceRunnableA = new HeavyResourceRunnable(heavyResourceA);
		HeavyResourceRunnable heavyResourceRunnableB = new HeavyResourceRunnable(heavyResourceB);
		HeavyResourceRunnable heavyResourceRunnableC = new HeavyResourceRunnable(heavyResourceC);
		int doneTransactions = 0;
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		long startTimeMillis = System.currentTimeMillis();
		while (doneTransactions < NUMBER_OF_TRANSACTIONS_TO_PROCEED) {
			HeavyResourceRunnable heavyResourceToTreat = chooseARandomRunnable(heavyResourceRunnableA,
					heavyResourceRunnableB, heavyResourceRunnableC);
			threadPool.execute(heavyResourceToTreat);
			doneTransactions++;
		}
		try {
			threadPool.shutdown();
			threadPool.awaitTermination(40, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTimeMillis = System.currentTimeMillis();
		double transactionsPerSeconds = 1000f * NUMBER_OF_TRANSACTIONS_TO_PROCEED / (endTimeMillis - startTimeMillis);
		System.out.println(String.format("En parallèle, ai fait %1$.1f transactions par seconde", transactionsPerSeconds));
	}

	private static void runSequentially(HeavyResource heavyResourceA, HeavyResource heavyResourceB,
			HeavyResource heavyResourceC) {
		int doneTransactions = 0;
		long startTimeMillis = System.currentTimeMillis();
		while (doneTransactions < NUMBER_OF_TRANSACTIONS_TO_PROCEED) {
			HeavyResource heavyResourceToTreat = chooseARandomResource(heavyResourceA, heavyResourceB, heavyResourceC);
			heavyResourceToTreat.beginTransaction();
			heavyResourceToTreat.endTransaction();
			doneTransactions++;
		}
		long endTimeMillis = System.currentTimeMillis();
		double transactionsPerSeconds = 1000f * NUMBER_OF_TRANSACTIONS_TO_PROCEED / (endTimeMillis - startTimeMillis);
		System.out.println(String.format("En séquentiel, ai fait %1$.1f transactions par seconde", transactionsPerSeconds));

	}

	private static HeavyResource chooseARandomResource(HeavyResource heavyResourceA, HeavyResource heavyResourceB,
			HeavyResource heavyResourceC) {
		int resourceNumber = (int) (Math.random() * 3);
		switch (resourceNumber) {
		case 0:
			return heavyResourceA;
		case 1:
			return heavyResourceB;
		default:
			return heavyResourceC;
		}
	}

	private static HeavyResourceRunnable chooseARandomRunnable(HeavyResourceRunnable a, HeavyResourceRunnable b,
			HeavyResourceRunnable c) {
		int resourceNumber = (int) (Math.random() * 3);
		switch (resourceNumber) {
		case 0:
			return a;
		case 1:
			return b;
		default:
			return c;
		}
	}

	/**
	 * Gère un HeavyResource et lui adjoint un sémaphore pour
	 * s'assurer que HeavyResource n'est pas trop sollicité
	 */
	private static final class HeavyResourceRunnable implements Runnable {

		private HeavyResource heavyResource;
		private Semaphore internalSemaphore = new Semaphore(1);

		public HeavyResourceRunnable(HeavyResource heavyResource) {
			super();
			this.heavyResource = heavyResource;
		}

		@Override
		public void run() {
			try {
				this.internalSemaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.heavyResource.beginTransaction();
			this.heavyResource.endTransaction();

			this.internalSemaphore.release();
		}

	}

}
