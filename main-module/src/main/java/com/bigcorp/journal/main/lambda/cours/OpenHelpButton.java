package com.bigcorp.journal.main.lambda.cours;

public class OpenHelpButton implements Button {

	@Override
	public Integer click(int a) {
		System.out.println("J'ouvre l'aide");
		return 1;
	}

}
