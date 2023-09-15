package pl.aga.one_to_many.foreign_key_column;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accounts4")
@Data
public class Account4Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int accountId;

    @Column(name = "number")
    private String accountNumber;

    @ManyToOne
    private Employee4Entity employee;
}
