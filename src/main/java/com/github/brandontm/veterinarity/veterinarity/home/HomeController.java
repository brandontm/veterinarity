package com.github.brandontm.veterinarity.veterinarity.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.brandontm.veterinarity.veterinarity.entity.Cliente;
import javax.servlet.ServletContext;

@Controller
public class HomeController {
    @Autowired
    ServletContext servletContext;

    @GetMapping("/")
    public String home() {
        List<Cliente> clientes = (List<Cliente>) servletContext.getAttribute("clientes");
        if (clientes == null)
            clientes = new ArrayList<Cliente>();

        servletContext.setAttribute("clientes", clientes);

        return "home";
    }

}