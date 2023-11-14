@RunWith(MockitoJUnitRunner.class)
package tn.esprit.rh.achat.controllers;

public class CategorieProduitControllerTest {

    @Mock
    private ICategorieProduitService categorieProduitService;

    @InjectMocks
    private CategorieProduitController categorieProduitController;

    @Test
    public void getCategorieProduit_ShouldReturnListOfCategorieProduit() {
        // Mocking
        List<CategorieProduit> mockCategories = Arrays.asList(new CategorieProduit(), new CategorieProduit());
        when(categorieProduitService.retrieveAllCategorieProduits()).thenReturn(mockCategories);

        // Test
        List<CategorieProduit> result = categorieProduitController.getCategorieProduit();

        // Assertions
        assertEquals(mockCategories, result);
        verify(categorieProduitService, times(1)).retrieveAllCategorieProduits();
    }

    @Test
    public void retrieveCategorieProduit_ShouldReturnCategorieProduit() {
        // Mocking
        Long categorieProduitId = 1L;
        CategorieProduit mockCategorie = new CategorieProduit();
        when(categorieProduitService.retrieveCategorieProduit(categorieProduitId)).thenReturn(mockCategorie);

        // Test
        CategorieProduit result = categorieProduitController.retrieveCategorieProduit(categorieProduitId);

        // Assertions
        assertEquals(mockCategorie, result);
        verify(categorieProduitService, times(1)).retrieveCategorieProduit(categorieProduitId);
    }

    // Add similar tests for addCategorieProduit, removeCategorieProduit, modifyCategorieProduit, etc.
}
