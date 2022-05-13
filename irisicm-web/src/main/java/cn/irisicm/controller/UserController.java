package cn.irisicm.controller;

import cn.irisicm.dto.result.MsgKey;
import cn.irisicm.dto.result.PageInfo;
import cn.irisicm.dto.result.Result;
import cn.irisicm.dto.search.UserSearch;
import cn.irisicm.entity.User;
import cn.irisicm.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hmhu6
 */
@Api(tags = {"用户信息控制层"})
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public Result<User> getUser() {
        try {
            User user = userService.getById(1);
            return new Result<>(MsgKey.SUCCESS_OPERATION, user);
        } catch (Exception e) {
            log.error("getUser() 获取用户信息失败！", e);
            return new Result<>(MsgKey.ERROR_SERVER_EXCEPTION);
        }
    }

    @GetMapping("/findAllUser")
    public Result<List<User>> findAllUser() {
        try {
            List<User> userList = userService.findAllUser();
            return new Result<>(MsgKey.SUCCESS_OPERATION, userList);
        } catch (Exception e) {
            log.error("findAllUser() 获取用户信息失败！", e);
            return new Result<>(MsgKey.ERROR_SERVER_EXCEPTION);
        }
    }

    @PostMapping("/getUserInfo")
    public Result<PageInfo<User>> getUserInfo(@RequestBody UserSearch userSearch) {
        try {
            PageInfo<User> pager = userService.getUserInfo(userSearch);
            return new Result<>(MsgKey.SUCCESS_OPERATION, pager);
        } catch (Exception e) {
            log.error("getUserInfo() 获取用户信息列表失败！UserSearch:{}", userSearch, e);
            return new Result<>(MsgKey.ERROR_SERVER_EXCEPTION);
        }
    }

    @GetMapping("/login")
    public Result<String> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        try {
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                return new Result<>(MsgKey.ERROR_INCOMPLETE_LOGIN_INFO);
            }
            String token = userService.login(username, password);
            if (StringUtils.isNotEmpty(token)) {
                return new Result<>(MsgKey.SUCCESS_OPERATION, token);
            } else {
                return new Result<>(MsgKey.ERROR_PSW_OR_ACCOUNT);
            }
        } catch (Exception e) {
            log.error("login() 登录失败！", e);
            return new Result<>(MsgKey.ERROR_SERVER_EXCEPTION);
        }
    }

}
