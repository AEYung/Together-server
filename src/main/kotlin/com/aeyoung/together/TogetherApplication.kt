package com.aeyoung.together

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class TogetherApplication

fun main(args: Array<String>) {
	runApplication<TogetherApplication>(*args)
}
