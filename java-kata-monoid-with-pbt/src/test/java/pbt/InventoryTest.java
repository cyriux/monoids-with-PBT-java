package pbt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class InventoryTest {

	@Test
	public void combinedInventories() {
		assertEquals(new Inventory(new Stock(20), new Stock(10)),
				Inventory.stockItem1(new Stock(20)).combine(Inventory.stockItem2(new Stock(10))));
	}

	@Property
	public void closureOfOperation(@From(InventoryGen.class) Inventory a, @From(InventoryGen.class) Inventory b) {
		assertTrue(a.combine(b) instanceof Inventory);
	}

	@Property
	public void neutralElement(@From(InventoryGen.class) Inventory a) {
		assertEquals(a, a.combine(Inventory.NEUTRAL));
		assertEquals(a, Inventory.NEUTRAL.combine(a));
	}

	@Property
	public void associativity(@From(InventoryGen.class) Inventory a, @From(InventoryGen.class) Inventory b,
			@From(InventoryGen.class) Inventory c) {
		assertEquals(a.combine(b).combine(c), a.combine(b.combine(c)));

	}

}
