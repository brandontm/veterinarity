package com.github.brandontm.veterinarity.veterinarity.pacientes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.ServletContext;

import com.github.brandontm.veterinarity.veterinarity.entity.Cliente;
import com.github.brandontm.veterinarity.veterinarity.entity.Pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PacientesController {
    @Autowired
    ServletContext servletContext;

    @GetMapping("/pacientes")
    public String pacientes() {
        if (servletContext.getAttribute("pets") == null)
            servletContext.setAttribute("pets", new ArrayList<Pet>());

        return "pacientes";
    }

    @GetMapping("/paciente/agregar")
    public String agregarPacienteForm(Model model) {
        Pet pet = new Pet();
        pet.setSex("macho");
        model.addAttribute("pet", pet);

        return "agregar_paciente";
    }

    @PostMapping("/paciente/agregar")
    public String agregarPaciente(@ModelAttribute(value = "pet") Pet pet, @RequestParam("idCliente") int idCliente) {
        List<Pet> pets = (List<Pet>) servletContext.getAttribute("pets");
        if (pets == null)
            pets = new ArrayList<Pet>();

        int id = pets.stream().flatMapToInt(p -> IntStream.of(p.getId())).max().orElse(0) + 1; // get next id
        pet.setId(id);
        pets.add(pet);
        servletContext.setAttribute("pets", pets);

        List<Cliente> clientes = (List<Cliente>) servletContext.getAttribute("clientes");
        if (clientes == null)
            clientes = new ArrayList<Cliente>();

        for (int i = 0; i < clientes.size(); i++) {
            final Cliente c = clientes.get(i);
            if (c.getId() != idCliente)
                continue;

            List<Pet> petList = c.getPets();
            petList.add(pet);
            c.setPets(petList);

            clientes.set(i, c);
            servletContext.setAttribute("clientes", clientes);
        }
        return "agregar_paciente";
    }
}
