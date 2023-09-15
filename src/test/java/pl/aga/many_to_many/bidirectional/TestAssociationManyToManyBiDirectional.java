package pl.aga.many_to_many.bidirectional;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.aga.many_to_many.unidirectional.ReaderEntity;
import pl.aga.many_to_many.unidirectional.SubscriptionEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestAssociationManyToManyBiDirectional {

  @Autowired private EntityManager entityManager;

  @Test
  public void should_create_3_table_and_add_data_to_DB() {

    ReaderBiEntity reader1 = createReaderBiEntity("demo-user1@mail.com");
    ReaderBiEntity reader2 = createReaderBiEntity("demo-user2@mail.com");
    Set<ReaderBiEntity> readers = Set.of(reader1, reader2);

    SubscriptionBiEntity subscription1 = createSubscriptionBiEntity("horror");
    SubscriptionBiEntity subscription2 = createSubscriptionBiEntity("fantasy");

    Set<SubscriptionBiEntity> subscriptions = Set.of(subscription1, subscription2);

    subscription1.setReaders(readers);
    subscription2.setReaders(readers);

    entityManager.persist(subscription1);
    entityManager.persist(subscription2);

    entityManager.flush();

    Assertions.assertNotNull(subscription1.getReaders());
    Assertions.assertNotNull(subscription1.getReaders());
  }

  private static SubscriptionBiEntity createSubscriptionBiEntity(String name) {
    SubscriptionBiEntity subscription1 = new SubscriptionBiEntity();
    subscription1.setSubscriptionName(name);
    return subscription1;
  }

  private static ReaderBiEntity createReaderBiEntity(String mail) {
    ReaderBiEntity reader1 = new ReaderBiEntity();
    reader1.setEmail(mail);
    reader1.setFirstName("demo");
    reader1.setLastName("user");
    return reader1;
  }
}
