package tn.esprit.rh.achat;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class FournisseurTest {
	@Autowired
    IFournisseurService fs;
	
	@Test
    @Order(1)
    public void testaddfournisseur(){
        Fournisseur f= fs.addFournisseur(Fournisseur.builder()
                .code("09891470")
                .libelle("libelle")
                .categorieFournisseur(CategorieFournisseur.ORDINAIRE)
                .build());
        Assertions.assertNotNull(f);

    }
	
	
	@Test
    @Order(2)
    public void testretrieveAllFournisseurs(){
		Fournisseur f = new Fournisseur();
        int listFournisseur= fs.retrieveAllFournisseurs().size();
        fs.addFournisseur(f);
        List<Fournisseur> listFournisseurs= fs.retrieveAllFournisseurs();
        Assertions.assertEquals(listFournisseur+1,listFournisseurs.size());
    }
	
	 @Test
	 @Order(5)
	 public void testdeleteFounisseur(){
		 Fournisseur f= fs.addFournisseur(Fournisseur.builder()
				 .code("09891471")
	                .libelle("esm")
	                .categorieFournisseur(CategorieFournisseur.ORDINAIRE)
	                .build());
	        fs.deleteFournisseur(f.getIdFournisseur());
	        //Assertions.assertEquals(- 1,os.retrieveAllOperateurs().size());
	        Assertions.assertNull(fs.retrieveFournisseur(f.getIdFournisseur()));

	    }



}
