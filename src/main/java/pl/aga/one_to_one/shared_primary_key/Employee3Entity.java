package pl.aga.one_to_one.shared_primary_key;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees3")
@Data
public class Employee3Entity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Account3Entity account;
}
