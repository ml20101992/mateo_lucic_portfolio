'use strict';
let configureRoutes = function(app){
    let route = app;

    route.get('/register',function(req,res){
        console.log('get works!');
        
    });
};

module.exports = configureRoutes;