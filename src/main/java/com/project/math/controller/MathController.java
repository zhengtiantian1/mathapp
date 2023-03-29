package com.project.math.controller;

import com.project.math.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description:
 * @author:Xi Zheng
 * @createTime:2023/3/28 1:36
 * @version:1.0
 */
@RestController
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping(value = "/min")
    @ResponseBody
    public List<Double> getMinNumber(@RequestParam List<Double> numbers, @RequestParam Integer quantifier) {
        return mathService.getMinNumber(numbers, quantifier);
    }

    @GetMapping(value = "/max")
    @ResponseBody
    public List<Double> getMaxNumber(@RequestParam List<Double> numbers, @RequestParam Integer quantifier) {
        return mathService.getMaxNumber(numbers, quantifier);
    }

    @GetMapping(value = "/avg")
    @ResponseBody
    public Double getAvgNumber(@RequestParam List<Double> numbers) {
        return mathService.getAvgNumber(numbers);
    }

    @GetMapping(value = "/median")
    @ResponseBody
    public Double getMedianNumber(@RequestParam List<Double> numbers) {
        return mathService.getMedianNumber(numbers);
    }

    @GetMapping(value = "/percentile")
    @ResponseBody
    public Double getQthPercentile(@RequestParam List<Double> numbers, @RequestParam Double quantifier) {
        return mathService.getQthPercentileNumber(numbers, quantifier);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "hallo world!";
    }
}
