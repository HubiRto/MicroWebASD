package pl.pomoku.authservice.service;

import pl.pomoku.authservice.dto.request.RegisterUserRequest;
import pl.pomoku.authservice.entity.User;

public interface UserService {
    void create(RegisterUserRequest request);
    void delete(Long id);
    User getByEmial(String email);
}
