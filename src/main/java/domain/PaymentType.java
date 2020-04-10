package domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum PaymentType {
	CASH(1),
	CREDIT(2);

	private static final String NONE_EXIST_PAYMENT_TYPE_MATCHING_ID = "해당 값에 대응하는 결제수단이 존재하지 않습니다.";

	private final int id;

	PaymentType(int id) {
		this.id = id;
	}

	public static PaymentType of(int id) {
		return Arrays.stream(values())
			.filter(paymentType -> paymentType.id == id)
			.findFirst()
			.orElseThrow(() -> new NoSuchElementException(NONE_EXIST_PAYMENT_TYPE_MATCHING_ID));
	}
}
