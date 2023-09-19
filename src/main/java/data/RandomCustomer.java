package data;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class RandomCustomer {

    protected final Faker faker = new Faker();

    String firstName;
    String lastName;
    String postCode;

    public RandomCustomer () {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.postCode = faker.address().zipCode();
    }
}
