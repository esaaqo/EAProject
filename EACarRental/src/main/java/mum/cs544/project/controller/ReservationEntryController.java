package mum.cs544.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReservationEntryController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationEntryController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String createEmployee(Model model) {

		return "reserve";
	}
}
