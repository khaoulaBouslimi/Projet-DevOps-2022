package tn.esprit.rh.achat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MokFacture {
	@Mock
    FactureRepository FRMock;
    @InjectMocks
    FactureServiceImpl fs;

    Facture f = (Facture.builder()
            .montantRemise(20)
            .montantFacture(1)
            .build());
    List<Facture> listFournisseurs= new ArrayList<Facture>(){
        {
            add(Facture.builder().montantRemise(30).montantFacture(8).build());
            add(Facture.builder().montantRemise(40).montantFacture(9).build());
            add(Facture.builder().montantRemise(50).montantFacture(10).build());
            add(Facture.builder().montantRemise(60).montantFacture(11).build());
            

        }

    };
    @Test
    void testaddFacture() {
       Mockito.when(FRMock.save(f)).thenReturn(f);
       Facture fact= fs.addFacture(f);
       Assertions.assertNotNull(fact);

   }
    @Test
    void testretrieveFacture(){
        Mockito.when(FRMock.findById(Mockito.anyLong())).thenReturn(Optional.of(f)); //find all
        Facture fact= fs.retrieveFacture(2L);
        Assertions.assertNotNull(fact);

    }

}
