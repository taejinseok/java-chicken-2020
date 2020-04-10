package controller;

import java.util.HashMap;
import java.util.Map;

import view.InputView;

public class MainController implements ChickenController {
	private static final Map<Integer, ChickenController> DISPATCHER_ON_COMMAND;

	static {
		DISPATCHER_ON_COMMAND = new HashMap<>();
		DISPATCHER_ON_COMMAND.put(1, new OrderController());
		DISPATCHER_ON_COMMAND.put(2, new PaymentController());
		DISPATCHER_ON_COMMAND.put(3, new ExitController());
	}

	public void run() {
		while (true) {
			DISPATCHER_ON_COMMAND.get(InputView.inputCommand()).run();
		}
	}
}
