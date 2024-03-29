package com.kitri.springbasicboot.lesson.vaild.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class SignUpFormDto {
    @NotEmpty
    String name;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    String email;
    @Size(min = 8)//최소 8글자
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$") //영문숫자 특수기호 8자리 이상
    String password;
    @Past //과거인 날짜만 나타내도록 제약조건을 줌
    LocalDate date;
    @NotEmpty
    String gender;
}
