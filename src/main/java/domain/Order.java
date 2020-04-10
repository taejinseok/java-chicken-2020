package domain;

import java.util.Map;

public class Order {
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
}
