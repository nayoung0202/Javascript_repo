package com.kitri.springbasicboot.lesson.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import static javax.swing.text.html.CSS.getAttribute;

@RestController
@RequestMapping("/session")
public class SessionController {
    @PostMapping
    public String makeSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("id", request.getParameter("id"));
        return (String) session.getAttribute("id");
    }

    //조회
    @GetMapping
    public String readSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (String) session.getAttribute("id");
    }


    //로그아웃 기능과 비슷
    @DeleteMapping
    public void deleteSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session != null){
            session.invalidate();
            //만약 세션이 null이 아니면 삭제하라는 것 (무효화)
        }
    }
}
