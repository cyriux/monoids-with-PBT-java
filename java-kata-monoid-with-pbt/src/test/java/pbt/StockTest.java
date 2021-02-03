package pbt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class StockTest {

	@Test
	public void theTotalStockIsTheSumOfEachStocks() {
		assertEquals(new Stock(10, new Stats(30, 2, 500)), new Stock(10).combine(new Stock(20)));
	}

	@Property
	public void closureOfOperation(@From(Ctor.class) Stock a, @From(Ctor.class) Stock b) {
		assertTrue(a.combine(b) instanceof Stock);
	}

	@Property
	public void neutralElement(@From(Ctor.class) Stock a) {
		assertEquals(a, a.combine(Stock.NEUTRAL));
		assertEquals(a, Stock.NEUTRAL.combine(a));
	}

	@Property
	public void associativity(@From(Ctor.class) Stock a, @From(Ctor.class) Stock b, @From(Ctor.class) Stock c) {
		System.out.println(a + " " + b + " " + c);
		assertEquals(a.combine(b).combine(c), a.combine(b.combine(c)));

	}

}
