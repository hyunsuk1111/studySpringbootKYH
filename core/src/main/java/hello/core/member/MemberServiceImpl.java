package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //생성자를 통해 구현객체를 주입한다.
    //MemberRepository의 구현객체는 없고 오로지 인터페이스만 의존한다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override

    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
