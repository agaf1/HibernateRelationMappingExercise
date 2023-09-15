package pl.aga.many_to_many.unidirectional;

import jakarta.persistence.*;
import lombok.Data;
import pl.aga.many_to_many.unidirectional.ReaderEntity;

import java.util.Set;

@Entity
@Table(name = "subscriptions")
@Data
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int subscriptionId;

    @Column(name = "name")
    private String subscriptionName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ReaderEntity> readers;
}
