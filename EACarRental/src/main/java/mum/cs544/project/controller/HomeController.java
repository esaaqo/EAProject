package mum.cs544.project.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.cs544.project.domain.User;
import mum.cs544.project.service.UserService;



/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("Iuser")
public class HomeController {
	@Autowired
	UserService userService;
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		 model.addAttribute("title", "Welcome");
	        model.addAttribute("message", "This is welcome page!");
	
		
		return "welcome";
	}
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String createEmployee(Model model) {

		return "reserve";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {
         
        return "loginPage";
    }
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public String logoutSuccessfulPage(Model model) {
	        model.addAttribute("title", "Logout");
	        return "logoutSuccessfulPage";
	    }
	 @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	    public String userInfo(Model model, Principal principal) {
	 
	        // After user login successfully.
	        String userName = principal.getName();
	        model.addAttribute("Iuser",userName);
	        User u=userService.findByUsername(userName);
	        model.addAttribute("email", u.getEmail());
	       
	 
	        System.out.println("User Name: "+ userName);
	 
	        return "home";
	    }
	 @RequestMapping(value = "/403", method = RequestMethod.GET)
	    public String accessDenied(Model model, Principal principal) {
	         
	        if (principal != null) {
	            model.addAttribute("message", "Hi " + principal.getName()
	                    + "<br> You do not have permission to access this page!");
	        } else {
	            model.addAttribute("msg",
	                    "You do not have permission to access this page!");
	        }
	        return "eror-forbidden";
	    }
	 
	 
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {
         
        return "loginPage";
    }
	@RequestMapping(value="/postLogin" , method= RequestMethod.POST)
	public String afterLogin(Model model) throws Exception {
		 try{
			 System.out.println("after login");
	    		model.addAttribute("user", cus.getSessionUser());
	    		}
	    		catch(Exception e){
	    			throw e;
	    }
		System.out.println("after login" + cus.getSessionUser().getEmail());
 		return "redirect:/welcome";
 	}
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // After user login successfully.
        String userName = principal.getName();
 
        System.out.println("User Name: "+ userName);
 
        return "userInfoPage";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
         
        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403Page";
    }
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
 		return "redirect:/welcome";
 	}
	
	@RequestMapping(value="/denied", method = RequestMethod.GET)
	public String error(Model model) {
 		return "redirect:/error-forbidden";
 	}*/
}
