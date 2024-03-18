package uz.pdp.shaftoli.repository.email;

import uz.pdp.shaftoli.entity.EmailCodeEntity;

public interface EmailCodeRepository {
    String UPDATE_EMAIL_CODE = "update email_code set email = :email,code = :code, limits = :limits where email = :email";
    String FIND_BY_EMAIL = "select from find_by_email(?)";
    String CHANGE_VALIDATED = "update users set validated = true where email = :email";
    void saveEmail(String email, String emailCode);

    Boolean checkEmailAndCode(String userEmail, String code);
    EmailCodeEntity findByEmail(String email);
}
