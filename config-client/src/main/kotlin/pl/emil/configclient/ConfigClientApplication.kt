package pl.emil.configclient

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.ConfigurableEnvironment

@SpringBootApplication
class ConfigClientApplication(
    @Autowired
    private val env: ConfigurableEnvironment
) {
    @Bean
    fun profiler() = env.setActiveProfiles("dev")
}


fun main(args: Array<String>) {

    runApplication<ConfigClientApplication>(*args)
}

