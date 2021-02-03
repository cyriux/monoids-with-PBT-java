package pbt;

public class Stats {
	
	public static final Stats NEUTRAL = new Stats(0, 0, 0);

	private final int sum;
	private final int count;
	private final int sum2;

	public Stats(int value) {
		this(value, 1, value * value);
	}

	protected Stats(int sum, int count, int sum2) {
		this.sum = sum;
		this.count = count;
		this.sum2 = sum2;
	}

	public Stats combine(Stats other) {
		return new Stats(sum + other.sum, count + other.count, sum2 + other.sum2);
	}

	@Override
	public int hashCode() {
		return 31 ^ (sum + count + sum2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		final Stats other = (Stats) obj;
		return count == other.count && sum == other.sum && sum2 == other.sum2;
	}

	@Override
	public String toString() {
		return "Sum: " + sum + ", count: " + count + ", sum^2: " + sum2;
	}

	public int average() {
		return sum / count;
	}

	public int std() {
		return (int) Math.sqrt((sum2 / count) - Math.pow(average(), 2));
	}
}