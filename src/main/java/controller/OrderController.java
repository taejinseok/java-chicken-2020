package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
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
		Table table = chickenService.getTable(InputView.inputTableNumber());
		OutputView.printMenus(chickenService.getTotalMenus());
		Menu menu = chickenService.getMenu(InputView.inputMenuNumber());
		int count = InputView.inputCountOrder();
		chickenService.addOrder(table, menu, count);
	}
}
