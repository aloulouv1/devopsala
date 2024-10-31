package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Universite;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FoyerTest {

    @Mock
    private Universite universiteMock;

    @InjectMocks
    private Foyer foyer;

    @BeforeEach
    void setUp() {
        // Initialize the Foyer object with mocked dependencies
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Test Foyer");
        foyer.setCapaciteFoyer(100);

        // Initialize an empty list for blocs and set it in the Foyer object
        List<Bloc> blocs = new ArrayList<>();
        foyer.setBlocs(blocs);

        // Set the mocked Universite object
        foyer.setUniversite(universiteMock);
    }

    @Test
    void testFoyerAttributes() {
        assertThat(foyer.getIdFoyer()).isEqualTo(1L);
        assertThat(foyer.getNomFoyer()).isEqualTo("Test Foyer");
        assertThat(foyer.getCapaciteFoyer()).isEqualTo(100);
    }

    @Test
    void testEmptyBlocsList() {
        assertThat(foyer.getBlocs()).isEmpty();
    }

    @Test
    void testUniversiteAssociation() {
        assertThat(foyer.getUniversite()).isNotNull();
    }
}
