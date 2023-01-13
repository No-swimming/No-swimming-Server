package com.example.noswimmingserver.infra.feign.config

import com.example.noswimmingserver.infra.feign.error.FeignClientErrorDecoder
import feign.codec.ErrorDecoder
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@EnableFeignClients(basePackages = ["com.example.noswimmingserver.infra.feign"])
@Import(FeignClientErrorDecoder::class)
@Configuration
class FeignConfig {

    @Bean
    @ConditionalOnMissingBean(value = [ErrorDecoder::class])
    fun feignErrorDecoder(): FeignClientErrorDecoder {
        return FeignClientErrorDecoder()
    }

}