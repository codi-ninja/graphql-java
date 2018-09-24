package com.howtographql.hackernews.solver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.howtographql.hackernews.data.SigninPayload;
import com.howtographql.hackernews.data.User;

public class SigninResolver implements GraphQLResolver<SigninPayload> {

    public User user(SigninPayload payload) {
        return payload.getUser();
    }
}