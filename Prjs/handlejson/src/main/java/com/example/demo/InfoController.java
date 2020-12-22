package com.example.demo;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private IInfoRepository infoRepo;

    /*@GetMapping("/get")
    public Response read(@RequestParam(required = false) Long id) {
        List<Info> list;
        if (null == id) {
            list = infoRepo.findAll();
        } else {
            list = Collections.singletonList(infoRepo.findById(id).get());
        }

        Response response = new Response();
        response.setData(list);

        return response;

    }*/
    @GetMapping("/get")
    public Map<String, Object> read(@RequestParam(required = false) Long id) {
        List<Info> list;
        if (null == id) {
            list = infoRepo.findAll();
        } else {
            list = Collections.singletonList(infoRepo.findById(id).get());
        }

        Map<String, Object> response = new HashMap<>();
        response.put("code", "SUCCESS.READ.<NAME OF FEATURE>");
        response.put("mesage", "Read <Name Of Feature> successful");
        response.put("<NAME OF FEATURE>RS", list);

        return response;
    }
}
