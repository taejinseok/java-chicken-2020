package service;

import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

public class ChickenService {
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

	public Menu getMenu(int menuId) {
		return menuRepository.findMenu(menuId);
	}
}
