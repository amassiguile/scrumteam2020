package kriattus.lesproduct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeContoller {
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", "Hello Yose <a href=\"https://github.com/EdnilsonSarmento/LesMasters2020\" id=\"repository-link\">Github</a>");
        return model;
    }

    @GetMapping("/contactme")
    public ModelAndView contactme(){
        return new ModelAndView("contactme");
    }

    @GetMapping("/astroport")
    public ModelAndView astroport(){
        return new ModelAndView("astroport");
    }

    @GetMapping("/minesweeper")
    public ModelAndView minesweeper(){
        return new ModelAndView("minesweeper");
    }

    @GetMapping("/primeFactors/ui")
    public ModelAndView primeFactors(){
        return new ModelAndView("primeFactors");
    }

}
