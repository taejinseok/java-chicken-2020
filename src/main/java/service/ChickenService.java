package service;

import domain.MenuRepository;
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
}
