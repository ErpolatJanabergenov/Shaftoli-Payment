package uz.pdp.shaftoli.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity extends BaseModel{
    private String name;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private Boolean validated;
}
