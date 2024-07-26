package hello.hello_spring;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {



    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() { // 스프링 빈에 등록
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){ // MemberRepository 는 인터페이스이고
        return new MemoryMemberRepository(); // MemoryMemberRepository 는 구현체이다.
    }
}
