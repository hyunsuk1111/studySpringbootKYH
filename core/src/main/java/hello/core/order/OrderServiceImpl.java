package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository  memberRepository = new MemoryMemberRepository();
    //인터페이스에만 의존하게한다.
    //값이 할당 되어있지 않으니 NullPointException >> OrderServiceImpl이 DiscountPolicy에
    //구현객체를 생성해서 주입해줘야한다!
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
