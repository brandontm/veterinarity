package com.github.brandontm.veterinarity.veterinarity.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.brandontm.veterinarity.veterinarity.entity.Consulta;

@Controller
public class ConsultasController {
    @Autowired
    ServletContext servletContext;

	@GetMapping("/consulta")
	public String consultas() {
        List<Consulta> consultas = (List<Consulta>) servletContext.getAttribute("consultas");
        if (consultas == null)
            consultas = new ArrayList<Consulta>();
        

        servletContext.setAttribute("consultas", consultas);

		return "consultas";
    }
    
    @GetMapping("/consulta/agregar")
    public String agregarConsultaForm(Model model) {
        model.addAttribute("consulta", new Consulta());
        return "agregar_consulta";
	}
	
	@PostMapping("/consulta/agregar")
    public String agregarConsulta(@ModelAttribute(value = "consulta") Consulta consulta) {
        List<Consulta> consultas = (List<Consulta>) servletContext.getAttribute("consultas");
        if (consultas == null)
            consultas = new ArrayList<Consulta>();
        
        

        consultas.add(consulta);
        servletContext.setAttribute("consultas", consultas);
        return "agregar_consulta";
    }
}
