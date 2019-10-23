package ma.jit;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ma.jit.entites.Client;
import ma.jit.entites.ConseillerClient;
import ma.jit.service.IClientService;
import ma.jit.service.ICompteService;
import ma.jit.service.IConseillerService;
import ma.jit.spring.dao.IClientRepository;
import ma.jit.spring.dao.ICompteRepository;
import ma.jit.spring.dao.IConseillerRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxiBanqueV4ApplicationTests {
    @Autowired
    private IClientService clientService;
    @MockBean
    private IClientRepository clientDao;
    @Autowired
    private ICompteService CompteService;
    @MockBean
    private ICompteRepository compteDao;
    @Autowired
    private IConseillerService conseillerService;
    @MockBean
    private IConseillerRepository conseillerDao;
    @Test
    public void getAllClientsTest() {
        when(clientDao.findAll())
                .thenReturn(Stream
                        .of(new Client("Kadiri", "Julia", "julia@gmail.com", "sidi maarouf"),
                                new Client("Kadi", "Julio", "julio@gmail.com", "californie"))
                        .collect(Collectors.toList()));
        assertEquals(2, clientService.getAllClient().size());
    }
    @Test
    public void getAllConseillersTest() {
        when(conseillerDao.findAll()).thenReturn(Stream
                .of(new ConseillerClient("Edy", "Anas", "sidi maarouf", "Edy@gmail.com"),
                        new ConseillerClient("Edy", "Anas", "sidi maarouf", "Edy@gmail.com"))
                .collect(Collectors.toList()));
        assertEquals(2, conseillerService.getAllConseiller().size());
    }
    

    
    
    @Test
   public void deleteClientTest() {
       Client client = new Client(1L,"koko", "chuchu", "fufu", "tero");
       clientService.deleteClient(1L);
       verify(clientDao,times(1)).deleteById(1L);
   }
    
       

    
}