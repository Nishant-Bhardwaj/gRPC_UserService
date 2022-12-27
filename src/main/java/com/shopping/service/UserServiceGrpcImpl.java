package com.shopping.service;

import com.shopping.entities.User;
import com.shopping.stub.user.Gender;
import com.shopping.stub.user.UserRequest;
import com.shopping.stub.user.UserResponse;
import com.shopping.stub.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Custom Implementation to GRPC Service stub
 *
 * @author Nishant Bhardwaj
 */
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    UserDataService userDataService;

    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {

        User user = userDataService.getUserDetails(request.getUsername());

        UserResponse userResponse = UserResponse.newBuilder()
                .setId(user.getId())
                .setAge(user.getAge())
                .setName(user.getName())
                .setUsername(user.getUsername())
                .setGender(Gender.valueOf(user.getGender()))
                .build();

        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();

    }
}
