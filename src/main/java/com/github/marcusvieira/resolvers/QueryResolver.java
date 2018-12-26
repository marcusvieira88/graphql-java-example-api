package com.github.marcusvieira.resolvers;

import com.github.marcusvieira.dtos.Message;
import com.github.marcusvieira.dtos.User;
import com.github.marcusvieira.filter.MessageFilter;
import com.github.marcusvieira.filter.UserFilter;
import com.github.marcusvieira.repositories.MessageRepository;
import com.github.marcusvieira.repositories.UserRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;

import java.util.List;
public class QueryResolver {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public QueryResolver(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @GraphQLQuery
    public List<User> allUsers(UserFilter filter, @GraphQLArgument(name = "skip", defaultValue = "0") Number skip,
                               @GraphQLArgument(name = "first", defaultValue = "0") Number first) {
        return userRepository.getAllUsers(filter, skip.intValue(), first.intValue());
    }

    @GraphQLQuery
    public List<Message> allMessages(MessageFilter filter, @GraphQLArgument(name = "skip", defaultValue = "0") Number skip,
                                     @GraphQLArgument(name = "first", defaultValue = "0") Number first) {
        return messageRepository.getAllMessages(filter, skip.intValue(), first.intValue());
    }
}
