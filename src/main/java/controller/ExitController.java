package controller;

import view.OutputView;

public class ExitController implements ChickenController {
	public void run() {
		OutputView.printExit();
		System.exit(0);
	}
}
