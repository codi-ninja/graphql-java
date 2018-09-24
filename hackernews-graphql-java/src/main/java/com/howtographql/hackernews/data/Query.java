package com.howtographql.hackernews.data;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.howtographql.hackernews.repository.LinkRepository;

public class Query implements GraphQLRootResolver {
    
    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }
}