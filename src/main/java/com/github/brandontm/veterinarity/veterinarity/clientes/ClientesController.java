package com.github.brandontm.veterinarity.veterinarity.clientes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.brandontm.veterinarity.veterinarity.entity.Cliente;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.ServletContext;

@Controller
public class ClientesController {
	@Autowired
    ServletContext servletContext;

	@GetMapping("/cliente")
	public String clientes() {
		return "clientes";
	}

	@GetMapping("/cliente/agregar")
    public String agregarPacienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "agregar_cliente";
	}
	
	@PostMapping("/cliente/agregar")
    public String agregarPaciente(@ModelAttribute(value = "cliente") Cliente cliente) {
        List<Cliente> clientes = (List<Cliente>) servletContext.getAttribute("cliente");
        if (clientes == null)
            clientes = new ArrayList<Cliente>();
        
        

		clientes.add(cliente);
        servletContext.setAttribute("clientes", clientes);
        return "agregar_cliente";
    }

}