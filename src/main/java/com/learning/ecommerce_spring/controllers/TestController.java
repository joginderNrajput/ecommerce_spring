package com.learning.ecommerce_spring.controllers;

import com.flip.grpc.licensing.AllRolesResponse;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.learning.ecommerce_spring.grpc.client.RoleGrpcClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    private final RoleGrpcClient roleGrpcClient;

    public TestController(RoleGrpcClient roleGrpcClient){
        this.roleGrpcClient = roleGrpcClient;
    }

    @GetMapping("/grpc/roles")
    public ResponseEntity<String> getAllRoles() throws InvalidProtocolBufferException {
        AllRolesResponse response = roleGrpcClient.getAllRoles();
        String json = JsonFormat.printer().includingDefaultValueFields().print(response);
        return ResponseEntity.ok(json);
    }
}
