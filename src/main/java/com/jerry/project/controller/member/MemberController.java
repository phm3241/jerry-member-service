package com.jerry.project.controller.member;

import com.jerry.project.controller.member.param.MemberLoginParam;
import com.jerry.project.domain.member.model.entity.Member;
import com.jerry.project.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Slf4j
@RestController
@RequiredArgsConstructor
//@RequestMapping(value = "/member-api/v1.0")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/checkLogin")
//    public ResponseEntity loginCheck(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember) {
    public ResponseEntity loginCheck(HttpServletRequest request) {

        log.info(">>>>> checkLogin - request : {} ", request);

        // 세션이 없으면 홈으로 이동
        HttpSession session = request.getSession(false);
        log.info(">>>>> checkLogin - session.getId() : {} ", session.getId());

        if (session == null) {
            return ResponseEntity.ok().body("session null");
        }

        // 세션에 저장된 회원 조회
        Member loginMember = (Member) session.getAttribute(SessionConstants.LOGIN_MEMBER);
        log.info(">>>>> checkLogin - loginMember : {} ", loginMember);

        if (SessionConstants.LOGIN_MEMBER == null) {
            return ResponseEntity.ok().body("loginMember null");
        }

        //세션에 회원 데이터가 없으면 로그인 화면으로
        if (loginMember == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Exception("로그인 상태가 아닙니다."));
        }

        return ResponseEntity.ok().body(loginMember);
    }



    @GetMapping("/login")
    public ResponseEntity login(MemberLoginParam loginParam, HttpServletRequest request) {
        log.info(">>>>> loginParam : {}, request : {}", loginParam.toString(), request.toString());

        Member loginMember = memberService.login(loginParam.getId(), loginParam.getPw());
        log.info(">>>>> loginMember : {}", loginMember);

        if (loginMember == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Exception("loginFail - 아이디 또는 비밀번호가 맞지 않습니다."));
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession();                         // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
        log.info(">>>>> session : {}", session.toString());

        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);   // 세션에 로그인 회원 정보 보관
        log.info(">>>>> session.loginMember : {}", session.getAttribute("loginMember"));
        log.info(">>>>> session.getId() : {}", session.getId());

        return ResponseEntity.ok().body(loginMember);
    }

//    @PostMapping("/logout")
//    public String logout(HttpServletRequest request) {
//
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();   // 세션 날림
//        }
//
//        return "redirect:/";
//    }

}
