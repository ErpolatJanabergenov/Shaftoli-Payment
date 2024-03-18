package uz.pdp.shaftoli.repository.card;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.UserEntity;
import java.util.List;





@Repository
public class CardRepositoryImpl implements CardRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public CardEntity save(CardEntity cardEntity) {
        CardEntity card = null;
        try{
        card = getCardByNumbers(cardEntity.getCardNumber());
        }catch(IllegalArgumentException | NoResultException e){
            entityManager.persist(cardEntity);
            return cardEntity;
        }
        return null;
    }



    @Override
    public CardEntity findByEmail(String email) {
        return null;
    }

    @Override
    public List<CardEntity> getAll() {
        return null;
    }

    @Override
    public List<CardEntity> getUsersCards(UserEntity owner) {
        return entityManager.createQuery("select c from card c where c.owner = :owner", CardEntity.class)
                .setParameter("owner", owner.getId())
                .getResultList();
    }

    @Override
    public CardEntity getCardByNumbers(String numbers) {
        try{
        return entityManager.createQuery("select c from card c where c.cardNumber = :numbers", CardEntity.class)
                .setParameter("number", numbers)
                .getSingleResult();
        }
        catch (NoResultException e){
            return null;
        }
    }
    public List<CardEntity> getAllCardUsers(String userId){
        return entityManager.createQuery("select c from card c where c.owner = :id", CardEntity.class)
                .setParameter("id", userId)
                .getResultList();
    }



}
