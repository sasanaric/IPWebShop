package shop.ipwebshop.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.AuthResponse;
import shop.ipwebshop.models.entities.UserEntity;
import shop.ipwebshop.models.requests.LoginRequest;
import shop.ipwebshop.models.requests.UserRequest;
import shop.ipwebshop.repositories.UserEntityRepository;
import shop.ipwebshop.security.JwtGenerator;
import shop.ipwebshop.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtGenerator jwtGenerator;
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtGenerator jwtGenerator,
                          UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest userRequest) throws NotFoundException{
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userService.insert(userRequest, UserEntity.class);
        return new ResponseEntity<>("Korisnik je registrovan", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse(token, loginRequest.getUsername());
        System.out.println(authResponse);
        return  new ResponseEntity<>(authResponse,HttpStatus.OK);
    }
}
