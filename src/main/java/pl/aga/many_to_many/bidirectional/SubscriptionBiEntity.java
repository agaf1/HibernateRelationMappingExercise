package pl.aga.many_to_many.bidirectional;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;
import pl.aga.many_to_many.unidirectional.ReaderEntity;

@Entity
@Table(name = "subscriptions_bi")
@Data
public class SubscriptionBiEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int subscriptionId;

  @Column(name = "name")
  private String subscriptionName;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<ReaderBiEntity> readers;
}
