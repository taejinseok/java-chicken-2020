package domain;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class CompositeDiscountStrategyTest {
	private Table table;
	private Menu chicken;
	private Menu beverage;

	@BeforeEach
	void setUp() {
		table = new Table(1);
		chicken = new Menu(1, "치킨", Category.CHICKEN, 10_000);
		beverage = new Menu(2, "콜라", Category.BEVERAGE, 1_000);
	}

	@DisplayName("먼저 치킨 메뉴 10마리당 1만원 할인한다. 그후, 현금 결제시 5% 추가할인한다.")
	@ParameterizedTest
	@CsvSource({"CASH,522000,448400", "CREDIT,522000,472000"})
	void findDiscountPriceTest(PaymentType paymentType, int currentPrice, int expected) {
		table.addOrder(chicken, 52);
		table.addOrder(beverage, 2);
		DiscountStrategy discountStrategy = new CompositeDiscountStrategy(asList(
			new ChickenDiscountStrategy(table), new PaymentMethodDiscountStrategy(paymentType)
		));
		int actual = discountStrategy.findDiscountPrice(currentPrice);
		assertThat(actual).isEqualTo(expected);
	}
}