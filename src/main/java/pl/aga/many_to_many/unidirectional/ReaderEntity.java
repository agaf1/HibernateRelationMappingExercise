package pl.aga.many_to_many.unidirectional;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "readers")
@Data
public class ReaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int readerId;

    private String email;

    private String firstName;

    private String lastName;
}
