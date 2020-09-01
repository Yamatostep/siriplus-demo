package com.yamatos.demo.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Customers> listCustomers = service.listAll();
        model.addAttribute("listCustomers", listCustomers);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewCustomerPage(Model model) {
        Customers customer = new Customers();
        model.addAttribute("customer", customer);

        return "new_customer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customers customer) {
        customer.setTaxType(0);
        customer.setEmail(customer.getFirstName() + "@" + customer.getLastName() + ".com");
        customer.setTel("00000000000000");
        customer.setFax("00000000000000");
        customer.setCusCode("00000");
        customer.setOrdering(0);
        service.save(customer);

        return "redirect:/";
    }
}