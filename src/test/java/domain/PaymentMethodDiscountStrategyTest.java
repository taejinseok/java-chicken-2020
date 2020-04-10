package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class PaymentMethodDiscountStrategyTest {

	@DisplayName("현금 결제시 5% 할인, 카드결제시 0% 할인한다.")
	@ParameterizedTest
	@CsvSource({"CASH,1000,950","CREDIT,1000,1000"})
	void findDiscountPriceTest(PaymentType paymentType, int currentPrice, int expected) {
		DiscountStrategy discountStrategy = new PaymentMethodDiscountStrategy(paymentType);
		int actual = discountStrategy.findDiscountPrice(currentPrice);
		assertThat(actual).isEqualTo(expected);
	}
}