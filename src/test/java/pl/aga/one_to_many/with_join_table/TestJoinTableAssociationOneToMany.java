package pl.aga.one_to_many.with_join_table;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.aga.one_to_many.foreign_key_column.Account4Entity;
import pl.aga.one_to_many.foreign_key_column.Employee4Entity;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestJoinTableAssociationOneToMany {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void should_create_3_table_in_DB_and_add_new_data_with_relation(){

        Account5Entity account1 = new Account5Entity();
        account1.setAccountNumber("123-345-65454");

        Account5Entity account2 = new Account5Entity();
        account2.setAccountNumber("123-345-78789");

        Employee5Entity emp = new Employee5Entity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");

        entityManager.persist(account1);
        entityManager.persist(account2);

        Assertions.assertNotNull(account1.getAccountId());
        Assertions.assertNotNull(account2.getAccountId());

        Set<Account5Entity> accounts = new HashSet<>();
        accounts.add(account1);
        accounts.add(account2);

        emp.setAccounts(accounts);

        entityManager.persist(emp);
        entityManager.flush();
        Assertions.assertNotNull(emp.getEmployeeId());

        Assertions.assertNotNull(emp.getAccounts());


    }


}