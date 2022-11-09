package tn.esprit.rh.achat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.IFactureService;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Facturetest {
	@Autowired
    IFactureService fs;
	
	@Test
    @Order(0)
    public void testaddFacture(){
		Facture fact=new Facture();
        Facture f= fs.addFacture(fact);
        Assertions.assertNotNull(f);
    }
	
	@Test
    @Order(1)
    public void testretrieveAllFacture(){
        int listFacture= fs.retrieveAllFactures().size();
        fs.addFacture(Facture.builder()
                .montantRemise(20)
                .montantFacture(1)
                .build());
        List<Facture> listFactures= fs.retrieveAllFactures();
        Assertions.assertEquals(listFacture+1,listFactures.size());
    }
	
	
	@Test
    @Order(2)
    public void testretrieveAllFactures(){
		Facture f = new Facture();
        int listFacture= fs.retrieveAllFactures().size();
        fs.addFacture(f);
        List<Facture> listFactures= fs.retrieveAllFactures();
        Assertions.assertEquals(listFacture+1,listFactures.size());
    }
	
	 @Test
	 @Order(5)
	 public void testdeleteFacture(){
		 Facture f= fs.addFacture(Facture.builder()
	                .montantRemise(20)
	                .montantFacture(1)
	                .build());
	        fs.cancelFacture(f.getIdFacture());
	        //Assertions.assertEquals(- 1,os.retrieveAllOperateurs().size());
	        Assertions.assertNull(fs.retrieveFacture(f.getIdFacture()));

	    }
	
	
	
	
}
