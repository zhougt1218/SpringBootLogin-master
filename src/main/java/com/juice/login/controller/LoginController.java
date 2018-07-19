package com.juice.login.controller;

import com.juice.login.entity.Role;
import com.juice.login.entity.User;
import com.juice.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {


//        System.out.println("我的名称："+userService.findUserByUserAccount("admin").getName());
////        System.out.println("我的权限："+);
//        for (Role role:userService.findUserByUserAccount("admin").getRoles()){
//
//            System.out.println("ID："+role.getId());
//            System.out.println("角色："+role.getRole());
//        }



        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");


        return modelAndView;
    }



//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public ModelAndView registration() {
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByEmail(user.getUserAccount());
//        if (userExists != null) {
//            bindingResult.rejectValue("email", "error.user",
//                    "There is already a user registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("registration");
//        } else {
//            userService.saveUser(user, "CLIENT");
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("user", new User());
//            modelAndView.setViewName("registration");
//
//        }
//        return modelAndView;
//    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        User user = userService.findUserByUserAccount(auth.getName());
        modelAndView.addObject("userName",
                "Welcome " + user.getName() + " " + user.getUserAccount() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

//    @RequestMapping(value = "/admin/home", method = RequestMethod.POST)
//    public ModelAndView createNewUserByAdmin(
//            @Valid User user, BindingResult bindingResult) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByUserAccount(user.getUserAccount());
//        if (userExists != null) {
//            bindingResult.rejectValue("email", "error.user",
//                    "There is already a user registered " +
//                            "with the email provided");
//        } else {
//            userService.saveUser(user, "admin");
//        }
//
//        return modelAndView;
//
//    }


}
