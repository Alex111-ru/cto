package com.example.confectionery.controller;

import com.example.confectionery.model.Owner;
import com.example.confectionery.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public String list(Model model) {
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "owner/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Owner owner) {
        ownerService.save(owner);
        return "redirect:/owners";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Owner owner = ownerService.findById(id);
        model.addAttribute("owner", owner);
        return "owner/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        ownerService.delete(id);
        return "redirect:/owners";
    }
}
