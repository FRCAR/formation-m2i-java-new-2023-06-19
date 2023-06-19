package com.bigcorp.journal.main.lambda.cours;

public class CloseButton implements Button{

	@Override
	public Integer click(int a) {
		System.out.println("Fenêtre fermée");
		return 0;
	}

}
