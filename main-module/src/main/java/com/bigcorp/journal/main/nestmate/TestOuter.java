package com.bigcorp.journal.main.nestmate;

public class TestOuter {
	public void testingOuterPublic() {
	}

	private void testingOuterPrivate() {
	}

	class TestInner {
		public void testingInner() {
			testingOuterPrivate();
		}
	}
}