package hello.core.order;

public interface OrderService {
    
    //정적 팩토리 메서드
    //객체생성의 캡슐화, 구체적인 객체 생성이 필요할 경우 사용한다[static]
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
