
@RunWith(MockitoJUnitRunner.class)
package tn.esprit.rh.achat.controllers;

public class OperateurControllerTest {

    @Mock
    private IOperateurService operateurService;

    @InjectMocks
    private OperateurController operateurController;

    @Test
    public void getOperateurs_ShouldReturnListOfOperateurs() {
        // Mocking
        List<Operateur> mockOperateurs = Arrays.asList(new Operateur(), new Operateur());
        when(operateurService.retrieveAllOperateurs()).thenReturn(mockOperateurs);

        // Test
        List<Operateur> result = operateurController.getOperateurs();

        // Assertions
        assertEquals(mockOperateurs, result);
        verify(operateurService, times(1)).retrieveAllOperateurs();
    }

    @Test
    public void retrieveOperateur_ShouldReturnOperateur() {
        // Mocking
        Long operateurId = 1L;
        Operateur mockOperateur = new Operateur();
        when(operateurService.retrieveOperateur(operateurId)).thenReturn(mockOperateur);

        // Test
        Operateur result = operateurController.retrieveOperateur(operateurId);

        // Assertions
        assertEquals(mockOperateur, result);
        verify(operateurService, times(1)).retrieveOperateur(operateurId);
    }

    // Add similar tests for addOperateur, removeOperateur, modifyOperateur, etc.
}
