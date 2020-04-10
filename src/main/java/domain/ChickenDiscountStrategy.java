package domain;

public class ChickenDiscountStrategy implements DiscountStrategy {
	private static final int CHICKEN_DISCOUNT_COUNT_PER = 10;
	private static final int UNIT_DISCOUNT_PRICE = 10_000;

	private final Table table;

	public ChickenDiscountStrategy(Table table) {
		this.table = table;
	}

	@Override
	public int findDiscountPrice(int currentPrice) {
		return currentPrice - (table.countOfChicken() / CHICKEN_DISCOUNT_COUNT_PER * UNIT_DISCOUNT_PRICE);
	}
}
