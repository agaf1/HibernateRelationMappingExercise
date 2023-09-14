package pl.aga.one_to_one.shared_primary_key;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accounts3")
@Data
public class Account3Entity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private Employee3Entity employee;
}
