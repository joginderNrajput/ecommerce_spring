package com.learning.fake_store.grpc.client;

import com.flip.grpc.licensing.AllRolesResponse;
import com.flip.grpc.licensing.RoleServiceGrpc;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleGrpcClient {

    @GrpcClient("roleService")
    private RoleServiceGrpc.RoleServiceBlockingStub roleServiceStub;

    public AllRolesResponse getAllRoles() {
        return roleServiceStub.getAllRoles(Empty.getDefaultInstance());
    }
}
