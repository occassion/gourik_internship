package com.project.internship.controller;

import com.project.internship.business.SoftwareOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SoftwarePurchaseController {
@Autowired
private SoftwareOrderService orderService;
    @GetMapping("/total_items")
    public
    String getTotalItems(@RequestParam String startDate, @RequestParam String endDate, @RequestParam String department){
        return orderService.getTotalItems(startDate,endDate,department);

    }
    @GetMapping("/nth_most_total_item")
    public
    String getNthMostTotalItem(@RequestParam String quantity,@RequestParam String price,@RequestParam String startDate,@RequestParam String endDate){
        return orderService.getNthMostTotalItem(quantity,price,startDate,endDate);

    }
    @GetMapping("/percentage_of_department_wise_sold_items")
    public
    String getPercentDepartmntWiseSoldItem(@RequestParam String startDate,@RequestParam String endDate){
        return orderService.getPercentDepartmntWiseSoldItem(startDate,endDate);

    }
    @GetMapping("/monthly_sales")
    public
    String getMonthlySales(@RequestParam String product,@RequestParam String year){
        return orderService.getMonthlySales(product,year);

    }
}
