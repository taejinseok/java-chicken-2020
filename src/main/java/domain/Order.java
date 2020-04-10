package domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private static final int MIN_OVERFLOW_ORDER_COUNT = 100;
	private static final String OVERFLOW_MENU_COUNT_EXCEPTION_MESSAGE = "주문하고자 하는 메뉴의 최대치를 초과했어요.";
	private final Map<Menu, Integer> orderCounts;

	public Order() {
		this(new HashMap<>());
	}

	public Order(Map<Menu, Integer> orderCounts) {
		this.orderCounts = orderCounts;
	}

	public int countOfChicken() {
		return orderCounts.keySet().stream()
			.filter(Menu::isChicken)
			.mapToInt(orderCounts::get)
			.sum();
	}

	public void add(Menu menu, int count) {
		if (isOverFlowIfAdd(menu, count)) {
			throw new IllegalArgumentException(OVERFLOW_MENU_COUNT_EXCEPTION_MESSAGE);
		}
		orderCounts.put(menu, orderCounts.getOrDefault(menu, 0) + count);
	}

	public boolean isOverFlowIfAdd(Menu chicken, int additionalOrderNum) {
		return orderCounts.getOrDefault(chicken, 0) + additionalOrderNum >= MIN_OVERFLOW_ORDER_COUNT;
	}

	public boolean isEmpty() {
		return orderCounts.isEmpty();
	}

	public int calculateTotalPrice() {
		return orderCounts.keySet().stream()
			.mapToInt(menu -> menu.calculateTotalPrice(orderCounts.getOrDefault(menu, 0)))
			.sum();
	}
}
