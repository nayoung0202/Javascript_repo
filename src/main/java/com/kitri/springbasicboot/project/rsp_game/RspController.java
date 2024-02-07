package com.kitri.springbasicboot.project.rsp_game;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rsp")
public class RspController {

    @PostMapping
    public String makeSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("id", request.getParameter("id"));
        return (String) session.getAttribute("id");
    }//세션 생성

    @GetMapping
    public String home() {
        return "/project/rsp_game/rsp";
    }
}
