package controller;

import java.util.HashMap;
import java.util.Map;

import view.InputView;
import view.OutputView;

public class MainController implements ChickenController {
	private static final Map<Integer, ChickenController> DISPATCHER_ON_COMMAND;
	private static final String ILLEGAL_POS_FUNCTION_ID_EXCEPTION_MESSAGE = "올바른 입력값이 아닙니다.";

	static {
		DISPATCHER_ON_COMMAND = new HashMap<>();
		DISPATCHER_ON_COMMAND.put(1, new OrderController());
		DISPATCHER_ON_COMMAND.put(2, new PaymentController());
		DISPATCHER_ON_COMMAND.put(3, new ExitController());
	}

	public void run() {
		while (true) {
			doCommandAction();
		}
	}

	private void doCommandAction() {
		try {
			ChickenController mappingController = findMappingController(InputView.inputCommand());
			mappingController.run();
		} catch (RuntimeException e) {
			OutputView.printExceptionMessage(e.getMessage());
			doCommandAction();
		}
	}

	private ChickenController findMappingController(int commandId) {
		if (!DISPATCHER_ON_COMMAND.containsKey(commandId)) {
			throw new IllegalArgumentException(ILLEGAL_POS_FUNCTION_ID_EXCEPTION_MESSAGE);
		}
		return DISPATCHER_ON_COMMAND.get(commandId);
	}
}
