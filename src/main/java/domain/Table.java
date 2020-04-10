package domain;

public class Table {
	private final int number;
	private final Order order;

	public Table(final int number) {
		this(number, new Order());
	}

	public Table(final int number, final Order order) {
		this.number = number;
		this.order = order;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public void addOrder(Menu menu, int count) {
		order.add(menu, count);
	}

	public int calculateTotalPrice() {
		return order.calculateTotalPrice();
	}

	public int countOfChicken() {
		return order.countOfChicken();
	}

	public boolean hasNoOrder() {
		return order.isEmpty();
	}
}
