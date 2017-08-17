package com.bamons2.monitoring.process.main.web;

import com.bamons2.monitoring.process.main.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
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


        model.addAttribute("today", mainService.today());
        return "admin";
    }
}
