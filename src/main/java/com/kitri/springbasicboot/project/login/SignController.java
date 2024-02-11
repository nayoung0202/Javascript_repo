package com.kitri.springbasicboot.project.login;
import com.kitri.springbasicboot.lesson.mapping.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/sign")
public class SignController {
    static HashMap<Integer, SignFormDto> signform = new HashMap<>();
    static {
        signform.put(1, new SignFormDto("kitri1", "kitri1@kitri", "qwe1234!" ));
        signform.put(2, new SignFormDto("kitri2", "kitri2@kitri", "qwe5678!" ));

    }
    static int id = 3; // 아이디 선언
    @GetMapping
    public String from(){
        return "redirect:/login/signup.html";
    }
    @PostMapping
    public String readFrom(@Valid SignFormDto form, BindingResult bindingResult){
        //Model
        System.out.println(form);

        if (bindingResult.hasErrors()){
            return "redirect:/login/signfail.html";
            //예외처리 Error가 터지면 리턴 url로 가도록 함
        }

        //비밀번호가 다르면 리다이렉트 signup
        if (!form.password.equals(form.check)) {
            return "redirect:/login/signfail.html";
        }

        //이메일이 있는 경우
        //for문돌면서 signform을 form.email이 있는 지 확인

       // 회원 add
        for(Map.Entry<Integer, SignFormDto> entry : signform.entrySet()) {
            String emailcheck = entry.getValue().email;
            if (emailcheck.equals(form.email)) {
                return "redirect:/login/signfail.html";
            }
        }
        signform.put(id, new SignFormDto(form.name, form.email, form.password));
        id++;

        return "redirect:/login/signsuccess.html";
    }


    @PostMapping("/login")
    public String loginFrom(@Valid SignFormDto form, HttpServletRequest request){


        //로그인 확인
        for(Map.Entry<Integer, SignFormDto> entry : signform.entrySet()) {
            String emailcheck = entry.getValue().email;
            String passwordcheck = entry.getValue().password;
            if (emailcheck.equals(form.email) && passwordcheck.equals(form.password)) {
                //패스워드 확인
                //session 생성
                HttpSession session = request.getSession();
                session.setAttribute("sessionId", form.email);
                return "redirect:/login/loginsuccess.html";
            }

            }
        return "redirect:/login/loginfail.html";
    }
    @GetMapping("/logout")
    public String deleteSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();

        session.invalidate();

        return "redirect:/login/login.html";

    }


}
