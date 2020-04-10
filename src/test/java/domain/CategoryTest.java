package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class CategoryTest {

	@DisplayName("해당 카테고리가 치킨인가 테스트")
	@ParameterizedTest
	@CsvSource({"CHICKEN,true", "BEVERAGE,false"})
	void isChicken(Category category, boolean expected) {
		assertThat(category.isChicken()).isEqualTo(expected);
	}

	@DisplayName("문자열로 올바르게 가져오나 테스트")
	@ParameterizedTest
	@CsvSource({"CHICKEN,[치킨]", "BEVERAGE,[음료]"})
	void toStringTest(Category category, String expected) {
		assertThat(category.toString()).isEqualTo(expected);
	}
}