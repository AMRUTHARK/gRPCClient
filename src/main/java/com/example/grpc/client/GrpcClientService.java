package com.example.grpc.client;

import com.example.grpc.MessageRequest;
import com.example.grpc.MessageResponse;
import com.example.grpc.MessageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    private final ManagedChannel channel;
    private final MessageServiceGrpc.MessageServiceBlockingStub blockingStub;

    public GrpcClientService() {
        // Create a channel and a stub to call the server
        this.channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()  // Disable TLS
                .build();
        this.blockingStub = MessageServiceGrpc.newBlockingStub(channel);
    }

    public String sendMessage(String message) {
        // Prepare the request
        MessageRequest request = MessageRequest.newBuilder().setMessage(message).build();

        // Call the server method using the stub
        MessageResponse response = blockingStub.sendMessage(request);

        return response.getResponse();
    }
}
