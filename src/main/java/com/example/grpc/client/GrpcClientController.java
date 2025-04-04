package com.example.grpc.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    // Endpoint to trigger the gRPC call from the client
    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam String message) {
        // Call the GrpcClientService to send a message to the server
        return grpcClientService.sendMessage(message);
    }
}
