package tn.esprit.rh.achat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class OperatorTests {
    @Autowired
    IOperateurService os;

    @Test
    @Order(1)
    public void testRetrieAllOperateurs(){
        List<Operateur> listOperateurs = os.retrieveAllOperateurs();
        Assertions.assertEquals(0,listOperateurs.size());
    }
}
