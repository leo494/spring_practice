package com.example.freecourse.service;
import com.example.freecourse.domain.Member;
import com.example.freecourse.repository.*;//다른 점
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    private final MemberRepository memberRepository; //객체타입 final은 이제 새로운 객체를 못 담게 하겠단 의미(속성은 변경 가능)

    //@Autowired//넌 생성자 매개변수 보고서 "멤버레포지토리가 필요하구나, 넣어줄게"(멤버레포지토리 구현부 : 메모리멤버레포지토리)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())//findByName method의 return이 Optional이라 .ifPresent함수 사용가능함.
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
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