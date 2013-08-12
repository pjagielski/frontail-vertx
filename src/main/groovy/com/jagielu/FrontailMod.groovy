package com.jagielu

import org.vertx.groovy.platform.Verticle

class FrontailMod extends Verticle {

    def start() {
        container.deployVerticle('groovy:com.jagielu.TailReaderVerticle')
        container.deployVerticle('groovy:com.jagielu.FrontailServer')
    }
}
