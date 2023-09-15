package pl.aga.many_to_many.unidirectional;

import jakarta.persistence.EntityManager;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestAssociationManyToManyUniDirectional {

  @Autowired private EntityManager entityManager;

  @Test
  public void should_create_3_table_and_add_data_to_DB() {

    ReaderEntity reader1 = createReaderEntity("demo-user1@mail.com");
    ReaderEntity reader2 = createReaderEntity("demo-user2@mail.com");
    Set<ReaderEntity> readers = Set.of(reader1, reader2);

    SubscriptionEntity subscription1 = createSubscriptionEntity("horror");
    SubscriptionEntity subscription2 = createSubscriptionEntity("fantasy");

    Set<SubscriptionEntity> subscriptions = Set.of(subscription1, subscription2);
    subscription1.setReaders(readers);
    subscription2.setReaders(readers);

    entityManager.persist(subscription1);
    entityManager.persist(subscription2);

    entityManager.flush();

    Assertions.assertNotNull(subscription1.getReaders());
    Assertions.assertNotNull(subscription1.getReaders());
  }

  private static SubscriptionEntity createSubscriptionEntity(String name) {
    SubscriptionEntity subscription1 = new SubscriptionEntity();
    subscription1.setSubscriptionName(name);
    return subscription1;
  }

  private static ReaderEntity createReaderEntity(String mail) {
    ReaderEntity reader1 = new ReaderEntity();
    reader1.setEmail(mail);
    reader1.setFirstName("demo");
    reader1.setLastName("user");
    return reader1;
  }
}
