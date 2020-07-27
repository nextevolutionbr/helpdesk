package br.com.nextevolution.Helpdesk;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;

public class WebConfig{

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
