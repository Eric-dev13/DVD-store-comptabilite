import com.simplon.dvdstore.DvdstoreApplication;
import com.simplon.dvdstore.services.dvd.DvdStoreService;


import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



// run with ce qui permet de lancer le processus de test dans mon serveur
@RunWith(SpringRunner.class)
// 0configuration : librairaie de test, classe application (main)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DvdstoreApplication.class
)
// bean quand j'utilise mock
@AutoConfigureMockMvc
// application properties. Le mieux c'est d'avoir un autre application properties pour les tests
@TestPropertySource(locations = "classpath:application.yml")
public class DvdStoreServiceTest {

    @Autowired
    DvdStoreService dvdStoreService;

    private DvdStoreServiceModel createDvdServiceModel(String name, String genre) {
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel();
        dvdStoreServiceModel.setName(name);
        dvdStoreServiceModel.setGenre(genre);
        return dvdStoreServiceModel;
    }


    @Test
    public void add_dvd_returns_true_if_property_name_and_property_genre_is_not_null() throws Exception{
        assertTrue( dvdStoreService.addDvd(createDvdServiceModel("titre","sci-fi")) );
    }

    @Test
    public void add_dvd_returns_false_if_property_name_is_null() throws Exception{
        assertFalse( dvdStoreService.addDvd(createDvdServiceModel(null,"sci-fi")) );
    }

    @Test
    public void add_dvd_returns_false_if_property_genre_is_null() throws Exception{
        assertFalse( dvdStoreService.addDvd(createDvdServiceModel("titre",null)) );
    }

    @Test
    public void add_dvd_returns_false_if_property_name_and_property_genre_is_null() throws Exception{
        assertFalse( dvdStoreService.addDvd(createDvdServiceModel(null,null)) );
    }

}
