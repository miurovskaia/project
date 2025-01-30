import com.example.demo.dto.CreateClientDto;
import com.example.demo.entity.ClientEntity;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import com.example.demo.validation.ClientValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @InjectMocks
    ClientService clientService;

    @Mock
    ClientRepository clientRepository;

    @Test
    public void testSearchWithResult()
    {
        ClientEntity clientEntity1 = new ClientEntity();
        clientEntity1.setResidentionaddress("res1");
        clientEntity1.setRegistrationaddress( "reg1" );
        clientEntity1.setEmail("email1");
        clientEntity1.setBirthday( new Date());
        clientEntity1.setPlaceofbirth( "Nizhniy");
        clientEntity1.setPhone("71111111111");
        clientEntity1.setPassport("1111 111111");
        clientEntity1.setPatronymic("patronymic1");
        clientEntity1.setName("name1");
        clientEntity1.setBankid( 111L );
        clientEntity1.setSurname("surname1");

        ClientEntity clientEntity2 = new ClientEntity();
        clientEntity2.setResidentionaddress("res2");
        clientEntity2.setRegistrationaddress( "reg2" );
        clientEntity2.setEmail("email2");
        clientEntity2.setBirthday( new Date());
        clientEntity2.setPlaceofbirth( "Nizhniy");
        clientEntity2.setPhone("72222222222");
        clientEntity2.setPassport("2222 222222");
        clientEntity2.setPatronymic("patronymic2");
        clientEntity2.setName("name2");
        clientEntity2.setBankid( 222L );
        clientEntity2.setSurname("surname2");

        ClientEntity clientEntity3 = new ClientEntity();
        clientEntity3.setResidentionaddress("res3");
        clientEntity3.setRegistrationaddress( "reg3" );
        clientEntity3.setEmail("email3");
        clientEntity3.setBirthday( new Date());
        clientEntity3.setPlaceofbirth( "Nizhniy");
        clientEntity3.setPhone("73333333333");
        clientEntity3.setPassport("3333 333333");
        clientEntity3.setPatronymic("patronymic3");
        clientEntity3.setName("name3");
        clientEntity3.setBankid(333L );
        clientEntity3.setSurname("surname3");

        List<String> searchString = new ArrayList<>();
        searchString.add("email3");
        searchString.add("name3");

        Set<ClientEntity> clientEntitySet = new HashSet<>();
        clientEntitySet.add(clientEntity3);

        when(clientRepository.findAllByNameIn( searchString)).thenReturn(clientEntitySet);
        when(clientRepository.findAllByEmailIn( searchString)).thenReturn(clientEntitySet);


        Set<ClientEntity> searchSet = clientService.searchByString("email3 name3");
        String realResult = "";
        for (ClientEntity client: searchSet){
            realResult = realResult + client.getName();
        }
        String expectedResult = "name3";
        assertEquals(realResult, expectedResult );

    }

}
