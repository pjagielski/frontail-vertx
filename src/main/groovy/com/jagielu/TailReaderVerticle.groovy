package com.jagielu

import org.vertx.groovy.platform.Verticle
import org.vertx.groovy.core.eventbus.Message

class TailReaderVerticle extends Verticle {

    def buffer = []

    @Override
    def start() {

        def file = System.getProperty('file')
        if (!file) {
            throw new IllegalArgumentException("Please specify log file by adding -Dfile=xxx")
        }

        vertx.eventBus.registerHandler("buffer", { Message message ->
            message.reply buffer.join("\n")
        })

        Thread.start {
            def proc = "tail -f $file".execute()
            proc.in.newReader().eachLine { line ->
                buffer << line
                vertx.eventBus.publish("log", line)
            }
        }

    }

}