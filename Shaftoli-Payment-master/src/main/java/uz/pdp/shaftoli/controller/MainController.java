package uz.pdp.shaftoli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.CardType;
import uz.pdp.shaftoli.entity.TransactionEntity;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.service.card.CardService;
import uz.pdp.shaftoli.service.transaction.TransactionService;
import uz.pdp.shaftoli.service.user.UserService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MainController {


    private final CardService cardService;
    private final UserService userService;
    private final TransactionService transactionService;


    @RequestMapping(value = "/payment/{owner}", method = RequestMethod.GET)
    public String payment(
            @PathVariable UUID owner,
            Model model
    ){
        System.out.println("owner = " + owner);
        model.addAttribute("owner", owner);
        UserEntity user = userService.finById(owner);
        List<CardEntity> cards = cardService.myCards(user);
        System.out.println("cards = " + cards);
        model.addAttribute("cards", cards);
        return "payment";
    }

    @RequestMapping(value = "/payment/{owner}", method = RequestMethod.POST)
    public String paymentPost(
            @PathVariable UUID owner,
            @ModelAttribute TransactionEntity transaction,
            Model model
    ){
        String result = transactionService.addTransaction(transaction);
        model.addAttribute("message", result);
        model.addAttribute("owner", owner);
        UserEntity user = userService.finById(owner);
        List<CardEntity> cards = cardService.myCards(user);
        model.addAttribute("cards", cards);
        return "payment";
    }

    @RequestMapping(value = "/p2p/{owner}", method = RequestMethod.GET)
    public String getP2p(
            @PathVariable UUID owner,
            Model model
    ){
        model.addAttribute("owner", owner);
        return "p2p";
    }

    @RequestMapping(value = "/p2p/{owner}", method = RequestMethod.POST)
    public String postP2p(
            @PathVariable UUID owner,
            @RequestParam String firstDate,
            @RequestParam String lastDate,
            Model model
    ){
        model.addAttribute("owner", owner);
        return "p2p";
    }

    @RequestMapping(value = "/history/{owner}")
    public String history(
            @PathVariable UUID owner,
            Model model
    ){
        model.addAttribute("owner", owner);
        return "history";
    }

    @RequestMapping(value = "/manage-cards/{owner}")
    public String getManageCards(
            @PathVariable UUID owner,
            Model model
    ){
        UserEntity user = userService.finById(owner);
        List<CardEntity> cards = cardService.myCards(user);
        Double balance = cardService.userCardsBalance(user);
        model.addAttribute("user", user);
        model.addAttribute("cards", cards);
        model.addAttribute("balance", balance);
        return "manage-cards";
    }

    @RequestMapping(value = "/manage-cards/add-card")
    public String getAddCard(
            @RequestParam UUID owner,
            Model model
    ){
        UserEntity user = userService.finById(owner);
        System.out.println("user = " + user);
        System.out.println("owner = " + owner);
        model.addAttribute("owner", owner);
        return "add-card";
    }

    @RequestMapping(value = "/manage-cards/add-card/{owner}", method = RequestMethod.POST)
    public String addCard(
            @ModelAttribute CardEntity card,
            @PathVariable UUID owner,
            Model model
    ){
        UserEntity user = userService.finById(owner);
        System.out.println("findUser = " + user);
        System.out.println("card = " + card);
        cardService.add(card);
        model.addAttribute("user", user);
        List<CardEntity> cards = cardService.myCards(user);
        model.addAttribute("balance", cardService.userCardsBalance(user));
        model.addAttribute("cards", cards);
        return "manage-cards";
    }
}
