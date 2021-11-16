package com.icode20.runningeating.api.controller;

import com.icode20.runningeating.api.service.impl.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController extends BaseController<MessageService> {

    @Autowired
    MessageService service;

    @Override
    public MessageService attachService() {
        return service;
    }
    
    @GetMapping("message")
    @Override
    String searchById(String id) {
        return super.searchById(id);
    }

    @PostMapping("message/post")
    String add(@RequestBody String messageJsons) {
        return super.add(messageJsons);
    }

    @GetMapping("message/keys")
    @Override
    String searchByKeys(@RequestParam("bluer") String bluer, Integer startIndex, Integer endIndex) {
        return super.searchByKeys(bluer, startIndex, endIndex);
    }

    @GetMapping("message/bluer/count")
    @Override
    public String bluerCount(String bluer) {
        return super.bluerCount(bluer);
    }

    @PostMapping("message/update")
    @Override
    String update(@RequestBody String Tjson) {
        return super.update(Tjson);
    }

    @GetMapping("message/delete")
    @Override
    String delete(String id) {
        return super.delete(id);
    }

    @GetMapping("message/all")
    @Override
    String getAll() {
        return super.getAll();
    }

    @GetMapping("message/limit")
    @Override
    String getLimit(int startIndex, int endIndex) {
        return super.getLimit(startIndex, endIndex);
    }

    @GetMapping("message/all/count")
    @Override
    String count() {
        return super.count();
    }
}
