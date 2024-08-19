package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerive;
import hello.core.member.MemberServiceImple;

public class MemberApp {
    public static void main(String[] args) {
        MemberSerive memberSerive = new MemberServiceImple();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberSerive.join(member);

        Member finMember = memberSerive.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + finMember.getName());
    }
}
