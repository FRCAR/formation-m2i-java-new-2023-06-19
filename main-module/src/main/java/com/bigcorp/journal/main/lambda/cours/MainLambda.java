package com.bigcorp.journal.main.lambda.cours;

public class MainLambda {
	
	public static void main(String[] args) {
		Window window = new Window();
		window.setButton(new CloseButton());
		
		
		//...
		
		window.clickOnWindow();
		
		window.setButton(new OpenHelpButton());
		window.clickOnWindow();
		
		window.setButton(new Button() {
			@Override
			public Integer click(int a) {
				System.out.println("Ici, on clique sur un bouton déclaré inline");
				return 3;
			}
		});
		window.clickOnWindow();
		
		final int d = 12;
		
		int e = 12;
		
		Button lambdaButton = a -> {
			int c = 3;
			return c *a + d + e;
		};
		window.setButton(lambdaButton);
		window.clickOnWindow();
		
		
	}

}
