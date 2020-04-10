package domain;

import java.util.Map;

public class Order {
	private static final int MIN_OVERFLOW_ORDER_COUNT = 100;
	private final Map<Menu, Integer> orderCounts;

	public Order(Map<Menu, Integer> orderCounts) {
		this.orderCounts = orderCounts;
	}

	public int countOfChicken() {
		return orderCounts.keySet().stream()
			.filter(menu -> menu.isChicken())
			.mapToInt(orderCounts::get)
			.sum();
	}

	public void add(Menu menu, int count) {
		orderCounts.put(menu, orderCounts.getOrDefault(menu, 0) + count);
	}

	public boolean isOverFlowIfAdd(Menu chicken, int additionalOrderNum) {
		return orderCounts.getOrDefault(chicken, 0) + additionalOrderNum >= MIN_OVERFLOW_ORDER_COUNT;
	}

	public boolean isEmpty() {
		return orderCounts.isEmpty();
	}
}
