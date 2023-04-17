package com.bs.socket.rsocket;

import io.rsocket.core.RSocketServer;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.Disposable;

public class RSocketServerTest {
    private final Disposable server;

    public RSocketServerTest() {
        this.server = (Disposable) RSocketServer.create()
                .payloadDecoder(PayloadDecoder.ZERO_COPY)
                .bind(TcpServerTransport.create(7878))
                .block();
    }

    public void disposal() {
        this.server.dispose();
    }
}
