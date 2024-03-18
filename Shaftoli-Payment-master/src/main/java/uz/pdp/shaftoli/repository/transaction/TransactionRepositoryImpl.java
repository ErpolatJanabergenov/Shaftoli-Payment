package uz.pdp.shaftoli.repository.transaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.TransactionEntity;
import uz.pdp.shaftoli.entity.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public TransactionEntity save(TransactionEntity trans) {
        return null;
    }

    @Transactional
    @Override
    public String saveTransaction(TransactionEntity trans) {
        CardEntity senderCard = getCardByNumber(String.valueOf(trans.getSenderId()));
        CardEntity receiverCard;
        try{
            receiverCard = getCardByNumber(String.valueOf(trans.getReceiverId()));
        }
        catch (NoResultException e){
            return "Card not found";
        }
        if (senderCard.getBalance() < trans.getAmount() + trans.getAmount() * 0.01){
            return "Sorry! don't have enough money";
        }
        senderCard.setBalance(senderCard.getBalance() - trans.getAmount() - trans.getAmount() * 0.01);
        receiverCard.setBalance(receiverCard.getBalance() + trans.getAmount());
        updateCard(senderCard);
        updateCard(receiverCard);


        TransactionEntity transactionEntity = TransactionEntity.builder()
                .senderId(trans.getSenderId())
                .receiverId(trans.getReceiverId())
                .amount(trans.getAmount())
                .percentage(trans.getAmount() * 0.01)
                .build();
        //this is comment
        entityManager.persist(transactionEntity);
        return "Successful!!!";
    }

    public List<TransactionEntity> getByOwnerId (UUID id){
        return entityManager.createQuery("select c from card c where c.owner = :id", TransactionEntity.class)
                .setParameter("id", id)
                .getResultList();
    }



    @Override
    public TransactionEntity findByEmail(String email) {
        return null;
    }

    @Override
    public List<TransactionEntity> getAll() {
        return null;
    }

    public CardEntity getCardByNumber(String number) {
        try{
            return entityManager.createQuery("select c from card c where c.cardNumber = :number", CardEntity.class)
                    .setParameter("number", number)
                    .getSingleResult();
        }
        catch (NoResultException e){
            return null;
        }
    }

    @Transactional
    public void updateCard(CardEntity card){
        entityManager.createQuery("update card c set c.balance = :balance where c.id = :id")
                .setParameter("id", card.getId())
                .setParameter("balance", card.getBalance())
                .executeUpdate();
    }
    public List<TransactionEntity> getAllTransactions(UUID id){
        return entityManager.createQuery("select t from transaction t where t.id = :id", TransactionEntity.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<TransactionEntity> allUserTransactions(UUID id) {

        return null;
    }
}
