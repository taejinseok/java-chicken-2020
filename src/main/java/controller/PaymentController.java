package controller;

import domain.MenuRepository;
import domain.PaymentType;
import domain.Table;
import domain.TableRepository;
import service.ChickenService;
import view.InputView;
import view.OutputView;

public class PaymentController implements ChickenController {
	private final ChickenService chickenService;

	public PaymentController() {
		this(new ChickenService(new MenuRepository(), new TableRepository()));
	}

	public PaymentController(ChickenService chickenService) {
		this.chickenService = chickenService;
	}

	public void run() {
		OutputView.printTables(chickenService.getTotalTables());
		Table table = chickenService.getOrderedTable(InputView.inputTableNumber());
		OutputView.printOrderStatus(table.getOrder());
		OutputView.printPaymentIntro(table);
		int paymentPrice = chickenService.payChickenPrice(table, PaymentType.of(InputView.inputPaymentType()));
		OutputView.printPaymentPrice(paymentPrice);
	}
}
