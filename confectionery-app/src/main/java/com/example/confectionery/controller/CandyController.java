package com.example.confectionery.controller;

import com.example.confectionery.model.Candy;
import com.example.confectionery.service.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/candies")
public class CandyController {

    @Autowired
    private CandyService candyService;

    @GetMapping
    public String list(Model model) {
        List<Candy> candies = candyService.findAll();
        model.addAttribute("candies", candies);
        return "candy/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("candy", new Candy());
        return "candy/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Candy candy) {
        candyService.save(candy);
        return "redirect:/candies";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Candy candy = candyService.findById(id);
        model.addAttribute("candy", candy);
        return "candy/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        candyService.delete(id);
        return "redirect:/candies";
    }
}