package com.lilin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lilin.pojo.User;
import com.lilin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("manage/user")
public class UserController {

    private UserService userService;
    private ObjectMapper objectMapper;

    @Autowired
    UserController(UserService userService, ObjectMapper objectMapper){
        this.userService = userService;
        this.objectMapper =objectMapper;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String manage(){
        return "manage";
    }

    @ResponseBody
    @RequestMapping(value = "select", method = RequestMethod.GET)
    public String select (int id) throws JsonProcessingException{
        User user = userService.selectUserById(id);
        return objectMapper.writeValueAsString(user);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(int id){
        userService.delete(id);
        return "redirect:.";
    }

    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(String userName, String password){
        userService.insert(userName, password);
        return "redirect:.";
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String update(int id, String userName, String password) {
        userService.update(id, userName, password);
        return "redirect:.";
    }

    @ResponseBody
    @RequestMapping(value = "getData",method = RequestMethod.GET)
    public String test() throws JsonProcessingException{
        List<User> users = userService.userList();
        return objectMapper.writeValueAsString(users);
    }
}
