package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class PaymentTypeTest {

	@DisplayName("입력값에 따른 결제수단 객체를 가져오는지 테스트")
	@ParameterizedTest
	@CsvSource({"1,CASH", "2,CREDIT"})
	void 입력_id_에_따른_결제수단_결정하는_테스트(int id, PaymentType paymentType) {
		assertThat(PaymentType.of(id)).isEqualTo(paymentType);
	}

	@DisplayName("1, 2 가 아닌 입력값 이면, NoSuchElementException 발생 한다.")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 3})
	void 주어진_id_가_1_2_외_값이라면_예외발생_테스트(int id) {
		assertThatThrownBy(() -> PaymentType.of(id)).isInstanceOf(NoSuchElementException.class);
	}
}