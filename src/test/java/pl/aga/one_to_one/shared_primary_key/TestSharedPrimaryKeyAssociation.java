package pl.aga.one_to_one.shared_primary_key;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.aga.one_to_one.with_join_table.Account2Entity;
import pl.aga.one_to_one.with_join_table.Employee2Entity;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestSharedPrimaryKeyAssociation {


    @Autowired
    private EntityManager entityManager;

    @Test
    public void should_create_2_table_in_DB_and_save_objects_with_relation() {

        Account3Entity account = new Account3Entity();
        account.setAccountNumber("123-345-65454");

        Employee3Entity emp = new Employee3Entity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");

        entityManager.persist(account);

        Assertions.assertNotNull(account.getAccountId());

        emp.setAccount(account);
        entityManager.persist(emp);
        Assertions.assertNotNull(emp.getEmployeeId());

        Assertions.assertNotNull(emp.getAccount().getAccountId());

    }

}