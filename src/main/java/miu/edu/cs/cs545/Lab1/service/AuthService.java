package miu.edu.cs.cs545.Lab1.service;


import miu.edu.cs.cs545.Lab1.dto.request.LoginRequest;
import miu.edu.cs.cs545.Lab1.dto.request.RefreshTokenRequest;
import miu.edu.cs.cs545.Lab1.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
