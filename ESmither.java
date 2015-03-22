package org.empathy.soulsplit.smithing;

import java.util.Arrays;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;

@ScriptManifest(author = "Empathy", category = Category.SMITHING, description = "Smiths stuff on soulsplit", name = "ESmither", servers = { "Soulsplit" }, version = 1.0)
public class ESmither extends Script {


	@Override
	public boolean onExecute() {
		Gui GUI = new Gui();
		GUI.setVisible(true);
		while (GUI.isVisible()) {
			sleep(1000);
		}
		provide(Arrays.asList(new Banking(), new Smith()));
		return true;
	}
}