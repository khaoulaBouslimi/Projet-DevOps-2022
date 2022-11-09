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

import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class FournisseurMockito {

	@Mock
    FournisseurRepository FRMock;
    @InjectMocks
    FournisseurServiceImpl fs;

    Fournisseur f = Fournisseur.builder().code("12833907").libelle("poubelle").categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build();
    List<Fournisseur> listFournisseurs= new ArrayList<Fournisseur>(){
        {
            add(Fournisseur.builder().code("09891470").libelle("Javel").categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build());
            add(Fournisseur.builder().code("01828028").libelle("Pril").categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build());
            add(Fournisseur.builder().code("06257318").libelle("jsp").categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build());
            add(Fournisseur.builder().code("09895768").libelle("soap").categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build());
            

        }

    };
    
    @Test
    void testaddFournisseur() {
       Mockito.when(FRMock.save(f)).thenReturn(f);
       Fournisseur f1= fs.addFournisseur(f);
       Assertions.assertNotNull(f1);

   }
    @Test
    void testretrieveFournisseur(){
        Mockito.when(FRMock.findById(Mockito.anyLong())).thenReturn(Optional.of(f)); //find all
        Fournisseur f1= fs.retrieveFournisseur(2L);
        Assertions.assertNotNull(f1);

    }
   
    
}
