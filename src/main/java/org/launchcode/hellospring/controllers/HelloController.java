package org.launchcode.hellospring.controllers;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    //Handles request of the forms /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET,RequestMethod.POST} )
    public String hello(@RequestParam String name, Model model){
        String customGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", customGreeting);
        return "hello";
    }


    // Responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> nameList = new ArrayList<>();
        nameList.add("Reian");
        nameList.add("Rayji");
        nameList.add("Rayla");
        nameList.add("Renei");
        model.addAttribute("names", nameList);
        return "hello-list";
    }
}



