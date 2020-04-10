package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class TableTest {
	private Table table;
	private Menu chicken;
	private Menu beverage;

	@BeforeEach
	void setUp() {
		table = new Table(1);
		chicken = new Menu(1, "치킨", Category.CHICKEN, 5_000);
		beverage = new Menu(2, "맥주", Category.BEVERAGE, 5_000);
	}

	@DisplayName("추가 하고자 하는 메뉴의 수량과 기존의 수량을 합치면 99개 이하인가?")
	@Test
	void 해당_갯수만큼_메뉴를_추가하면_메뉴의_갯수가_100개_이하이기_때문에_정상적으로_메뉴추가_테스트() {
		table.addOrder(chicken, 95);
		assertThatCode(() -> table.addOrder(chicken, 4)).doesNotThrowAnyException();
	}

	@DisplayName("추가 하고자 하는 메뉴의 수량과 기존의 수량을 합치면 99개보다 큰가?")
	@Test
	void 해당_갯수만큼_메뉴를_추가하면_메뉴의_갯수가_100개_이상이기_때문에_예외_발생_테스트() {
		table.addOrder(chicken, 95);
		assertThatCode(() -> table.addOrder(chicken, 5)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("주문을 이루고 있는 메뉴 * 갯수 의 총 합을 올바르게 계산해야 한다.")
	@Test
	void 총_주문_금액을_계산한다() {
		int expected = 50_000;
		table.addOrder(beverage, 10);
		int actual = table.calculateTotalPrice();

		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("이 주문은 치킨이 몇개 있는가")
	@Test
	void 해당_주문안에_치킨의_갯수를_테스트한다() {
		table.addOrder(chicken, 3);
		table.addOrder(chicken, 5);
		assertThat(table.countOfChicken()).isEqualTo(8);
	}

	@DisplayName("현재 주문내역이 비어있으면 true 반환")
	@Test
	void 현재_주문이_비어있는가_테스트() {
		assertThat(table.hasNoOrder()).isTrue();
	}

	@DisplayName("현재 주문내역이 비어있지 않으면 false 반환")
	@Test
	void 현재_주문이_비어있는가_테스트2() {
		table.addOrder(beverage, 50);
		assertThat(table.hasNoOrder()).isFalse();
	}
}