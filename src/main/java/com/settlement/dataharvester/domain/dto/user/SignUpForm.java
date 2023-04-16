package com.settlement.dataharvester.domain.dto.user;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Data
public class SignUpForm {

    @Length(min = 1, max = 10)
    private String username;

    @Length(min = 1, max = 10)
    private String password;

    @Email
    private String email;

    @Length(min = 1, max = 10)
    private String fullname;

    private String encodedPassword;
}
