package be.heh.projet_test;

import be.heh.projet_test.adaptater.in.TacosController;
import be.heh.projet_test.adaptater.out.TacosRepository;
import be.heh.projet_test.model.Tacos;
import be.heh.projet_test.port.in.TacosListUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@WebMvcTest(TacosController.class)
public class AdapaterWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TacosListUseCase tacosListUseCase;

    @Mock
    TacosRepository tacosRepository;

    private List<Tacos> tacos = new ArrayList<>();

    @Test
    public void getTacosTest() throws Exception {
        tacos.add(new Tacos(123, "Montagnard", "L", "Cordon bleu", "raclette", "lardon", 11));

        //Stub
        Mockito.when(tacosListUseCase.getTacosList()).thenReturn(tacos);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("tacos"))
                .andExpect(model().attribute("tacos",Matchers.hasSize(1)));
    }
}