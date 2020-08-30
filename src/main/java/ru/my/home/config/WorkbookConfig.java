package ru.my.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.my.home.workbook.Reader;
import ru.my.home.workbook.Writer;

@Configuration
public class WorkbookConfig {

    @Bean
    public Reader reader() {
        return new Reader();
    }

    @Bean
    public Writer writer() {
        return new Writer();
    }
}
