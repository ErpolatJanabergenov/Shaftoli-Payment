package uz.pdp.shaftoli.repository.card;

import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.repository.BaseRepository;

import java.util.List;

public interface CardRepository extends BaseRepository<CardEntity> {
    List<CardEntity> getUsersCards(UserEntity owner);
    CardEntity getCardByNumbers(String numbers);
    List<CardEntity> getAllCardUsers(String userId);
}
