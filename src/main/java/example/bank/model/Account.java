package example.bank.model;

import example.bank.validator.OffensiveNickName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @NotBlank(message = "Customer name is mandatory")
    private String customerName;

    @OffensiveNickName
    @Size(min = 5, max = 30, message = "Nickname must be between 5 and 30 characters")
    private String accountNickName;
}
