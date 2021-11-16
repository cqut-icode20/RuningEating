package com.icode20.runningeating.api.controller;

import com.icode20.runningeating.api.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author
 * description
 *
 * @date 2021/10/29 20:37
 */
@RestController
public class OrderController extends BaseController<OrderService> {
    @Autowired
    OrderService orderService;

    @Override
    public OrderService attachService() {
        return orderService;
    }

    @GetMapping("order")
    @Override
    String searchById(String id) {
        return super.searchById(id);
    }

    @PostMapping("order/post")
    String add(@RequestBody String goodJsons) {
        return super.add(goodJsons);
    }

    @GetMapping("order/keys")
    @Override
    String searchByKeys(@RequestParam("bluer") String bluer, Integer startIndex, Integer endIndex) {
        return super.searchByKeys(bluer, startIndex, endIndex);
    }

    @GetMapping("order/bluer/count")
    @Override
    public String bluerCount(String bluer) {
        return super.bluerCount(bluer);
    }

    @PostMapping("order/update")
    @Override
    String update(@RequestBody String Tjson) {
        return super.update(Tjson);
    }

    @GetMapping("order/delete")
    @Override
    String delete(String id) {
        return super.delete(id);
    }

    @GetMapping("order/all")
    @Override
    String getAll() {
        return super.getAll();
    }

    @GetMapping("order/limit")
    @Override
    String getLimit(int startIndex, int endIndex) {
        return super.getLimit(startIndex, endIndex);
    }

    @GetMapping("order/all/count")
    @Override
    String count() {
        return super.count();
    }
}
