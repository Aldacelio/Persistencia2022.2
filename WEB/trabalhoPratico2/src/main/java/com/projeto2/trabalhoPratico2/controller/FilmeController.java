package com.projeto2.trabalhoPratico2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto2.trabalhoPratico2.dao.FilmeDAO;
import com.projeto2.trabalhoPratico2.models.Filme;

@Controller
public class FilmeController {
    
    @Autowired
    private FilmeDAO fd;

    @RequestMapping(value="/cadastrarFilme", method=RequestMethod.GET)
    public String form(){
        return "filme/formFilme";
    }
    
    @RequestMapping(value = "/cadastrarFilme", method = RequestMethod.POST)
    public String form(Filme f){
        fd.save(f);
        return "redirect:/cadastrarFilme";
    }
}
