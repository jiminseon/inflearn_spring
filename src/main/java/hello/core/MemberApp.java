package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberSerive memberSerive = appConfig.memberSerive();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberSerive memberSerive = applicationContext.getBean("memberSerive", MemberSerive.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberSerive.join(member);

        Member finMember = memberSerive.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + finMember.getName());
    }
}
