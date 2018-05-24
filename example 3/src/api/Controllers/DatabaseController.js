let mysql = require('mysql');

exports.conn = mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"bSqq1eqS",
    database:"USERS",
});

exports.connInit = function(){
    exports.conn.connect((err)=>{
        if(err){
            console.log(err);
        }
        console.log("connected");
    });
}
