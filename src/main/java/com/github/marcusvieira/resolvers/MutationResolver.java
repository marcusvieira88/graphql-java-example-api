package com.github.marcusvieira.resolvers;

import com.github.marcusvieira.dtos.*;
import com.github.marcusvieira.repositories.MessageRepository;
import com.github.marcusvieira.repositories.UserRepository;
import io.leangen.graphql.annotations.GraphQLMutation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class MutationResolver {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public MutationResolver(MessageRepository messageRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @GraphQLMutation
    public User createUser(String name, String email, String password) {
        User newUser = new User(name, email, password);
        return userRepository.saveUser(newUser);
    }

    @GraphQLMutation
    public Message createMessage(String userId, String message) {
        ZonedDateTime now = Instant.now().atZone(ZoneOffset.UTC);
        return messageRepository.saveMessage(new Message(now, userId, message));
    }
}