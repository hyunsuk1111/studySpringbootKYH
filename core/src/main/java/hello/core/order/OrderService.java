package hello.core.order;

public interface OrderService {
    
    //정적 팩토리 메서드
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
