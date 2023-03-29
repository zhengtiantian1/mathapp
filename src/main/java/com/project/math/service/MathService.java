package com.project.math.service;


import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


/**
 * @description:
 * @author:Xi Zheng
 * @createTime:2023/3/28 1:45
 * @version:1.0
 */
@Service
public class MathService {

    public List<Double> getMinNumber(List<Double> numbers, Integer quantifier) {
        if (isListEmpty(numbers) || inValidInt(quantifier)) {
            return new ArrayList<>();
        }

        Collections.sort(numbers);

        if (quantifier > numbers.size()) {
            return numbers;
        }

        return numbers.subList(0, quantifier);
    }

    public List<Double> getMaxNumber(List<Double> numbers, Integer quantifier) {
        if (isListEmpty(numbers) || inValidInt(quantifier)) {
            return new ArrayList<>();
        }

        Collections.sort(numbers);

        if (quantifier > numbers.size()) {
            return numbers;
        }

        return numbers.subList(numbers.size() - quantifier, numbers.size());
    }

    public Double getAvgNumber(List<Double> numbers) {

        if (isListEmpty(numbers)) {
            return null;
        }

        return numbers.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    public Double getMedianNumber(List<Double> numbers) {

        if (isListEmpty(numbers)) {
            return null;
        }

        Collections.sort(numbers);
        int size = numbers.size();
        if (numbers.size() % 2 == 0) {
            return (numbers.get(size / 2) + numbers.get(size / 2 + 1)) / 2;
        } else {
            return numbers.get(size / 2);
        }

    }

    public Double getQthPercentileNumber(List<Double> numbers, Double quantifier) {
        if (isListEmpty(numbers)) {
            return null;
        }

        if (quantifier == null || quantifier < 0 || quantifier > 1) {
            return null;
        }

        return numbers.get((int) (quantifier * numbers.size()));
    }


    public boolean isListEmpty(List<?> list) {
        if (list == null || list.size() <= 0) {
            return true;
        }
        return false;
    }


    public boolean inValidInt(Integer i) {
        if (i == null || i <= 0) {
            return true;
        }
        return false;
    }


}
