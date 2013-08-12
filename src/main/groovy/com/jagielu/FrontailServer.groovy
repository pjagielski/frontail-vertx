package com.jagielu

import org.vertx.groovy.core.http.HttpServer
import org.vertx.groovy.core.http.HttpServerRequest
import org.vertx.groovy.core.http.RouteMatcher
import org.vertx.groovy.core.sockjs.SockJSServer
import org.vertx.groovy.platform.Verticle

class FrontailServer extends Verticle {

    def start() {
        int port = 9090
        HttpServer server = vertx.createHttpServer()

        def rm = new RouteMatcher()
        rm.get('/') {  HttpServerRequest req ->
            req.response.sendFile("web/index.html")
        }
        rm.getWithRegEx('.*') { HttpServerRequest req ->
            req.response.sendFile "web/${req.path}"
        }

        server.requestHandler(rm.asClosure())

        SockJSServer sjsServer = vertx.createSockJSServer(server)

        sjsServer.bridge([prefix: "/eventbus"], [[address: "buffer"]], [[address: "log"]])

        server.listen(port)

    }
}
