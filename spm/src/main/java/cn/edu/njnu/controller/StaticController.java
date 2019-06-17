package cn.edu.njnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class")
public class StaticController {

    @RequestMapping("/class_info")
    public String class_info() {
        return "class/class_info";
    }

    @RequestMapping("/class_content")
    public String class_content() {
        return "class/class_content";
    }

    @RequestMapping("/class_practice")
    public String class_practice() {
        return "class/class_practice";
    }

    @RequestMapping("/class_team")
    public String class_team() {
        return "class/class_team";
    }

    @RequestMapping("/class_work")
    public String class_work() {
        return "class/class_work";
    }

    @RequestMapping("/class_contact")
    public String class_contact() {
        return "class/class_contact";
    }

}
