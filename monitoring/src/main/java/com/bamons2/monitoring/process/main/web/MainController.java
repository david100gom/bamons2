package com.bamons2.monitoring.process.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by david100gom on 2017. 8. 13.
 *
 * Github : http://github.com/david100gom
 */
@Controller
public class MainController {

    @RequestMapping(value = {"/"})
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return "index";
    }
}
