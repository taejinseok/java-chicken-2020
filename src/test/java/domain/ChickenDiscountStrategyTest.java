package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class ChickenDiscountStrategyTest {
	private Table table;
	private Menu chicken;
	private Menu beverage;

	@BeforeEach
	void setUp() {
		table = new Table(1);
		chicken = new Menu(1, "치킨", Category.CHICKEN, 10_000);
		beverage = new Menu(2, "콜라", Category.BEVERAGE, 1_000);
	}

	@DisplayName("10개 단위의 치킨주문시, 1만원씩 추가 할인 되는지 확인한다.")
	@ParameterizedTest
	@CsvSource({"52,472000","12,112000","7,72000","17,162000"})
	void findDiscountPrice(int totalChickenCount, int expected) {
		table.addOrder(chicken, totalChickenCount);
		table.addOrder(beverage, 2);
		DiscountStrategy discountStrategy = new ChickenDiscountStrategy(table);
		int actual = discountStrategy.findDiscountPrice(table.calculateTotalPrice());
		assertThat(actual).isEqualTo(expected);
	}
}