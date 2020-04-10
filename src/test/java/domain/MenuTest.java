package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class MenuTest {
	private Menu chicken;
	private Menu beer;

	@BeforeEach
	void setUp() {
		chicken = new Menu(1, "치킨", Category.CHICKEN, 5_000);
		beer = new Menu(2, "맥주", Category.BEVERAGE, 5_000);
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

	@DisplayName("메뉴 인스턴스가 입력 받은 id와 같은 id 라면 참 반환")
	@ParameterizedTest
	@CsvSource({"1,true", "2,false"})
	void 테이블_인스턴스의_아이디가_입력받은_아이디와_같은지_테스트(int inputId, boolean expected) {
		boolean actual = chicken.isSameNumber(inputId);
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("toStringTest")
	@Test
	void toStringTest() {
		assertThat(chicken.toString())
			.isEqualTo("[치킨] 1 - 치킨 : 5000원");
	}

	@DisplayName("getNameTest")
	@Test
	void getNameTest() {
		assertThat(chicken.getName())
			.isEqualTo("치킨");
	}
}