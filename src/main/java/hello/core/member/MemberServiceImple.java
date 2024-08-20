package hello.core.member;

public class MemberServiceImple implements  MemberSerive {

    //DIP 위반 -> MemberServiceImple 클래스는 repo의 추상화, 구체화 모두 의존
    private final MemberRepository memberRepository;

    public MemberServiceImple(MemberRepository memberRepository) {
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
