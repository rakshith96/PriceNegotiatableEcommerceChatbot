var express = require("express");
var app = express();
var http = require('http');

var server = http.createServer(function(req, res) {
  res.writeHead(200);
  res.sendFile(path.join(__dirname + '/gistfile1.html'));
  //res.end('Hello, world!');
});

server.listen(80, '111.111.111.111');
var port = 3700;
var path = require('path');
app.get('/', function(req, res) {
    res.sendFile(path.join(__dirname + '/gistfile1.html'));
});

console.log("Listening on port " + port);
app.listen(port);
