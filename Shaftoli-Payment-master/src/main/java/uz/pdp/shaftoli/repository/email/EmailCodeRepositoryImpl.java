package uz.pdp.shaftoli.repository.email;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.EmailCodeEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Repository
public class EmailCodeRepositoryImpl implements EmailCodeRepository{
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void saveEmail(String email, String code) {
        EmailCodeEntity emailCodeEntity = new EmailCodeEntity(email, code,LocalDateTime.now().plus(2, ChronoUnit.MINUTES) );

        EmailCodeEntity emailCode = null;
        try {
            emailCode = findByEmail(email);
            System.out.println("function findByEmail in save = " + emailCode);
            if(email != null){
                entityManager.createQuery(UPDATE_EMAIL_CODE)
                        .setParameter("email", email)
                        .setParameter("code", code)
                        .setParameter("limits", LocalDateTime.now().plus(2, ChronoUnit.MINUTES))
                        .setParameter("email", email)
                        .executeUpdate();
            }
        } catch (IllegalArgumentException | NoResultException e){
            entityManager.persist(emailCodeEntity);
        }
    }

//    @Transactional
    @Override
    public EmailCodeEntity findByEmail(String email) {
        return entityManager.createQuery("select c from email_code c where c.email = :email", EmailCodeEntity.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Transactional
    @Override
    public Boolean checkEmailAndCode(String userEmail, String code) {
        EmailCodeEntity result = findByEmail(userEmail);
        boolean isBefore = LocalDateTime.now().isBefore(result.getLimits());
        if (Objects.equals(result.getEmail(), userEmail) && isBefore){
            changeValidated(result.getEmail());
            return true;
        }
        return false;
    }
    public void changeValidated(String email){
        entityManager.createQuery(CHANGE_VALIDATED)
                .setParameter("email", email)
                .executeUpdate();
    }
}
