package tn.esprit.rh.achat.services;

import static org.junit.Assert.*;


import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {
    @Autowired
    ISecteurActiviteService secteurActiviteService;

    @Mock
    SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    SecteurActiviteServiceImpl secteurActiviteServicemock;

    @Test
    public void testAddStock() {
        SecteurActivite s = new SecteurActivite();
        s.setCodeSecteurActivite("testCode");
        s.setLibelleSecteurActivite("testLibelle");
        SecteurActivite savedSecteurActivite= secteurActiviteService.addSecteurActivite(s);
        assertNotNull(savedSecteurActivite.getLibelleSecteurActivite());
    }
    @Test
    public void testMajVerif() {
        for (SecteurActivite s : secteurActiviteService.retrieveAllSecteurActivite())
        {
            assertEquals(s.getCodeSecteurActivite().substring(0,1),"t");
        }
    }
    @Test
    public void testAddSecteurActiviteMock() {
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setCodeSecteurActivite("testCode");
        secteurActivite.setLibelleSecteurActivite("testLibelle");
        Mockito.when(this.secteurActiviteRepository.save(Mockito.any())).thenReturn(secteurActivite);
        SecteurActivite savedSecteurActivite = secteurActiviteServicemock.addSecteurActivite(secteurActivite);
        assertNotNull(savedSecteurActivite.getLibelleSecteurActivite() );
    }



}