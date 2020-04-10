package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class MenuRepositoryTest {
	private MenuRepository repository;

	@BeforeEach
	void setUp() {
		repository = new MenuRepository();
	}

	@DisplayName("존재하는 테이블 번호 입력시 테이블 인스턴스를 가져온다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 21, 22})
	void findTable(int id) {
		assertThat(repository.findMenu(id)).isInstanceOf(Menu.class);
	}

	@DisplayName("존재하지 않는 테이블 번호 입력시 예외발생한다.")
	@ParameterizedTest
	@ValueSource(ints = {0, -1, 77})
	void findTable_exception(int id) {
		assertThatThrownBy(() -> repository.findMenu(id)).isInstanceOf(NoSuchElementException.class);
	}
}