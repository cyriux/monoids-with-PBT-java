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
public class StatsTest {

	@Test
	public void theTotalStatsIsTheSumOfEachStats() {
		assertEquals(new Stats(30, 2, 500), new Stats(10).combine(new Stats(20)));
	}

	@Test
	public void testAverage() {
		assertEquals(15, new Stats(10).combine(new Stats(20)).average());
	}

	@Test
	public void testStd() {
		assertEquals(5, new Stats(10).combine(new Stats(20)).std());
	}

	@Property
	public void closureOfOperation(@From(Ctor.class) Stats a, @From(Ctor.class) Stats b) {
		assertTrue(a.combine(b) instanceof Stats);
	}

	@Property
	public void neutralElement(@From(Ctor.class) Stats a) {
		assertEquals(a, a.combine(Stats.NEUTRAL));
		assertEquals(a, Stats.NEUTRAL.combine(a));
	}

	@Property
	public void associativity(@From(Ctor.class) Stats a, @From(Ctor.class) Stats b, @From(Ctor.class) Stats c) {
		System.out.println(a + " " + b + " " + c);
		assertEquals(a.combine(b).combine(c), a.combine(b.combine(c)));
	}

}
