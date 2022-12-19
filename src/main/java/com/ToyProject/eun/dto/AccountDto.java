package com.ToyProject.eun.dto;

import com.ToyProject.eun.Validation.ValidationGroup;
import com.ToyProject.eun.domain.Account;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AccountDto {
    @NotBlank(message = "아이디는 비워둘 수 없습니다.", groups = ValidationGroup.NotBlankGroup.class)
    @Size(min = 3, message = "아이디는 3글자 이상 입력 가능합니다.", groups = ValidationGroup.SizeGroup.class)
    @Pattern(regexp = "^[a-zA-Z\\d]*$", message = "아이디는 영어, 숫자만 입력 가능합니다.", groups = ValidationGroup.PatternCheckGroup.class)
    private String username;

    @NotBlank(message = "비밀번호는 비워둘 수 없습니다.1", groups = ValidationGroup.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "최소 8자 이상, 최대 16자 이하로 입력해주세요", groups = ValidationGroup.SizeGroup.class)
    private String password;

    @NotBlank(message = "비밀번호는 비워둘 수 없습니다.2", groups = ValidationGroup.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "최소 8자 이상, 최대 16자 이하로 입력해주세요", groups = ValidationGroup.SizeGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$", message = "비밀번호는 특수기호, 영문, 숫자를 모두 포함해야합니다.", groups = ValidationGroup.PatternCheckGroup.class)
    private String passwordChk;


    public Account toEntity() {
        return Account.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .build();
    }

}
