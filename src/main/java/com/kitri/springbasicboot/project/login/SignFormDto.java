package com.kitri.springbasicboot.project.login;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class SignFormDto {
    public SignFormDto(@NonNull String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @NonNull
    String name; //이름
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    String email; //이메일
    @Size(min = 8)//최소 8글자
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$") //영문숫자 특수기호 8자리 이상
    String password; //비밀번호

    String check;


}
