package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
//final 필드들을 모아서 생성자를 만든다음 의존성 주입해줌
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    //인터페이스에만 의존하게한다.
    //값이 할당 되어있지 않으니 NullPointException >> OrderServiceImpl이 DiscountPolicy에
    //구현객체를 생성해서 주입해줘야한다!
    private final MemberRepository  memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
