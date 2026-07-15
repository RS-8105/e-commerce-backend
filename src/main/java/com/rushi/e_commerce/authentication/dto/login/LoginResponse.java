package com.rushi.e_commerce.authentication.dto.login;

import com.rushi.e_commerce.User.UserEntity.Role;

public record LoginResponse(String email,
                            String token,
                            Role role,
                            String message) {
}
