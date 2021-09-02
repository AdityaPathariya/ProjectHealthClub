package com.adi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.adi.Controllers","com.adi.Services","com.adi.Repository"})
public class ControllersConfig {

}
