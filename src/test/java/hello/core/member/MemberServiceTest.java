package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberSerive memberSerive = new MemberServiceImple();
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberSerive.join(member);
        Member findMember = memberSerive.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
