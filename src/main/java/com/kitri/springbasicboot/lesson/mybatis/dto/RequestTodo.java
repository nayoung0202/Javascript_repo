package com.kitri.springbasicboot.lesson.mybatis.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTodo {
    Long id;
    String content;
    boolean done;

    //클라이언트 (브라우저)에서 서버로 요청할 때 필요한 것
    // 조회 : done, content, 등록, 수정 : id, content, done, 삭제 : id
}
