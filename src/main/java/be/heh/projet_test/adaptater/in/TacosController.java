package be.heh.projet_test.adaptater.in;

import be.heh.projet_test.model.Tacos;
import be.heh.projet_test.port.in.TacosListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/updatetacos/{id}")
    @ResponseBody
    public ModelAndView updateTacosView(@PathVariable("id") int id, Model model){
        Tacos t = tacosListUseCase.getTacosById(id);
        model.addAttribute("tacos", t);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateTacos");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping(value = "/updatetacos/confirm", method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public RedirectView updateTacos(@ModelAttribute("updatetacos") Tacos tacos){
        Tacos t = new Tacos(tacos.getId(), tacos.getNom(), tacos.getTaille(), tacos.getViande(), tacos.getSauce(), tacos.getSupp(), tacos.getPrix());
        tacosListUseCase.updateTacos(t);
        return new RedirectView("/");
    }
}
