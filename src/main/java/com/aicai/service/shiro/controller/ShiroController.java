package com.aicai.service.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class ShiroController {
    @RequestMapping("/user.htm")
    @RequiresPermissions("user:create")
    @ResponseBody
    public String needPermisson() {
        return "拥有权限user:create";
    }
    @RequestMapping("/userJsp.htm")
    @RequiresPermissions("user:create")
    public String needPermissonJsp() {
        return "test/test";
    }
}
