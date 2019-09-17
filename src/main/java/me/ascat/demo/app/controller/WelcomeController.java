package me.ascat.demo.app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author wengyanghui@gmail.com
 */
@RestController
@RequestMapping("/")
@Slf4j
public class WelcomeController {

    private final static String welcomeLogo = "\n" +
            " _       __     __                             ______         _   _______ ______   __\n" +
            "| |     / /__  / /________  ____ ___  ___     /_  __/___     / | / / ___// ____/  / /\n" +
            "| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\     / / / __ \\   /  |/ /\\__ \\/ /_     / / \n" +
            "| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/    / / / /_/ /  / /|  /___/ / __/    /_/  \n" +
            "|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/    /_/  \\____/  /_/ |_//____/_/      (_)   \n" +
            "                                                                                     \n";

    @RequestMapping(value = "/", method = GET, produces = "application/json")
    public String saveUser() {
        return welcomeLogo;
    }
}
