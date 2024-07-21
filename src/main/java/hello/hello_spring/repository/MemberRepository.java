package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원을 저장하면 저장된 회원이 반환됨
    Optional<Member> findById(Long id); // null 일 경우를 처리하기 위해 optional 로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 모든 회원 리스트 반환

}
