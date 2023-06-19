package com.bigcorp.journal.main.lambda.cours;

public class Window {

	private Button button;

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	// on clique sur la fenêtre
	public void clickOnWindow() {
		// ...
		button.click(0);
	}

}
