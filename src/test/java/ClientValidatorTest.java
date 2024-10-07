import com.example.demo.dto.CreateClientDto;
import com.example.demo.validation.ClientValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientValidatorTest {

    ClientValidator clientValdator;

    @Test
    public void testExpectedSuccess() {

        CreateClientDto createClientDtoRight = new CreateClientDto(111L, "surname1", "name1", "patronymic1","1111 111111",
                "71111111111","Nizhniy", new Date(),"email1", "reg1", "res1"  );

        String realResult = clientValdator.validateClient("mail", createClientDtoRight);
        String expectedResult = "Success";
        assertEquals(realResult, expectedResult );
    }

    @Test
    void testExpectedNotSuccess() {
        CreateClientDto createClientDtoUnright = new CreateClientDto(111L, "surname1", "name1", "patronymic1","1111 111111",
                "71111111111","Nizhniy", new Date(),null, "reg1", "res1"  );

        String realResult = clientValdator.validateClient("mail", createClientDtoUnright);
        String expectedResult = "Name should not be empty";
        assertEquals(realResult, expectedResult );
    }

}
