package com.example.confectionery.controller;

import com.example.confectionery.model.CandyType;
import com.example.confectionery.service.CandyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/candy-types")
public class CandyTypeController {

    @Autowired
    private CandyTypeService candyTypeService;

    @GetMapping
    public String list(Model model) {
        List<CandyType> candyTypes = candyTypeService.findAll();
        model.addAttribute("candyTypes", candyTypes);
        return "candyType/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("candyType", new CandyType());
        return "candyType/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute CandyType candyType) {
        candyTypeService.save(candyType);
        return "redirect:/candy-types";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        CandyType candyType = candyTypeService.findById(id);
        model.addAttribute("candyType", candyType);
        return "candyType/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        candyTypeService.delete(id);
        return "redirect:/candy-types";
    }
}
