package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // 스프링이 스프링 컨테이너에 있는 멤버 서비스를 가져다가 연결시켜준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
