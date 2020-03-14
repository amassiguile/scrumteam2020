package kriattus.lesproduct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeContoller {
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", "Hello Yose");
        return model;
    }

    @GetMapping("/contactme")
    public ModelAndView contactme(){
        ModelAndView model = new ModelAndView("contactme");
        return model;
    }

    @GetMapping("/astroport")
    public ModelAndView astroport(){
        ModelAndView model = new ModelAndView("astroport");
        return model;
    }

}
