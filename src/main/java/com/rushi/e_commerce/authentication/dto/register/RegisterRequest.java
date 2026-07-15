package com.rushi.e_commerce.authentication.dto.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(@NotBlank @Size(min = 2, max = 40)
                              String name,
                              @NotBlank @Email
                              String email,
                              @NotBlank @Size(min = 8, max = 12)
                              String password,
                              @Pattern(regexp = "^\\+[1-9]\\d{1,14}$",
                                      message = "Phone Number should be in International format")
                              String phoneNumber
                              ) {
}
