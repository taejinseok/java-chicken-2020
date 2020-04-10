package controller;

import domain.MenuRepository;
import domain.TableRepository;
import service.ChickenService;

public class PaymentController implements ChickenController {
	private final ChickenService chickenService;

	public PaymentController() {
		this(new ChickenService(new MenuRepository(), new TableRepository()));
	}

	public PaymentController(ChickenService chickenService) {
		this.chickenService = chickenService;
	}

	public void run() {

	}
}
