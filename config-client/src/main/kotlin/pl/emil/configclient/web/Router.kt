package pl.emil.configclient.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router
import pl.emil.configclient.config.DbConfig

@Configuration
class Router(
    @Value("\${greeting}")
    private val greeting: String
) {

    @Bean
    fun routes(
        dbConfig: DbConfig
    ) = router {
        "api".nest {
            "welcome".nest {
                GET {
                    ok().bodyValue("${greeting}: ${dbConfig.connection}:${dbConfig.host}:${dbConfig.port}")
                }
            }
        }
    }
}