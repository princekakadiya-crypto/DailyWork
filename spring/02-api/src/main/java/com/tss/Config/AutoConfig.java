package com.tss.Config;

import com.tss.entity.Computer;
import com.tss.entity.Harddisk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfig {
    @Bean
    public Harddisk harddisk(){
        return new Harddisk();
    }

    @Bean
    public Computer computer(){
        return new Computer();
    }
}
