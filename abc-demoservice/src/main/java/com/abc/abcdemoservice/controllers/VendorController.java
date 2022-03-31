package com.abc.abcdemoservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorController
{
    @GetMapping("/total")
    public List vendors()
    {
        List list = new ArrayList<>();
        list.add("CJI Consultants");
        list.add("Signature Consultants");
        list.add("Deloitte");
        return list;
    }
}