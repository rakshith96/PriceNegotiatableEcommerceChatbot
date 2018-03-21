var builder = require('botbuilder'); 
var apiairecognizer = require('api-ai-recognizer'); 
var restify = require('restify');

//var connector = new builder.ChatConnector().listen();
//var connector = new builder.ConsoleConnector().listen();
var server = restify.createServer();
server.listen(process.env.port || process.env.PORT || 3978, function() {
	console.log("%s listening to %s", server.name, server.url);
});

var connector = new builder.ChatConnector({
    appId: process.env.MICROSOFT_APP_ID,
    appPassword: process.env.MICROSOFT_APP_PASSWORD
}); 
server.post('/api/messages', connector.listen());
var bot = new builder.UniversalBot(connector); 
var recognizer = new apiairecognizer("b191dc4e1ece49d3abad5369c94df833"); 
var intents = new builder.IntentDialog({ recognizers: [recognizer] }); 
bot.dialog('/',intents);
//intents.matches('whatIsWeather',function(session){ session.send("It's 27 degrees celsius"); }); 
intents.onDefault(function(session){ session.send("Sorry...can you please rephrase?"); }); 
//intents.matches('smalltalk.greetings',function(session){ session.send('This is smalltalk'); });
intents.matches('smalltalk.greetings.hello',function(session, args){ var fulfillment = builder.EntityRecognizer.findEntity(args.entities, 'fulfillment'); if (fulfillment){ var speech = fulfillment.entity; session.send(speech); }else{ session.send('Sorry...not sure how to respond to that'); } });
intents.matches('smalltalk.greetings.goodmorning',function(session, args){ var fulfillment = builder.EntityRecognizer.findEntity(args.entities, 'fulfillment'); if (fulfillment){ var speech = fulfillment.entity; session.send(speech); }else{ session.send('Sorry...not sure how to respond to that'); } });
intents.matches('smalltalk.greetings.goodevening',function(session, args){ var fulfillment = builder.EntityRecognizer.findEntity(args.entities, 'fulfillment'); if (fulfillment){ var speech = fulfillment.entity; session.send(speech); }else{ session.send('Sorry...not sure how to respond to that'); } });
intents.matches('smalltalk.greetings.goodnight',function(session, args){ var fulfillment = builder.EntityRecognizer.findEntity(args.entities, 'fulfillment'); if (fulfillment){ var speech = fulfillment.entity; session.send(speech); }else{ session.send('Sorry...not sure how to respond to that'); } });
intents.matches('smalltalk.greetings.bye',function(session, args){ var fulfillment = builder.EntityRecognizer.findEntity(args.entities, 'fulfillment'); if (fulfillment){ var speech = fulfillment.entity; session.send(speech); }else{ session.send('Sorry...not sure how to respond to that'); } });
intents.matches('smalltalk.greetings.how_are_you',function(session, args){ var fulfillment = builder.EntityRecognizer.findEntity(args.entities, 'fulfillment'); if (fulfillment){ var speech = fulfillment.entity; session.send(speech); }else{ session.send('Sorry...not sure how to respond to that'); } });
intents.matches('smalltalk.greetings.good',function(session, args){ var fulfillment = builder.EntityRecognizer.findEntity(args.entities, 'fulfillment'); if (fulfillment){ var speech = fulfillment.entity; session.send(speech); }else{ session.send('Sorry...not sure how to respond to that'); } });
intents.matches('smalltalk.appraisal.good',function(session, args){ var fulfillment = builder.EntityRecognizer.findEntity(args.entities, 'fulfillment'); if (fulfillment){ var speech = fulfillment.entity; session.send(speech); }else{ session.send('Sorry...not sure how to respond to that'); } });
intents.matches('whatIsWeather',function(session,args)
{ 
	var city = builder.EntityRecognizer.findEntity(args.entities,'Cities'); 
	if (city)
	{ 
	var city_name = city.entity; 
	session.send("It's 27 degrees celsius in " + city_name); 
	}
	else
	{ 
	session.send("It's 27 degrees celsius"); 
	} });
intents.matches('isAvailable',function(session,args)
{
	var item = builder.EntityRecognizer.findEntity(args.entities,'Items');
	if(item)
	{
	var item_name = item.entity;
	session.send(" AVAILABLE!!!");
	}
	else
	{
	session.send("Item not available");
	}	
});

//price['Jacket'] = 3000;
intents.matches('Price',function(session,args)
{
	var price = {"Laptops": "40000", "Television": "20000", "Camera": "3000", "Mobile": "13000"};
	var item = builder.EntityRecognizer.findEntity(args.entities,'Items');
	if(item)
	{
	var item_name = item.entity;
	session.send(price[item_name]);
	}
	else
	{
		session.send("Item not available");
	}
});

intents.matches('Discount',function(session,args)
{
	var disc = {"Laptops": "15", "Television": "35", "Camera": "30", "Mobile": "20"};
	var item = builder.EntityRecognizer.findEntity(args.entities,'Items');
	if(item)
	{
	var item_name = item.entity;
	session.send(disc[item_name]+"%");
	}
	else
	{
		session.send("Item not available");
	}
});
