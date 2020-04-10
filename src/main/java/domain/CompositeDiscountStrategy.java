package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CompositeDiscountStrategy implements DiscountStrategy {
	private final List<DiscountStrategy> discountStrategies;

	public CompositeDiscountStrategy(List<DiscountStrategy> discountStrategies) {
		this.discountStrategies = Collections.unmodifiableList(
			new ArrayList<>(Objects.requireNonNull(discountStrategies)));
	}

	@Override
	public int findDiscountPrice(int currentPrice) {
		int res = currentPrice;
		for (DiscountStrategy discountStrategy : discountStrategies) {
			res = discountStrategy.findDiscountPrice(res);
		}
		return res;
	}
}
