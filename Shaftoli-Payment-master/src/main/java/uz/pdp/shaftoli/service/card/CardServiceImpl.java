package uz.pdp.shaftoli.service.card;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.CardType;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.repository.card.CardRepository;
import uz.pdp.shaftoli.repository.user.UserRepository;
import uz.pdp.shaftoli.service.BaseService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    @Override
    public CardEntity add(CardEntity card) {
        return cardRepository.save(card);
    }

    @Override
    public List<CardEntity> getAll() {
        return null;
    }

    @Override
    public CardEntity getById() {
        return null;
    }

    @Override
    public List<CardEntity> myCards(UserEntity user) {
        return cardRepository.getUsersCards(user);
    }

    @Override
    public Double userCardsBalance(UserEntity user) {
        Double newBalance = 0D;
        for (CardEntity myCard : myCards(user)) {
            newBalance += myCard.getBalance();
        }
        return newBalance;
    }
}
