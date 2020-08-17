package com.example.demo.controller;

import com.example.demo.mapper.PostMapper;
import com.example.demo.model.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Controller, @Component, @Configuration, @Service, @Repository  --> bean으로 등록
// Model View Controller
@Controller
@RequestMapping("/board")
public class TestController {

    @Autowired
    PostMapper postMapper;

    @GetMapping("/read")
    public String Login(Model model) {

        // Map
        // {
        // "id" : "정미"
        // }
        // ** Model **
        // [
        //  data : {
        //          //key, value
        //          "id" : "정미"
        //          },
        //  hello : {
        //          "id" : "정미"
        //          }
        // ]

        List<POST> a = postMapper.getAll();

        // key("data"), value(a)
        model.addAttribute("data", a);
        return "Posts";
    }

    @GetMapping("/read/{postId}")
    public String read(Model model, @PathVariable("postId") int postId) {

        POST post = postMapper.getPost(postId);

        model.addAttribute("post", post);
        return "Post";
    }

    @PostMapping(value = "/create")
    public String create(Model model, @RequestParam("title") String title, @RequestParam("body") String body) {

        // System.out.println(title + " " + body);

        postMapper.insertData(title, body);

        return "redirect:/board/read";
    }

    @GetMapping("/delete/{postId}")
    public String delete(Model model, @PathVariable("postId") int postId) {

        postMapper.delData(postId);

        return "redirect:/board/read";
    }

    @GetMapping("/goUpdate/{postId}")
    public String goUpdate(Model model, @PathVariable("postId") int postId) {

        // postMapper.updateData(title, body, postId);
        POST post = postMapper.getPost(postId);

        model.addAttribute("post", post);

        return "Update";
    }

    @PostMapping("/update/{postId}")
    public String update(Model model, @RequestParam("title") String title, @RequestParam("body") String body, @PathVariable("postId") int postId) {

        postMapper.updateData(title, body, postId);

        return "redirect:/board/read/{postId}";


    }
}
