package org.empathy.soulsplit.smithing;


public enum SmithingData {
// Knives, arrow heads, daggers, plates, legs and scimmys
	
	KNIFES(866, 867, 868, 2, 1123, 1),
	
	ARROWS(42, 43, 44, 1, 1123, 1),
	
	DAGGERS(1209, 1211, 1213, 0, 1119, 1),
	
	SCIM(1329, 1331, 1333, 2, 1119, 2),
	
	LEGS(1071, 1073, 1079, 1, 1121, 3),
	
	PLATES(1121, 1123, 1127, 3, 1121, 5);


	private int mithAction;
	private int adamantAction;
	private int runeAction;
	private int action2;
	private int action3;
	private int barAmount;

	SmithingData(int mithAction, int adamantAction, int runeAction, int action2, int action3, int barAmount) {
		this.mithAction = mithAction;
		this.adamantAction = adamantAction;
		this.runeAction = runeAction;
		this.action2 = action2;
		this.action3 = action3;
		this.barAmount = barAmount;
	}	

	public int getMithAction() {
		return mithAction;
	}

	public int getAdamantAction() {
		return adamantAction;
	}

	public int getRuneAction() {
		return runeAction;
	}
	
	public int getAction2() {
		return action2;
	}
	
	public int getAction3() {
		return action3;
	}
	
	public int getBarAmount() {
		return barAmount;
	}
	
}