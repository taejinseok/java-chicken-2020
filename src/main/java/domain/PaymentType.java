package domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum PaymentType {
	CREDIT(1, 0),
	CASH(2, 5);

	private static final String NONE_EXIST_PAYMENT_TYPE_MATCHING_ID = "해당 값에 대응하는 결제수단이 존재하지 않습니다.";
	private static final int PERCENTAGE = 100;

	private final int id;
	private final int discountRate;

	PaymentType(int id, int discountRate) {
		this.id = id;
		this.discountRate = discountRate;
	}

	public static PaymentType of(int id) {
		return Arrays.stream(values())
			.filter(paymentType -> paymentType.id == id)
			.findFirst()
			.orElseThrow(() -> new NoSuchElementException(NONE_EXIST_PAYMENT_TYPE_MATCHING_ID));
	}

	public int calculateDiscountedPrice(int originalPrice) {
		return originalPrice * (PERCENTAGE - discountRate) / PERCENTAGE;
	}

	public boolean isNotCash() {
		return CASH != this;
	}
}
