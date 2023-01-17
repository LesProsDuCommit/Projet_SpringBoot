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
    @RequestMapping(value="/addTacos", method= RequestMethod.POST)
    @ResponseBody
    public RedirectView addTacos(@ModelAttribute("addTacos") Tacos tacos) throws Exception {
        Tacos t = new Tacos(tacos.getId(), tacos.getNom(), tacos.getTaille(), tacos.getViande(), tacos.getSauce(), tacos.getSupp(), tacos.getPrix());
        tacosListUseCase.addTacos(t);
        return new RedirectView("/");
    }
    @RequestMapping(value = "/deletetacos/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    @ResponseBody
    public RedirectView deleteTacos(@PathVariable("id") int id){
        tacosListUseCase.deleteTacos(id);
        return new RedirectView("/");
    }
}
