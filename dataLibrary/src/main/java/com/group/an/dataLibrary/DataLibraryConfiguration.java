package com.group.an.dataLibrary;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@EnableAutoConfiguration
@SpringBootConfiguration
@PropertySource(value = "classpath:data.properties")
public class DataLibraryConfiguration {
}
