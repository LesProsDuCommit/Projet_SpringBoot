package be.heh.projet_test.adaptater.in;

import be.heh.projet_test.model.Tacos;
import be.heh.projet_test.port.in.TacosListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TacosController {

    private final TacosListUseCase tacosListUseCase;
    private List<Tacos> tacos;

    @GetMapping("/")
    public String tacosList(Model model, @AuthenticationPrincipal OidcUser user){
        tacos = tacosListUseCase.getTacosList();
        model.addAttribute("user", user);
        model.addAttribute("tacos", tacos);
        return "index";
    }

    @RequestMapping(value="/addTacosView/")
    @ResponseBody
    public ModelAndView addTacosView() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("form");
        return modelAndView ;
    }

    @RequestMapping(value="/addTacos", method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public RedirectView addTacos(@ModelAttribute("addTacos") Tacos tacos) throws Exception {
        try {
            Tacos t = new Tacos(tacos.getId(), tacos.getNom(), tacos.getTaille(), tacos.getViande(), tacos.getSauce(), tacos.getSupp(), tacos.getPrix());
            tacosListUseCase.addTacos(t);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
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
