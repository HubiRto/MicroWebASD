package pl.pomoku.authservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pomoku.authservice.dto.request.RegisterUserRequest;
import pl.pomoku.authservice.entity.User;
import pl.pomoku.authservice.exception.AppException;
import pl.pomoku.authservice.repository.RoleRepository;
import pl.pomoku.authservice.repository.UserRepository;
import pl.pomoku.authservice.service.UserService;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void create(RegisterUserRequest request) {
        if (existByRegisterRequest(request)) {
            throw new AppException(
                    "Użytkownik o takim emailu lub studentId już istnieje",
                    HttpStatus.BAD_REQUEST
            );
        }
        repository.save(getUserFromRegisterRequest(request));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new AppException(
                String.format("Nie ma użytkownika o mailu: %s", email),
                HttpStatus.NOT_FOUND
        ));
    }

    private boolean existByRegisterRequest(RegisterUserRequest request) {
        return repository.existsByEmailAndStudentId(request.email(), request.studentId());
    }

    private User getUserFromRegisterRequest(RegisterUserRequest request) {
        return User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .studentId(request.studentId())
                .roles(new HashSet<>(List.of(roleRepository.findByName("USER"))))
                .build();
    }
}
