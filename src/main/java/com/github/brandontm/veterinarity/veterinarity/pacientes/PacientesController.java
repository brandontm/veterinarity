package com.github.brandontm.veterinarity.veterinarity.pacientes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.github.brandontm.veterinarity.veterinarity.entity.Pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacientesController {
    @Autowired
    ServletContext servletContext;

    @GetMapping("/pacientes")
    public String pacientes() {
        return "pacientes";
    }

    @GetMapping("/paciente/agregar")
    public String agregarPacienteForm(Model model) {
        Pet pet = new Pet();
        pet.setSex("male");
        model.addAttribute("pet", pet);
        
        return "agregar_paciente";
    }

    @PostMapping("/paciente/agregar")
    public String agregarPaciente(@ModelAttribute(value = "pet") Pet pet) {
        List<Pet> pets = (List<Pet>) servletContext.getAttribute("pets");
        if (pets == null)
            pets = new ArrayList<Pet>();

        pets.add(pet);
        servletContext.setAttribute("pets", pets);
        return "agregar_paciente";
    }
}
