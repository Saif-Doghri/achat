package tn.esprit.rh.achat.services;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.controllers.FournisseurRestController;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FournisseurTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @InjectMocks
    IFournisseurService fournisseurService;

    @InjectMocks
    private FournisseurRestController fournisseurRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllFournisseurs() {
        // Mock data
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur());
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        // Test
        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        // Verify
        assertEquals(fournisseurs, result);
    }

    @Test
    public void testRetrieveFournisseur() {
        // Mock data
        Long fournisseurId = 1L;
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.of(fournisseur));

        // Test
        Fournisseur result = fournisseurService.retrieveFournisseur(fournisseurId);

        // Verify
        assertEquals(fournisseur, result);
    }

    @Test
    public void testGetFournisseurs() {
        // Mock data
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur());
        when(fournisseurService.retrieveAllFournisseurs()).thenReturn(fournisseurs);

        // Test
        List<Fournisseur> result = fournisseurRestController.getFournisseurs();

        // Verify
        assertEquals(fournisseurs, result);
    }

    @Test
    public void testRetrieveFournisseurFromController() {
        // Mock data
        Long fournisseurId = 1L;
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurService.retrieveFournisseur(fournisseurId)).thenReturn(fournisseur);

        // Test
        Fournisseur result = fournisseurRestController.retrieveFournisseur(fournisseurId);

        // Verify
        assertEquals(fournisseur, result);
    }
    public void testAddFournisseur() {
        // Mock data
        Fournisseur fournisseurToAdd = new Fournisseur();
        when(fournisseurService.addFournisseur(any())).thenReturn(fournisseurToAdd);

        // Test
        Fournisseur result = fournisseurRestController.addFournisseur(fournisseurToAdd);

        // Verify
        assertNotNull(result);
        assertEquals(fournisseurToAdd, result);
    }

    @Test
    public void testRemoveFournisseur() {
        // Mock data
        Long fournisseurId = 1L;

        // Test
        fournisseurRestController.removeFournisseur(fournisseurId);

        // Verify
        verify(fournisseurService, times(1)).deleteFournisseur(fournisseurId);
    }
}
