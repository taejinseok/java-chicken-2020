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

	public void addOrder() {

	}

	public int processPayment(int tableId) {
		Table table = tableRepository.findTable(tableId);
		return 1;
	}

	public List<Table> getTotalTables() {
		return TableRepository.tables();
	}

	public List<Menu> getTotalMenus() {
		return MenuRepository.menus();
	}
}
