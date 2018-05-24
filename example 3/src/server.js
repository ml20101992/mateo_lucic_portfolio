let express = require('express'),
    app = express(),
    port = process.env.PORT || 3000;

    let route = require('./api/Routing/Routes.js');
    let dbConn = require('./api/Controllers/DatabaseController');

    //services
    route(app);                 //setting up routes
    dbConn.connInit();
    dbConn.conn.query("SELECT * FROM user",function (error, results, fields) {
        if (error) throw error;
        console.log(results)
    });
    
    
    
    app.listen(port);

    console.log("Server listening on port " + port);