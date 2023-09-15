package pl.aga.one_to_many.foreign_key_column;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "employees4")
@Data
public class Employee4Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int employeeId;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
   // @JoinColumn(name = "employee_id")
    private Set<Account4Entity> accounts;

}
