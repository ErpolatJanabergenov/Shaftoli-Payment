package uz.pdp.shaftoli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.EmailCodeEntity;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.service.card.CardService;
import uz.pdp.shaftoli.service.emailCode.EmailCodeService;
import uz.pdp.shaftoli.service.user.UserService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class VerificationController {
    private final EmailCodeService emailCodeService;
    private final CardService cardService;
    private final UserService userService;
    @RequestMapping(value = "/auth/sign-up/verification/{owner}", method = RequestMethod.POST)
    public String verification(
            @RequestParam String emailCode,
            @RequestParam String userEmail,
            @PathVariable UUID owner,
            Model model
    )
    {
        UserEntity user = userService.finById(owner);
        model.addAttribute("userEmail", userEmail);
        Boolean verify = emailCodeService.checkEmailAndCode(userEmail, emailCode);
        System.out.println(verify.toString());
        if(verify) {
            List<CardEntity> cards = cardService.myCards(user);
            model.addAttribute("owner", user.getId());
            model.addAttribute("balance", cardService.userCardsBalance(user));
            model.addAttribute("cards", cards);
            cardService.myCards(user);
            model.addAttribute("owner", user.getId());
           return "manage-cards";
        }
        String massage = "Ko'dni notog'ri kiritdingiz! Tekshirib qayta kiriting!";
        model.addAttribute("massage", massage);
        return "verification";
    }

    @RequestMapping(value = "/verification")
    public String signUp(
            Model model
    ){
        UserEntity user = (UserEntity) model.getAttribute("user");
        String code = (String) model.getAttribute("code");
        String message = (String) model.getAttribute("message");
        model.addAttribute("massage", message);
        model.addAttribute("user", user);
        model.addAttribute("code", code);
        return "verification";
    }


}
