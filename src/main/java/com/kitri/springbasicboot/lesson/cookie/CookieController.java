package com.kitri.springbasicboot.lesson.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cookie")
public class CookieController {

    @PostMapping
    public String makecookie(HttpServletRequest request, HttpServletResponse response){
        // 쿠키 생성
        Cookie cookie = new Cookie("id", request.getParameter("id"));
        //getParam으로 보내지므로 postman에서 ? 쿼리스트링으로 보내야 됨

        //쿠키의 만료 기간 : 일주일
//        cookie.setMaxAge(60*60*24*7);
        cookie.setMaxAge(60);
        //쿠키를 클라이언트에서 서버로 보낼 때 경로 지정 -> 특정 url에서만 쿠키를 사용할 때
//        cookie.setPath();
        response.addCookie(cookie);

        return cookie.getValue();
        //쿠키에 저장한 값을 반환
    }
    @GetMapping
    public String readCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("id")) return cookie.getValue();
        }
        return null;
    }
    @GetMapping("/read")
    public String readCookie2(@SessionAttribute(name = "id", required = false) String id){
        //쿠키에 값이 없으면 오지 않지만 required를 적용하면 쿠키가 없어도 실행가능하다.
        return id;
    }

    @DeleteMapping
    public void deleteCookie(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("id"))
            {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            //0초 후에 만료 : 세션을 삭제
        }
    }
}
