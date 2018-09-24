1 - Maven commands

	mvn compile

	mvn verify

	mvn jetty:run 

2 - Web server
	
	localhost:8080/graphql

	
3 - Queries

	{allLinks{url}} 
	{allLinks{url, description}}
	query links {allLinks {description}}
	mutation createLink{createLink(url:"http://java.com", description:"Sun Java") {url, description})	 
	mutation createUser { createUser(name: "devel", authProvider: { "devel@devel.com", password: "secret" }) { id, name } }

		


X - tutorial (with MongoDB persistence)

	https://www.howtographql.com/graphql-java/0-introduction/

	https://www.howtographql.com/graphql-java/1-getting-started/
	
	https://www.howtographql.com/graphql-java/2-queries/
	
	https://www.howtographql.com/graphql-java/3-mutations/

	https://www.howtographql.com/graphql-java/4-connectors/
	
	https://www.howtographql.com/graphql-java/5-authentication/
	
	https://www.howtographql.com/graphql-java/6-more-mutations/
	
	https://www.howtographql.com/graphql-java/7-error-handling/
	
	https://www.howtographql.com/graphql-java/8-subscriptions/
	
	https://www.howtographql.com/graphql-java/9-filtering/
	
	https://www.howtographql.com/graphql-java/10-pagination/
	
	https://www.howtographql.com/graphql-java/11-alternative-approaches/
	
	https://www.howtographql.com/graphql-java/12-summary/
	
	