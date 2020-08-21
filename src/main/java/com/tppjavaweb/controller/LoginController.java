package com.tppjavaweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tppjavaweb.model.Usuario;
import com.tppjavaweb.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login2");
        return modelAndView;
    }
    
    @GetMapping(value="/logout")
    public String logout(){
        return "redirect:login";
    }


    @GetMapping(value="/cadastro")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Usuario user = new Usuario();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("cadastro");
        return modelAndView;
    }

    @PostMapping(value = "/cadastro")
    public ModelAndView createNewUser(@Valid  @ModelAttribute("user") Usuario user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Usuario userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.email",
                            "Já existe um usuário registrado com o email fornecido");
        }
        if (!user.getSenha().equals(user.getConfirmaSenha())) {
            bindingResult
                    .rejectValue("confirmaSenha", "error.confirmaSenha",
                            "As senhas não correspondem");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("cadastro");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Usuário registrado com sucesso");
            modelAndView.addObject("user", new Usuario());
            modelAndView.setViewName("cadastro");

        }
        return modelAndView;
    }

}
