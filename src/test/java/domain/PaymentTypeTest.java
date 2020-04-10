package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
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

	@DisplayName("해당 결제 수단이 현금이 아닌지 테스트")
	@ParameterizedTest
	@CsvSource({"CASH,false", "CREDIT,true"})
	void 현재_결제수단이_현금인지_테스트(PaymentType paymentType, boolean expected) {
		assertThat(paymentType.isNotCash()).isEqualTo(expected);
	}

	@DisplayName("원금 입력시 결제수단에 따른 할인 금액을 반환한다. (현금 5%, 신용카드 0%)")
	@ParameterizedTest
	@CsvSource({"CASH,1000,950", "CREDIT,1000,1000"})
	void 원금_입력시_현금은_5프로할인_신용카드는_원금_값을_반환한다(PaymentType paymentType, int originPrice, int expected) {
		int actual = paymentType.calculateDiscountedPrice(originPrice);
		assertThat(actual).isEqualTo(expected);
	}
}