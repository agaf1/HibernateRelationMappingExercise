package pl.aga.one_to_one.with_join_table;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees2")
@Data
public class Employee2Entity {

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
    @JoinTable(name = "employee_account",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Account2Entity account2;
}
