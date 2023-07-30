package shop.ipwebshop.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.AuthResponse;
import shop.ipwebshop.models.dto.User;
import shop.ipwebshop.models.entities.UserEntity;
import shop.ipwebshop.models.requests.LoginRequest;
import shop.ipwebshop.models.requests.UserRequest;
import shop.ipwebshop.security.JwtGenerator;
import shop.ipwebshop.services.EmailService;
import shop.ipwebshop.services.UserService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtGenerator jwtGenerator;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final EmailService emailService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtGenerator jwtGenerator,
                          PasswordEncoder passwordEncoder, ModelMapper modelMapper, EmailService emailService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
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

    @GetMapping("/send-pin/{username}")
    public void sendEmail(@PathVariable String username) throws NotFoundException{
        User user = userService.getUserByUsername(username);
        Integer userId = user.getId();
        String pin = emailService.generatePin();
        String to = user.getEmail();
        System.out.println(to);
        String subject = "Potvrda email";
        String text = "Pin za potvrdu email je "+pin;
        System.out.println(text);
        emailService.sendMail("usersnaric@gmail.com",subject,text);
        String hashedPin = emailService.hashPin(pin);
        user.setPin(hashedPin);
        userService.update(userId,user,User.class);
    }

    @GetMapping("/confirm-pin/{username}/{pin}")
    public Boolean confirmPin(@PathVariable String username, @PathVariable String pin) throws NotFoundException {
        User user = userService.getUserByUsername(username);
        System.out.println(pin);
        String hashedUserPin = user.getPin();
        if(emailService.verifyPin(pin,hashedUserPin)){
            System.out.println("Email potvrdjen");
            user.setAccountConfirmed(true);
            userService.update(user.getId(),user,User.class);
            return true;
        }else{
            System.out.println("Email nije potvrdjen");
            return false;
        }
    }

}
