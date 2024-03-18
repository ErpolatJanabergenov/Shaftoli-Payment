package uz.pdp.shaftoli.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "card")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CardEntity extends BaseModel{
    private UUID owner;
    private String cardNumber;
    private String password;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private CardType type;
    private Boolean status;
}
