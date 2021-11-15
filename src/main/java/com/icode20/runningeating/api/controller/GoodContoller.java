package com.icode20.runningeating.api.controller;

import com.icode20.runningeating.api.service.impl.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodContoller extends BaseController<GoodService> {

    @Autowired
    GoodService goodService;

    @Override
    public GoodService attachService() {
        return goodService;
    }

    @GetMapping("good")
    @Override
    String searchById(String id) {
        return super.searchById(id);
    }

    @PostMapping("good/add")
    String add(@RequestBody String goodJsons) {
        return super.add(goodJsons);
    }

    @GetMapping("good/keys")
    @Override
    String searchByKeys(@RequestParam("bluer") String bluer, Integer startIndex, Integer endIndex) {
        return super.searchByKeys(bluer, startIndex, endIndex);
    }

    @GetMapping("good/bluer/count")
    @Override
    public String bluerCount(String bluer) {
        return super.bluerCount(bluer);
    }

    @PostMapping("good/update")
    @Override
    String update(@RequestBody String Tjson) {
        return super.update(Tjson);
    }

    @GetMapping("good/delete")
    @Override
    String delete(String id) {
        return super.delete(id);
    }

    @GetMapping("good/all")
    @Override
    String getAll() {
        return super.getAll();
    }

    @GetMapping("good/limit")
    @Override
    String getLimit(int startIndex, int endIndex) {
        return super.getLimit(startIndex, endIndex);
    }

    @GetMapping("good/all/count")
    @Override
    String count() {
        return super.count();
    }
}
