package com.example.mbtiquiz.service.signup;

import com.example.mbtiquiz.model.signup.SignupRequest;
import com.example.mbtiquiz.model.signup.SignupResponse;
import com.example.mbtiquiz.model.signup.User;
import com.example.mbtiquiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignupResponse registerUser(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .mbtiType(request.getMbtiType())
                .build();

        userRepository.save(user);

        return SignupResponse.builder()
                .message("User registered successfully")
                .email(user.getEmail())
                .mbtiType(user.getMbtiType())
                .build();
    }
}
