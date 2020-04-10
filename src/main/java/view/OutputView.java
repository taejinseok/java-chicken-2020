package view;

import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.Menu;
import domain.Order;
import domain.Table;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String UNORDERED_BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDERED_BOTTOM_LINE = "└ ₩ ┘";

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		printTopLine(tables);
		printTableNumbers(tables);
		printBottomLine(tables);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printTopLine(final List<Table> tables) {
		for (Table table : tables) {
			System.out.print(TOP_LINE);
		}
		System.out.println();
	}

	private static void printBottomLine(final List<Table> tables) {
		for (Table table : tables) {
			System.out.print(getBottomLine(table));
		}
		System.out.println();
	}

	private static String getBottomLine(Table table) {
		if (table.hasNoOrder()) {
			return UNORDERED_BOTTOM_LINE;
		}
		return ORDERED_BOTTOM_LINE;
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printExit() {
		System.out.println("포스기를 종료합니다.");
	}

	public static void printExceptionMessage(String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

	public static void printOrderStatus(Order order) {
		System.out.println("## 주문 내역");
		System.out.println("메뉴 수량 금액");
		Map<Menu, Integer> orderCounts = order.getOrderCounts();
		Set<Menu> menus = orderCounts.keySet();
		for (Menu menu : menus) {
			int orderCount = orderCounts.get(menu);
			System.out.printf("%s %d %d\n", menu.getName(), orderCount, menu.calculateTotalPrice(orderCount));
		}
	}

	public static void printPaymentIntro(Table table) {
		System.out.printf("## %s번 테이블의 결제를 진행합니다\n", table);
	}

	public static void printPaymentPrice(int price) {
		System.out.println("## 최종 결제할 금액");
		System.out.printf("%d 원\n\n", price);
	}
}
