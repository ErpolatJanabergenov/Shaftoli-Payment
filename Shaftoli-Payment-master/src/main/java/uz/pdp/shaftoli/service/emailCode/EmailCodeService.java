package uz.pdp.shaftoli.service.emailCode;

public interface EmailCodeService {

    void sendCodeToEmailAndReturn(String receiverEmail);

    Boolean checkEmailAndCode(String userEmail, String emailCode);
}
