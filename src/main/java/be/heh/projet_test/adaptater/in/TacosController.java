package be.heh.projet_test.adaptater.in;

import be.heh.projet_test.model.Tacos;
import be.heh.projet_test.port.in.TacosListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TacosController {

    private final TacosListUseCase tacosListUseCase;
    private List<Tacos> tacos;

    @GetMapping("/")
    public String tacosList(Model model){
        tacos = tacosListUseCase.getTacosList();
        model.addAttribute("tacos", tacos);
        return "index";
    }

}
