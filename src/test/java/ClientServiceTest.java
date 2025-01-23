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

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @InjectMocks
    ClientService clientService;

   @Mock
     ClientMapper clientMapper;

    @Mock
    ClientRepository clientRepository;
/*
    ClientServiceTest(ClientService clientService1)
    {
        this.clientService = clientService1;



    }
*/
    @Test
    public void testSearchWithResult()
    {

        CreateClientDto createClientDto1 = new CreateClientDto(111L, "surname1", "name1", "patronymic1","1111 111111",
                "71111111111","Nizhniy", new Date(),"email1", "reg1", "res1"  );
        CreateClientDto createClientDto2 = new CreateClientDto(222L, "surname2", "name2", "patronymic2","2222 222222",
                "72222222222","Moscow", new Date(),"email2", "reg2", "res2"  );
        CreateClientDto createClientDto3 = new CreateClientDto( 333L,"surname3", "name3", "patronymic3","3333 333333",
                "73333333333","Nizhniy", new Date(),"email3", "reg3", "res3"  );
        ClientEntity entity1 = clientMapper.createClientDtoToClientEntity(createClientDto1);
        ClientEntity entity2 = clientMapper.createClientDtoToClientEntity(createClientDto2);
        ClientEntity entity3 = clientMapper.createClientDtoToClientEntity(createClientDto3);

/*
        ClientEntity entity1 = new ClientEntity( null,"surname1", 1111L, "name1","patronymic1",
                "71111111111","1111 111111","Nizhniy","email1", new Date(), "reg1", "res1"  );
        ClientEntity entity2 = new ClientEntity( null,"surname2", 2222L, "name2","patronymic2",
                "72222222222","1111 111111","Nizhniy","email1", new Date(), "reg1", "res1"  );
        ClientEntity entity3 = new ClientEntity( null, "surname2", 2222L, "name3","patronymic2",
                "72222222222","1111 111111","Nizhniy","email3", new Date(), "reg1", "res1"  );
                */

        clientService.createClient(entity1);
        clientService.createClient(entity2);
        clientService.createClient(entity3);
        Set<ClientEntity> searchSet = clientService.searchByString("email3 name3");
        String realResult = "";
        for (ClientEntity client: searchSet){
            realResult = realResult + client.getName();
        }
        String expectedResult = "name3";
        assertEquals(realResult, expectedResult );

    }


}
