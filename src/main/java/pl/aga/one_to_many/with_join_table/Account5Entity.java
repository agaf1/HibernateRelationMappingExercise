package pl.aga.one_to_many.with_join_table;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accounts5")
@Data
public class Account5Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int accountId;

    @Column(name = "number")
    private String accountNumber;

    @ManyToOne
    private Employee5Entity employee;

}
