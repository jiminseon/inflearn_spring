package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberSerive;
import hello.core.member.MemberServiceImple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("이름, 타입으로 조회")
    void findBeanByName() {
        MemberSerive memberService = ac.getBean("memberService", MemberSerive.class);
        assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test
    @DisplayName("타입으로 조회")
    void findBeanByType() {
        MemberSerive memberService = ac.getBean(MemberSerive.class);
        assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImple memberService = ac.getBean("memberService", MemberServiceImple.class);
        assertThat(memberService).isInstanceOf(MemberSerive.class);
    }


    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByNameX() {
        //ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberSerive.class));
    }

}
