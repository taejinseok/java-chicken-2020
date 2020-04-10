package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class OrderTest {
	private Order order;

	@BeforeEach
	void setUp() {
		order = new Order(new HashMap<>());
	}

	@DisplayName("이 메뉴의 갯수가 99개 이하인가?")
	@Test
	void 해당_메뉴의_갯수가_99개_이하인가_테스트() {
	}

	@DisplayName("총 주문 금액을 가져오자")
	@Test
	void 총_주문_금액을_계산한다() {
	}

	@DisplayName("이 주문은 치킨이 몇개 있는가")
	@Test
	void 해당_주문안에_치킨의_갯수를_테스트한다() {
		order.add(new Menu(1, "치킨", Category.CHICKEN, 5000), 3);
		order.add(new Menu(2, "치킨2", Category.CHICKEN, 5000), 5);
		assertThat(order.countOfChicken()).isEqualTo(8);
	}

	@DisplayName("특정 주문을 추가한다.")
	@Test
	void 특정_주문을_추가한다() {
		assertThatCode(() -> order.add(new Menu(1, "치킨", Category.CHICKEN, 5000), 3))
			.doesNotThrowAnyException();
	}
}