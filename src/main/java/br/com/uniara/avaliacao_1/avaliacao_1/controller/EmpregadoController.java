package br.com.uniara.avaliacao_1.avaliacao_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.uniara.avaliacao_1.avaliacao_1.model.Empregado;
import br.com.uniara.avaliacao_1.avaliacao_1.service.EmpregadoService;

@Controller
public class EmpregadoController {
	
	@Autowired
	private EmpregadoService empregadoService;
	
	@GetMapping("/")
	public String homePage(Model modelo) {
		modelo.addAttribute("listaEmpregados", empregadoService.getEmpregados());
		return "index";
	}
		
	@GetMapping("/adicionarEmpregado")
	public String adicionarEmpregado(Model modelo) {
		Empregado empregado = new Empregado();
		modelo.addAttribute("empregado", empregado);
		return "novoEmpregado";	
	}
	
	@PostMapping("/salvarEmpregado")
	public String salvarEmpregado(@ModelAttribute("empregado") Empregado empregado) {
		empregadoService.salvarEmpregado(empregado);
		return "redirect:/";	
	}
	
	@GetMapping("/atualizarEmpregado/{id}")
	public String atualizarEmpregado(@PathVariable (value = "id") long id, Model modelo) {
		Empregado empregado = empregadoService.getEmpregadoById(id);
		modelo.addAttribute("empregado", empregado);
		return "atualizarEmpregado";
	}
	
	@GetMapping("/apagarEmpregado/{id}")
		public String apagarEmpregado(@PathVariable (value = "id") long id) {
			this.empregadoService.apagarEmpregadoById(id);
			return "redirect:/";
	}
}
