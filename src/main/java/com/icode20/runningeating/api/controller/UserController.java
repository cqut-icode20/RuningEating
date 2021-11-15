package com.icode20.runningeating.api.controller;

import com.icode20.runningeating.api.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author
 * description
 *
 * @date 2021/10/29 20:37
 */
@RestController
public class UserController extends BaseController<UserService> {
    @Autowired
    UserService userService;

    @Override
    public UserService attachService() {
        return userService;
    }

    @GetMapping("user")
    @Override
    String searchById(String id) {
        return super.searchById(id);
    }

    @PostMapping("user/add")
    String add(@RequestBody String goodJsons) {
        return super.add(goodJsons);
    }

    @GetMapping("user/keys")
    @Override
    String searchByKeys(@RequestParam("bluer") String bluer, Integer startIndex, Integer endIndex) {
        return super.searchByKeys(bluer, startIndex, endIndex);
    }

    @GetMapping("user/bluer/count")
    public String bluerCount(String bluer) {
        return super.bluerCount(bluer);
    }

    @PostMapping("user/update")
    @Override
    String update(@RequestBody String Tjson) {
        return super.update(Tjson);
    }

    @GetMapping("user/delete")
    @Override
    String delete(String id) {
        return super.delete(id);
    }

    @GetMapping("user/all")
    @Override
    String getAll() {
        return super.getAll();
    }

    @GetMapping("user/limit")
    @Override
    String getLimit(int startIndex, int endIndex) {
        return super.getLimit(startIndex, endIndex);
    }

    @GetMapping("user/all/count")
    @Override
    String count() {
        return super.count();
    }
}
