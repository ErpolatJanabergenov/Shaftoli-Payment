package uz.pdp.shaftoli.service.card;


import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.service.BaseService;

import java.util.ArrayList;
import java.util.List;

public interface CardService extends BaseService<CardEntity> {
    List<CardEntity> myCards(UserEntity user);
    Double userCardsBalance(UserEntity user);
}
