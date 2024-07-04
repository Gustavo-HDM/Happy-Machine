package com.happy.happymachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TelasController {

	@GetMapping("/home")
	public String homePage() {
		return "Home";
	}
	
	@GetMapping("/usuario/cadastro")
	public String cadastroUsuario(){
		return "CadastroUsuario";
	}
	
}
