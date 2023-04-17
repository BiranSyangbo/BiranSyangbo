//package com.bs.socket.rsocket;
//
//import io.rsocket.ConnectionSetupPayload;
//import io.rsocket.RSocket;
//import io.rsocket.SocketAcceptor;
//import reactor.core.publisher.Mono;
//
//public class PingHandler implements AbstractRSocket {
//    @Override
//    public Mono<RSocket> accept(ConnectionSetupPayload connectionSetupPayload, RSocket rSocket) {
//        return Mono.just(rSocket);
//    }
//}
