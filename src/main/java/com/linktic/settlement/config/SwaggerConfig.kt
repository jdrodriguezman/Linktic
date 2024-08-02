package com.linktic.settlement.config
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration open class SwaggerConfig {
    @Bean open fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder() .group("public")
            .packagesToScan("com.linktic.settlement.controller")
            .build()
    }
}