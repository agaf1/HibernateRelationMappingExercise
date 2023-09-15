package pl.aga.one_to_many.foreign_key_column;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.aga.one_to_one.foreign_key_column.AccountEntity;
import pl.aga.one_to_one.foreign_key_column.EmployeeEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestForeignKeyAssociationOneToMany {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void should_create_2_table_in_DB_and_add_new_data_with_relation(){

        Account4Entity account1 = new Account4Entity();
        account1.setAccountNumber("123-345-65454");

        Account4Entity account2 = new Account4Entity();
        account2.setAccountNumber("123-345-78789");

        Employee4Entity emp = new Employee4Entity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");

        entityManager.persist(account1);
        entityManager.persist(account2);

        Assertions.assertNotNull(account1.getAccountId());
        Assertions.assertNotNull(account2.getAccountId());

        Set<Account4Entity> accounts = new HashSet<>();
        accounts.add(account1);
        accounts.add(account2);

        emp.setAccounts(accounts);

        entityManager.persist(emp);
        entityManager.flush();
        Assertions.assertNotNull(emp.getEmployeeId());

        Assertions.assertNotNull(emp.getAccounts());


    }

}