package com.rushi.e_commerce.authentication.dto.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterResponse(String name,
                               String email,
                               String token,
                               String message) {
}
