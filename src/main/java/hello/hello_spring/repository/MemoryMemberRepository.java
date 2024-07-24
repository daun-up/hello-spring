package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 아이디를 먼저 세팅하고
        store.put(member.getId(), member); // map 에 저장해준다
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    } // store 에서 꺼내면 됨

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // map 에서 돌면서 하나 찾으면 반환해줌 없으면 optional 에 null 을 포함해서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store 에 있는 values 가 멤버들임
    }

    public void clearStore() {
        store.clear();

    }
}
