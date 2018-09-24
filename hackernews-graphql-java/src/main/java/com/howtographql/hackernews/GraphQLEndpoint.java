package com.howtographql.hackernews;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;
import com.howtographql.hackernews.data.Query;
import com.howtographql.hackernews.repository.LinkRepository;
import com.howtographql.hackernews.repository.UserRepository;
import com.howtographql.hackernews.solver.SigninResolver;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 7727407048958240998L;
	private static final LinkRepository linkRepository;
    private static final UserRepository userRepository; //the new field
    
    static {
            MongoDatabase mongo = new MongoClient().getDatabase("hackernews");
            linkRepository = new LinkRepository(mongo.getCollection("links"));
            userRepository = new UserRepository(mongo.getCollection("users"));
    }
    
    //the rest is the same
    
    public GraphQLEndpoint() {
        super(buildSchema());
    }    
    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                		new Query(linkRepository), 
                		new Mutation(linkRepository, userRepository), 
                		new SigninResolver())
                .build()
                .makeExecutableSchema();
    }
}