package com.springzbuta.springboot.controllers;

import com.springzbuta.springboot.models.Palindrome;
import com.springzbuta.springboot.repositories.PalindromeRepository;
import com.springzbuta.springboot.services.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;

	@Autowired
	private PalindromeRepository pr;

	@GetMapping(path = "/hello", params = "text")
//	@ResponseBody
	String home(@RequestParam("text") String newText, Model model) {
		Palindrome p = new Palindrome(newText);
		pr.save(p);


		System.out.println(palindromeService.getResult(newText));
		model.addAttribute("myResult", palindromeService.getResult(newText));
		return "helloSpring";
	}

	@GetMapping(path = "/list")
	String list(Model model){
		model.addAttribute("pal", pr.findAll());
		return "list";
	}
}
