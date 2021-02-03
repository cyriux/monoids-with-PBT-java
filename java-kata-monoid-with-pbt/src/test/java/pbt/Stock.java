package pbt;

public class Stock {

	public static final Stock NEUTRAL = new Stock(Integer.MAX_VALUE, Stats.NEUTRAL);

	private final int minQuantity;
	private final Stats stats;

	public Stock(int quantity) {
		this(quantity, new Stats(quantity));
	}

	protected Stock(int min, Stats stats) {
		this.minQuantity = min;
		this.stats = stats;
	}

	public Stock combine(Stock other) {
		return new Stock(Math.min(minQuantity, other.minQuantity), stats.combine(other.stats));
	}

	@Override
	public int hashCode() {
		return stats.hashCode() ^ minQuantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		final Stock other = (Stock) obj;
		return minQuantity == other.minQuantity && stats.equals(other.stats);
	}

	@Override
	public String toString() {
		return stats.toString() + " (min: " + minQuantity + ")";
	}
}