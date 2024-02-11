package com.kitri.springbasicboot.lesson.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseTodo {
    Long id;
    String content;
    boolean done;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;

    //서버에서 클라이언트로 데이터를 보낼 때 필요한 것
}
