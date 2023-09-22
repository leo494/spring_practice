//package com.example.freecourse.service;
///*ctrl shift t << test 만들기 단축기*/
//
//import com.example.freecourse.domain.Member;
//import com.example.freecourse.repository.MemoryMemberRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class MemberServiceTest {
///*
//    MemberService memberService = new MemberService();//test할 코드
//    MemoryMemberRepository repository = new MemoryMemberRepository();//clear시키기 위해 생성한 객체
//    위 코드의 문제점은  memberService인스턴스에 있는 memberRepository 인스턴스와 clear를 위해 생성한 repository객체가 서로 다른 MemoryMemberRepository 인스턴스인게 문제가 되는 코드
//    현재 db는 static으로 선언되어 문제가 없지만 좋은 코드는 아니기 때문에 아래와 같이 수정함
// */
//    MemberService memberService;//test할 코드
//    MemoryMemberRepository memberRepository;
//
//    @BeforeEach//test는 독립적이여야 하기 때문에 각각 실행 전 생성해줌
//    public void beforeEach(){//외부에서 메모리 멤버 레파지토리를 넣어줌 << DI
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);//인스턴스가 동일해짐
//    }
//    @AfterEach //method 끝나면 실행
//    public void afterEach() {
//        //memberService.memberRepository.clearStore(); << private라서 외부에선 접근 불가능 즉, MemoryMemberRepository 인스턴스는 결국 선어해야함
//    }
//    @Test
//    void 회원가입() {//given when then << 좋은 주석 방법 중 하나
//        //given
//        Member member = new Member();
//        member.setName("spring");
//        //when << 뭘 검증할꺼냐
//        Long saveId = memberService.join(member);
//        //then
//        Member findMember = memberService.findOne(saveId).get(); //ctrl alt v << 자동으로 반환형에 맞춰 담을 변수 생성
//        assertThat(member.getName()).isEqualTo(findMember.getName());
//    }
//    //test는 정상 흐름도 중요하지만 예외에 대한 test가 가장 중요.(여기선 중복 관련 test)
//    @Test
//    public void 중복회원가입예외(){
//        //given
//        Member member1 = new Member();
//        member1.setName("spring");
//
//        Member member2 = new Member();
//        member2.setName("spring"); //member1과 이름 중복
//
//        //when
//        /* 예외 캐치(test하자고 try catch 이러고 있으면 좀 애매함. 아래의 문법 추천)
//            memberService.join(member1);
//            memberService.join(member2);
//            try{
//                memberService.join(member2);
//                fail();
//            } catch(IllegalStateException e){
//                assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");//예외 메시지 떳는지 확인함
//            }
//        */
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//member2를 가입시킬때 IllegalStateException 에러가 터지길 기대하는 코드
//        //assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////then
//    }
//    @Test
//    void 회원찾기() {
//    }
//
//    @Test
//    void 하나찾기() {
//    }
//}