package org.empathy.soulsplit.smithing;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.soulsplit.api.methods.Game;
import org.soulsplit.api.methods.Inventory;
import org.soulsplit.api.methods.Menu;
import org.soulsplit.api.methods.Players;
import org.soulsplit.api.wrappers.Item;
import org.soulsplit.api.wrappers.Tile;

/**
 * A class that smiths stuff.
 * @author Empathy
 * 
 */
public class Smith implements Strategy {

	public static int barId;

	public static SmithingData smith;

	@Override
	public boolean activate() {
		return Inventory.getCount(barId) > smith.getBarAmount();

	}

	@Override
	public void execute() {
		
		System.out.println("Smithing");
		
		Item[] bar = Inventory.getItems(barId);
		
		if (!Players.getMyPlayer().getLocation().equals(new Tile(3187, 3426))) {
			new Tile(3187, 3426).walkTo();
			Time.sleep(new SleepCondition() {

				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation().equals(new Tile(3187, 3426));
				}
			}, 10000);
		}
		
		if (bar.length > 0 && bar != null && Game.getOpenInterfaceId() != 994 && Players.getMyPlayer().getLocation().equals(new Tile(3187, 3426))) {
			Menu.sendAction(447, barId - 1, bar[0].getSlot(), 3214);
			Time.sleep(500);
			Menu.sendAction(62, 1119344948, 2783, -1);

			Time.sleep(new SleepCondition() {

				@Override
				public boolean isValid() {
					return Game.getOpenInterfaceId() == 994;
				}
			}, 5000);
		}

		if (Game.getOpenInterfaceId() == 994) {

			if (barId == 2360) {
				Menu.sendAction(867, smith.getMithAction(), smith.getAction2(), smith.getAction3());
			}

			if (barId == 2362) {
				Menu.sendAction(867, smith.getAdamantAction(), smith.getAction2(), smith.getAction3());

			}

			if (barId == 2364) {
				Menu.sendAction(867, smith.getRuneAction(), smith.getAction2(), smith.getAction3());

			}

			Time.sleep(new SleepCondition() {

				@Override
				public boolean isValid() {
					return Inventory.getCount(barId) == 0;
				}
			}, 7200);
		}
	}
}
