package org.empathy.soulsplit.smithing;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.soulsplit.api.methods.Bank;
import org.soulsplit.api.methods.Game;
import org.soulsplit.api.methods.Inventory;
import org.soulsplit.api.methods.Menu;
import org.soulsplit.api.methods.Players;
import org.soulsplit.api.wrappers.Tile;

/**
 * A class that smiths stuff.
 * @author Empathy
 * 
 */
public class Banking implements Strategy {
	
	@Override
	public boolean activate() {
		return Inventory.getCount(Smith.barId) < Smith.smith.getBarAmount();

	}

	@Override
	public void execute() {
		System.out.println("Banking...");
		if (!Players.getMyPlayer().getLocation().equals(new Tile(3189, 3435))) {
			new Tile(3189, 3435).walkTo();
			Time.sleep(new SleepCondition() {

				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation().equals(new Tile(3189, 3435));
				}
			}, 10000);
		}
		
		if (Players.getMyPlayer().getLocation().equals(new Tile(3189, 3435)) && Game.getOpenInterfaceId() != 5292) {
			
			Menu.sendAction(900, 1260559798, 11402, -1);
			
			Time.sleep(new SleepCondition() {

				@Override
				public boolean isValid() {
					return Game.getOpenInterfaceId() == 5292;
				}
			}, 5000);
			
		}
		
		if (Game.getOpenInterfaceId() == 5292) {
			
			if (!Inventory.isEmpty()) {
				Menu.sendAction(646, -1, -1, 5386);
				
				Time.sleep(new SleepCondition() {

					@Override
					public boolean isValid() {
						return Inventory.isEmpty();
					}
				}, 5000);
				
			}
			
			if (Inventory.isEmpty()) {
				
				Bank.withdraw(2348, 1, 100);
				
				Time.sleep(new SleepCondition() {

					@Override
					public boolean isValid() {
						return Inventory.getCount(2348) > 0;
					}
				}, 5000);
				
				Bank.withdraw(Smith.barId, 27, 100);
				
				Time.sleep(new SleepCondition() {

					@Override
					public boolean isValid() {
						return Inventory.getCount(Smith.barId) > 0;
					}
				}, 5000);
				
			}
		}
	}
}
