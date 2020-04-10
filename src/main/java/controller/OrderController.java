package controller;

import domain.MenuRepository;
import domain.TableRepository;
import service.ChickenService;
import view.InputView;
import view.OutputView;

public class OrderController implements ChickenController {
	private final ChickenService chickenService;

	public OrderController() {
		this(new ChickenService(new MenuRepository(), new TableRepository()));
	}

	public OrderController(ChickenService chickenService) {
		this.chickenService = chickenService;
	}

	public void run() {
		OutputView.printTables(chickenService.getTotalTables());
		final int tableNumber = InputView.inputTableNumber();
		OutputView.printMenus(chickenService.getTotalMenus());
	}
}
