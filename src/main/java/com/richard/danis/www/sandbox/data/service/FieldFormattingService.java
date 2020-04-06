package com.richard.danis.www.sandbox.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FieldFormattingService {

    private final Logger LOGGER = LoggerFactory.getLogger(FieldFormattingService.class);
    private ConversionService conversionService;

    public FieldFormattingService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public void convert(String number) {
        Integer integerNumber = conversionService.convert(number, Integer.class);
        Long longNumber = conversionService.convert(integerNumber, Long.class);
        LOGGER.info("Convert a given input: {} for Integer: {}, and Long: {}", number, integerNumber, longNumber);
    }

    @PostConstruct
    private void justRun() {
        convert("5");
    }
}
