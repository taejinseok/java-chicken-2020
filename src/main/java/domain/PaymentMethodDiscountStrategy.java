package domain;

public class PaymentMethodDiscountStrategy implements DiscountStrategy {
	private final PaymentType paymentType;

	public PaymentMethodDiscountStrategy(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public int findDiscountPrice(int currentPrice) {
		return paymentType.calculateDiscountedPrice(currentPrice);
	}
}
