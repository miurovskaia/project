import com.example.demo.dto.CreateClientDto;
import com.example.demo.entity.ClientEntity;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.service.ClientService;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServiceTest {

    ClientService clientService;
    ClientMapper clientMapper;

    @Test
    public void testSearchWithResult()
    {
        CreateClientDto createClientDto1 = new CreateClientDto(111L, "surname1", "name1", "patronymic1","1111 111111",
                "71111111111","Nizhniy", new Date(),"email1", "reg1", "res1"  );
        CreateClientDto createClientDto2 = new CreateClientDto(222L, "surname2", "name2", "patronymic2","2222 222222",
                "72222222222","Moscow", new Date(),"email2", "reg2", "res2"  );
        CreateClientDto createClientDto3 = new CreateClientDto(333L, "surname3", "name3", "patronymic3","3333 333333",
                "73333333333","Nizhniy", new Date(),"email3", "reg3", "res3"  );
        ClientEntity entity1 = clientMapper.createClientDtoToClientEntity(createClientDto1);
        ClientEntity entity2 = clientMapper.createClientDtoToClientEntity(createClientDto2);
        ClientEntity entity3 = clientMapper.createClientDtoToClientEntity(createClientDto3);

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
