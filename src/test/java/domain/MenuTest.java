package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class MenuTest {
	private Menu chicken;
	private Menu beer;

	@BeforeEach
	void setUp() {
		chicken = new Menu(1, "치킨", Category.CHICKEN, 5_000);
		beer = new Menu(1, "맥주", Category.BEVERAGE, 5_000);
	}

	@DisplayName("해당 메뉴가 치킨이면 참 반환하는지 테스트")
	@Test
	void 이_메뉴가_치킨인가() {
		assertThat(chicken.isChicken()).isTrue();
	}

	@DisplayName("해당 메뉴가 치킨이 아니면 거짓 반환하는지 테스트")
	@Test
	void 이_메뉴가_치킨인가_거짓() {
		assertThat(beer.isChicken()).isFalse();
	}

	@DisplayName("갯수를 입력받으면 해당 메뉴의 가격*갯수를 반환한다.")
	@Test
	void 해당_메뉴의_갯수와_가격의_곱을_계산한다() {
		assertThat(chicken.calculateTotalPrice(5)).isEqualTo(25_000);
	}
}