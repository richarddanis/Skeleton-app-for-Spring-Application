package com.richard.danis.www.sandbox.data.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class InitSupport {

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }
}
