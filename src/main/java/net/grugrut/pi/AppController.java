package net.grugrut.pi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	@GetMapping("/view")
	public String viewResult(@RequestParam("count")String cnt, Model model) {
		
		String result = PiUtil.calc(cnt);
		
		model.addAttribute("result", result);
		
		return "viewResult";
	}
}
