package pl.aga.one_to_one.with_join_table;

import jakarta.persistence.EntityManager;
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
class TestJoinTableAssociation {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void should_create_3_table_in_DB_and_save_objects_with_relation() {

        Account2Entity account = new Account2Entity();
        account.setAccountNumber("123-345-65454");

        Employee2Entity emp = new Employee2Entity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");

        entityManager.persist(account);

        Assertions.assertNotNull(account.getAccountId());

        emp.setAccount2(account);
        entityManager.persist(emp);
        Assertions.assertNotNull(emp.getEmployeeId());

        Assertions.assertNotNull(emp.getAccount2().getAccountId());

    }


}