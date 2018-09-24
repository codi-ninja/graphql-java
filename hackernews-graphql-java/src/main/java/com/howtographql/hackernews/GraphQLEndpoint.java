package com.howtographql.hackernews;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;
import com.howtographql.hackernews.data.Mutation;
import com.howtographql.hackernews.data.Query;
import com.howtographql.hackernews.repository.LinkRepository;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 7727407048958240998L;
    
    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
    	LinkRepository linkRepository = new LinkRepository();
    	
    	return SchemaParser.newParser()
            .file("schema.graphqls")
            .resolvers(new Query(linkRepository), new Mutation(linkRepository))
            .build()
            .makeExecutableSchema();
    }
}