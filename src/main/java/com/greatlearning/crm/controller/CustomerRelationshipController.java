package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crm.entity.Customer;
import com.greatlearning.crm.service.CustomerRelationshipService;

@Controller
@RequestMapping("/")
public class CustomerRelationshipController {

	@Autowired
	CustomerRelationshipService customerRelationshipService;

	@RequestMapping("/")
	public String display() {

		return "redirect:/list";
	}

	@RequestMapping("/list")
	public String listCustomers(Model model) {

		List<Customer> customers = customerRelationshipService.findAll();
		model.addAttribute("Customers", customers);

		return "customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Customer customer = new Customer();
		model.addAttribute("Customer", customer);

		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

		Customer customer = customerRelationshipService.findById(id);
		model.addAttribute("Customer", customer);

		return "customer-form";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {

		customerRelationshipService.deleteById(id);

		return "redirect:/list";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println(id);
		Customer customer;

		if (id != 0) {
			customer = customerRelationshipService.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		} else {

			customer = new Customer(firstName, lastName, email);
		}

		customerRelationshipService.save(customer);

		return "redirect:/list";
	}
}
