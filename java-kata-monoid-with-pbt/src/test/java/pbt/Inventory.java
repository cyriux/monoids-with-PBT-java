package pbt;

public class Inventory {

	public static final Inventory NEUTRAL = new Inventory(Stock.NEUTRAL, Stock.NEUTRAL);

	private final Stock stockItem1;
	private final Stock stockItem2;

	static Inventory stockItem1(Stock stock) {
		return new Inventory(stock, Stock.NEUTRAL);
	}

	static Inventory stockItem2(Stock stock) {
		return new Inventory(Stock.NEUTRAL, stock);
	}

	public Inventory(Stock stockItem1, Stock stockItem2) {
		this.stockItem1 = stockItem1;
		this.stockItem2 = stockItem2;
	}

	public Inventory combine(Inventory other) {
		return new Inventory(stockItem1.combine(other.stockItem1), stockItem2.combine(other.stockItem2));
	}

	@Override
	public int hashCode() {
		return stockItem1.hashCode() ^ stockItem1.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		final Inventory other = (Inventory) obj;
		return stockItem1.equals(other.stockItem1) && stockItem2.equals(other.stockItem2);
	}

	@Override
	public String toString() {
		return "item1: " + stockItem1 + " item2: " + stockItem2;
	}
}