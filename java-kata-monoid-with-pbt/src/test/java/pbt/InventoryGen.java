package pbt;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class InventoryGen extends Generator<Inventory> {

	public InventoryGen(Class<Inventory> type) {
		super(type);
	}

	public Inventory generate(SourceOfRandomness r, GenerationStatus status) {
		int n = r.nextInt(5);
		Inventory inventory = Inventory.NEUTRAL;
		for (int i = 0; i < n; i++) {
			final Stock stock = new Stock(r.nextInt());
			if (r.nextBoolean()) {
				inventory = inventory.combine(Inventory.stockItem1(stock));
			} else {
				inventory = inventory.combine(Inventory.stockItem2(stock));
			}
		}
		return inventory;
	}

}