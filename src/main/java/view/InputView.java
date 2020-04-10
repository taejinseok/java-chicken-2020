package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String NOT_INTEGER_INPUT_VALUE_EXCEPTION = "숫자 값을 입력해주세요";

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return parseInt(SCANNER.nextLine());
	}

	public static int inputCommand() {
		System.out.println("## 메인화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램종료");
		System.out.println();
		System.out.println("## 원하는 기능을 선택하세요.");
		return parseInt(SCANNER.nextLine());
	}

	private static int parseInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(NOT_INTEGER_INPUT_VALUE_EXCEPTION);
		}
	}
}
