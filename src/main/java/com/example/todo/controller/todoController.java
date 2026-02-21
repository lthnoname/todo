package com.example.todo.controller;

import com.example.todo.model.todoModel;
import com.example.todo.repository.todoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class todoController {
    private final todoRepository repository;
    public todoController(todoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", repository.findAll());
        return "index";
    }
    @PostMapping("/add")
    public String add(@RequestParam String title) {
        repository.save(new todoModel(title));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
