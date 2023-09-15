package pl.aga.many_to_many.bidirectional;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "readers_bi")
@Data
public class ReaderBiEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int readerId;

  private String email;

  private String firstName;

  private String lastName;

  @ManyToMany(mappedBy = "readers")
  private Set<SubscriptionBiEntity> subscriptions;
}
