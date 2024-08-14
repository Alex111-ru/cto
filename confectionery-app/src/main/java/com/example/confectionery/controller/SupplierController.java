package com.example.confectionery.controller;

import com.example.confectionery.model.Supplier;
import com.example.confectionery.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public String list(Model model) {
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        return "supplier/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "supplier/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
