package com.example.freecourse.controller;

import com.example.freecourse.domain.Member;
import com.example.freecourse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    //안좋은 예시
    //private final MemberService memberService = new MemberService();

    private final MemberService memberService;
    @Autowired //스프링이 연결시켜줌(컴포넌트 스캔 방법) / 멤버컨트롤러가 생성될 때 스프링빈에 있는 맴버서비스 객체를 가져다 넣어줌 -> DI
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String CreateForm(){
        return "members/createMemberForm";
    }

    @PostMapping
    public String Create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
        public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
