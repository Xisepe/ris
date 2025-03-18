package ru.golubev.manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ManagerApplication

fun main(args: Array<String>) {
	runApplication<ManagerApplication>(*args)
}
