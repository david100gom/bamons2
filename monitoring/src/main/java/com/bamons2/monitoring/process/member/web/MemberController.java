package com.bamons2.monitoring.process.member.web;

import com.bamons2.monitoring.process.member.domain.AuthenticationRequest;
import com.bamons2.monitoring.process.member.domain.AuthenticationToken;
import com.bamons2.monitoring.process.member.domain.Member;
import com.bamons2.monitoring.process.member.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by david100gom on 2017. 8. 22.
 *
 * Github : https://github.com/david100gom
 */
@Controller
public class MemberController {

//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    MemberService memberService;
//
//    // Rest 방식의 로그인
//    @RequestMapping(value="/rest/login", method= RequestMethod.POST)
//    public AuthenticationToken login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request){
//
//        String username = authenticationRequest.getUsername();
//        String password = authenticationRequest.getPassword();
//
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        Authentication authentication = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        HttpSession session = request.getSession(true);
//        session.setMaxInactiveInterval(30); // 세션타임설정
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
//
//        Member member = memberService.getMember(username);
//
//        return new AuthenticationToken(member.getName(), member.getAuthorities(), session.getId());
//    }

    @RequestMapping(value="/member/login", method= RequestMethod.GET)
    public String login() {
        return "member/login";
    }

}