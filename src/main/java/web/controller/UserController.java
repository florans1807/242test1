package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceIn;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserServiceIn userService;

    @Autowired
    public UserController(UserServiceIn userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/user")
    public String getUserInfo(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "show";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "show";
    }

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("users", userService.getAll());
        return "obj";
    }


    @GetMapping("/admin/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.get(id));
        return "edit";
    }

    @PatchMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }


   /* @GetMapping("/")
    public String getInfoForAllEmp() {
        return "viewForAllEmp";
    }

    @GetMapping("/hr_info")
    public String getInfoForHR() {
        return "viewForHR";
    }

    @GetMapping("/manager_info")
    public String getInfoForManagers() {
        return "viewForManager";
    }*/

    /*@RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
*/
}

