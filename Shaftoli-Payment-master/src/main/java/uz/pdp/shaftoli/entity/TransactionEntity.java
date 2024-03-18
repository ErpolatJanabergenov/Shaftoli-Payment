package uz.pdp.shaftoli.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionEntity extends BaseModel{
    private String senderId;
    private String receiverId;
    private Double amount;
    private Double percentage;
}
