import com.example.demo.dto.CreateClientDto;
import com.example.demo.validation.ClientValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientValidatorTest {

   @Mock
   private Environment env;

   @InjectMocks
   ClientValidator clientValdator;

    @Test
    public void testExpectedSuccess() {

        when(env.containsProperty(any())).thenReturn(Boolean.TRUE);
        when(env.getProperty(any())).thenReturn(new String("true"));

        CreateClientDto createClientDtoRight = new CreateClientDto(111L,"surname1", "name1", "patronymic1","1111 111111",
                "71111111111","Nizhniy", new Date(),"email1", "reg1", "res1"  );

        String realResult = clientValdator.validateClient("mail", createClientDtoRight);
        String expectedResult = "Success";
        assertEquals(realResult, expectedResult );
    }

    @Test
    void testExpectedNotSuccess() {

        when(env.containsProperty("validator.required.mail.name")).thenReturn(Boolean.TRUE);
        when(env.getProperty("validator.required.mail.name")).thenReturn(new String("true"));

        when(env.containsProperty("validator.required.mail.email")).thenReturn(Boolean.TRUE);
        when(env.getProperty("validator.required.mail.email")).thenReturn(new String("true"));

        CreateClientDto createClientDtoUnright = new CreateClientDto( 222L,"surname1", "name1", "patronymic1","1111 111111",
                "71111111111","Nizhniy", new Date(),null, "reg1", "res1"  );

        String realResult = clientValdator.validateClient("mail", createClientDtoUnright);
        String expectedResult = "Email should not be empty";
        assertEquals(realResult, expectedResult );
    }

}
