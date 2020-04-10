package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class MenuTest {
	private Menu menu;

	@DisplayName("해당 메뉴가 치킨이면 참 반환하는지 테스트")
	@Test
	void 이_메뉴가_치킨인가() {
		menu = new Menu(1, "치킨", Category.CHICKEN, 5000);
		assertThat(menu.isChicken()).isTrue();
	}

	@DisplayName("해당 메뉴가 치킨이 아니면 거짓 반환하는지 테스트")
	@Test
	void 이_메뉴가_치킨인가_거짓() {
		menu = new Menu(1, "맥주", Category.BEVERAGE, 5000);
		assertThat(menu.isChicken()).isFalse();
	}
}