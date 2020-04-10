package domain;

public interface DiscountStrategy {
	// 치킨 메뉴 추가 할인,  현금 추가 할인
	int findDiscountPrice(int currentPrice);
}
