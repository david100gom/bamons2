package com.bamons2.monitoring.process.main.web;

import com.bamons2.monitoring.process.main.service.MainService;
import com.bamons2.monitoring.process.member.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by david100gom on 2017. 8. 13.
 *
 * Github : https://github.com/david100gom
 */
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = {"/"})
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {


        model.addAttribute("today", mainService.today());
        return "index";
    }

    @RequestMapping(value = {"/admin"})
    public String admin(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        // 로그인 성공후 로그인 정보
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("today", mainService.today());
        model.addAttribute("name", member.getUsername());
        return "admin";
    }

    @RequestMapping(value = {"/admin/member"})
    public String member(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        // 로그인 성공후 로그인 정보
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("today", mainService.today());
        model.addAttribute("name", member.getUsername());
        return "member";
    }

    @RequestMapping(value = {"/user"})
    public String user(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        // 로그인 성공후 로그인 정보
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("today", mainService.today());
        model.addAttribute("name", member.getUsername());
        return "user";
    }
}
