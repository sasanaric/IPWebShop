package shop.ipwebshop.services;


public interface EmailService{
    void sendMail(String to,String subject, String text);
    String generatePin();
    String hashPin(String pin);
    boolean verifyPin(String userEnteredPin,String storedHashPin);
}
