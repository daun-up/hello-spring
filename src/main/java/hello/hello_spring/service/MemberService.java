package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) { // 멤버 리포지토리를 직접 new 해서 생성하는 것이 아니라 외부에서 넣어주게 바꿔줌
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 안 된다.

//        Optional<Member> result = memberRepository.findByName(member.getName()); // command + option + v 하면 return 만들어줌
//        result.ifPresent(m -> { // 만약 이름이 존재하면
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        validateDuplicateMember(member);
        memberRepository.save(member); // repository 에 저장하고
        return member.getId(); // id 반환

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // command + option + v 하면 return 만들어줌
            .ifPresent(m -> { // 만약 이름이 존재하면
                 throw new IllegalStateException("이미 존재하는 회원입니다.");
        }); // -> 메소드로 뽑는 게 좋음
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
