package me.ascat.demo.app.controller;

import me.ascat.demo.app.bean.User;
import me.ascat.demo.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wengyanghui@gmail.com
 */
@RestController
@RequestMapping("/rest")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = POST, produces = "application/json")
    public List<User> saveUser(@RequestBody(required = false) User user) {
        userService.insertService(user);
        return userService.selectAllUser();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public List<User> listUser(@RequestParam(required = false) String name) {
        if (StringUtils.isEmpty(name)) {
            return userService.selectAllUser();
        } else {
            return userService.selectUserByName(name);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public User finsUser(@PathVariable Long id) {
        return userService.selectUserById(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, produces = "application/json")
    public List<User> updateUser(@PathVariable Long id) {
        userService.updateUserById(id);
        return userService.selectAllUser();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public List<User> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return userService.selectAllUser();
    }
}