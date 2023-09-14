package pl.aga.one_to_one.foreign_key_column;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class AccountEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToOne(mappedBy = "account")
    private EmployeeEntity employee;


}
