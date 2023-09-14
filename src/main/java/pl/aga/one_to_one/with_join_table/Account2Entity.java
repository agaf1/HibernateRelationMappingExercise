package pl.aga.one_to_one.with_join_table;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accounts2")
@Data
public class Account2Entity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name = "account_number")
    private String accountNumber;




}
