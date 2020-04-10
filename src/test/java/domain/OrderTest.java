package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class OrderTest {
	private Order order;
	private Menu chicken;
	private Menu beverage;

	@BeforeEach
	void setUp() {
		order = new Order(new HashMap<>());
		chicken = new Menu(1, "치킨", Category.CHICKEN, 5_000);
		beverage = new Menu(2, "맥주", Category.BEVERAGE, 5_000);
	}

	@DisplayName("추가 하고자 하는 메뉴의 수량과 기존의 수량을 합치면 99개보다 큰가?")
	@ParameterizedTest
	@CsvSource({"4,false", "5,true"})
	void 해당_갯수만큼_메뉴를_추가하면_메뉴의_갯수가_100개_이상인_테스트(int additionalOrderNum, boolean expected) {
		order.add(chicken, 95);
		assertThat(order.isOverFlowIfAdd(chicken, additionalOrderNum)).isEqualTo(expected);
	}

	@DisplayName("주문을 이루고 있는 메뉴 * 갯수 의 총 합을 올바르게 계산해야 한다.")
	@Test
	void 총_주문_금액을_계산한다() {
		int expected = 50_000;
		order.add(beverage, 10);
		int actual = order.calculateTotalPrice();

		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("이 주문은 치킨이 몇개 있는가")
	@Test
	void 해당_주문안에_치킨의_갯수를_테스트한다() {
		order.add(chicken, 3);
		order.add(chicken, 5);
		assertThat(order.countOfChicken()).isEqualTo(8);
	}

	@DisplayName("특정 주문을 추가한다.")
	@Test
	void 특정_주문을_추가한다() {
		assertThatCode(() -> order.add(chicken, 3))
			.doesNotThrowAnyException();
	}

	@DisplayName("현재 주문내역이 비어있으면 true 반환")
	@Test
	void 현재_주문이_비어있는가_테스트() {
		assertThat(order.isEmpty()).isTrue();
	}

	@DisplayName("현재 주문내역이 비어있지 않으면 false 반환")
	@Test
	void 현재_주문이_비어있는가_테스트2() {
		order.add(beverage, 50);
		assertThat(order.isEmpty()).isFalse();
	}
}