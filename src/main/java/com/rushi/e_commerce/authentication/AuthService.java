package com.rushi.e_commerce.authentication;

import com.rushi.e_commerce.User.UserEntity.Role;
import com.rushi.e_commerce.User.UserEntity.UserEntity;
import com.rushi.e_commerce.User.UserRepository;
import com.rushi.e_commerce.authentication.dto.login.LoginRequest;
import com.rushi.e_commerce.authentication.dto.login.LoginResponse;
import com.rushi.e_commerce.authentication.dto.register.RegisterRequest;
import com.rushi.e_commerce.authentication.dto.register.RegisterResponse;
import com.rushi.e_commerce.authentication.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    public RegisterResponse register(RegisterRequest request){
        if(userRepository.existsByEmail(request.email()))
            throw  new RuntimeException("User Already Exists");
        UserEntity user = UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .phoneNumber(request.phoneNumber())
                .role(Role.CUSTOMER)
                .build();
        UserEntity savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser);
        return new RegisterResponse(savedUser.getName(),
                savedUser.getEmail(),
                token,
                "User Registered Successfully");
    }

    public LoginResponse login(LoginRequest request){
        if(!userRepository.existsByEmail(request.email()))
            throw new RuntimeException("User not registered!");
        UserEntity user = userRepository.findByEmail(request.email()).orElseThrow(() -> new RuntimeException("User Not Found!"));
        String token;
        if(passwordEncoder.matches(request.password(), user.getPassword())){
            token = jwtService.generateToken(user);
        }
        else throw new RuntimeException("Password is Incorrect!");
        return new LoginResponse(user.getEmail(), token, user.getRole(), "LoggedIn Successfully!");
    }
}
