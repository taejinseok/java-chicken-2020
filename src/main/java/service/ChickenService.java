package service;

import static java.util.Arrays.*;

import java.util.List;

import domain.ChickenDiscountStrategy;
import domain.CompositeDiscountStrategy;
import domain.DiscountStrategy;
import domain.Menu;
import domain.MenuRepository;
import domain.PaymentMethodDiscountStrategy;
import domain.PaymentType;
import domain.Table;
import domain.TableRepository;

public class ChickenService {
	private static final String NOT_ABLE_TO_PAYMENT_WITHOUT_ORDER_EXCEPTION_MESSAGE = "주문이 없는 테이블은 결제 할수 없습니다.";
	private final MenuRepository menuRepository;
	private final TableRepository tableRepository;

	public ChickenService(MenuRepository menuRepository, TableRepository tableRepository) {
		this.menuRepository = menuRepository;
		this.tableRepository = tableRepository;
	}

	public void addOrder(Table table, Menu menu, int count) {
		table.addOrder(menu, count);
		System.out.println("주문 완료!");
	}

	public List<Table> getTotalTables() {
		return TableRepository.tables();
	}

	public List<Menu> getTotalMenus() {
		return MenuRepository.menus();
	}

	public Table getTable(int tableId) {
		return tableRepository.findTable(tableId);
	}

	public Table getOrderedTable(int tableId) {
		Table table = tableRepository.findTable(tableId);
		if (table.hasNoOrder()) {
			throw new IllegalArgumentException(NOT_ABLE_TO_PAYMENT_WITHOUT_ORDER_EXCEPTION_MESSAGE);
		}
		return table;
	}

	public Menu getMenu(int menuId) {
		return menuRepository.findMenu(menuId);
	}

	public int payChickenPrice(Table table, PaymentType paymentType) {
		int discountPrice = findDiscountPrice(table, paymentType);
		table.cleanAllOrder();
		return discountPrice;
	}

	private int findDiscountPrice(Table table, PaymentType paymentType) {
		DiscountStrategy discountStrategy = new CompositeDiscountStrategy(asList(
			new ChickenDiscountStrategy(table), new PaymentMethodDiscountStrategy(paymentType)
		));
		return discountStrategy.findDiscountPrice(table.calculateTotalPrice());
	}
}
