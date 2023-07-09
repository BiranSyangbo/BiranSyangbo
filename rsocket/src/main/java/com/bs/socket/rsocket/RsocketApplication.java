package com.bs.socket.rsocket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
object RsocketApplication {
//    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(RsocketApplication::class.java, *args)
    }
}