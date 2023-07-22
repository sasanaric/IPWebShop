package shop.ipwebshop.services.implementation;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shop.ipwebshop.services.EmailService;

import java.util.Random;

@Service
public class EmailServiceImplementation  implements EmailService {
    private final JavaMailSender javaMailSender;

    public EmailServiceImplementation(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    @Override
    public String generatePin() {
        Random random = new Random();
        StringBuilder pinBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            pinBuilder.append(digit);
        }
        return pinBuilder.toString();
    }

    @Override
    public String hashPin(String pin) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(pin);
    }

    @Override
    public boolean verifyPin(String userEnteredPin, String storedHashedPin) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(userEnteredPin, storedHashedPin);
    }
}
