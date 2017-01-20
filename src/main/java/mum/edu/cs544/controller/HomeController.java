package mum.edu.cs544.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {

	
	@RequestMapping("/")
    public String checkout(Model model,HttpServletRequest request) {
        /*String clientToken = gateway.clientToken().generate();
        model.addAttribute("clientToken", clientToken);
        String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name.toString());
		Cart cart = customer.getCart();
		if(cart.getCartItems().size() <= 0)
		{
			return "redirect:/checkout";
		}*/
		model.addAttribute("name","Online Shopping Store");
        return "site.homepage";
    }
	
}
