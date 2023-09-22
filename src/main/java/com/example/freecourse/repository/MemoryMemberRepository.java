package com.example.freecourse.repository;

import com.example.freecourse.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); //회원 id와 회워정보를 해시맵에 저장(member객체가 들어감)
    private static long sequence = 0L;//id를 부여하기 위한 스퀀스

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    /*Optional은 null값 처리를 위해 사용함. 값을 가져오려면 한번 벗겨야 한다*/
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {//이름으로 찾기
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }//회원정보가 담긴 리스트 반환
    public void clearStore(){//값 초기화(Test를 위해서, interface에 없는 함수임)
        store.clear();
    }
}
