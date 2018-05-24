/**
 * NAV FUNCTIONS
 */
var expanded = false;
function expandNav(){
    var navigations = new Array("test","test","test","test");

    //console.log(navigations);
    for(var i = 0; i<4; i++){

        navigations[i] = document.getElementById("nav"+(i+1));

    }

    if(expanded){
        for(var i = 0; i<4; i++){

            navigations[i].style.display = "none";

        }
        expanded = false;
    }
    else{
        for(var i = 0; i<4; i++){

            navigations[i].style.display = "flex";

        }
        expanded = true;
    }



}


/**
 * MAP FUNCTIONS
 */

/**
 * function used to initialize google map
 */
function initMap() {
    if (document.getElementById('map') === null) return;
    var latitude = document.getElementById("lat").innerHTML;
    var longitude = document.getElementById("lng").innerHTML;
    var z = document.getElementById("zoom").innerHTML;

    var loc = {lat: Number(latitude), lng: Number(longitude)};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: Number(z),
        center: loc
    });
    var marker = new google.maps.Marker({
        position: loc,
        map: map
    });
}


/**
 * GALLERY FUNCTIONS
 */

/**
 * Function used to display the full image in a pop up window
 * @param rootPath
 * @param pageName
 * @param imgNum
 */
function showFull(rootPath,pageName,imgNum){
    modal.style.display = "block";
    // alert(pageName+ " " +imgNum);

    var img_folder = "";

    switch(pageName){
        case "index.php": img_folder = "index";
            break;
        default: img_folder = pageName;
            break;
    }

    var img_path = rootPath + "/" + img_folder + "/full/" + imgNum +".jpg";

    var image = document.getElementById("full_sized_image");
    image.src = img_path;
}

/**
 * Function used to traverse through images in gallery
 * @param orientation
 */
function showNext(orientation){
    var fullSize = document.getElementById('full_sized_image');
    var imagePath = fullSize.src;
    var image = imagePath.split(".jpg")[0];

    var imageNum = image.split("/").pop();  //get the image number
    var folder = image.split("/");

    folder = folder[folder.length - 3];     //get the image containing folder

    var root = "../media";
    if(folder == "index") root = "media";

    // alert(folder);
    if(orientation == "next"){
        imageNum++;
    }
    else if(orientation == "prev"){
        imageNum--;
    }

    if(imageNum < 1  ){
        // var path = root + "/"+folder+"/full/"+imageNum+".jpg";
        // alert(path);
        fadeOutAndCallback(fullSize,function(){
            imageNum = 4;
            fadeIn(root,folder,imageNum)
        });

    }
    else if(imageNum >4){
        fadeOutAndCallback(fullSize,function(){
            imageNum = 1;
            fadeIn(root,folder,imageNum)
        });
    }
    else{
        fadeOutAndCallback(fullSize,function(){
            fadeIn(root,folder,imageNum)
        });
    }
}

/**
 * Fade out function
 */
function fadeOutAndCallback(image, callback){
    var opacity = 1;
    var timer = setInterval(function(){
        if(opacity < 0.1){
            clearInterval(timer);
            callback(); //this executes the callback function!
        }
        image.style.opacity = opacity;
        opacity -=  0.1;
    }, 50);
}

/**
 * Fade in function
 */
function fadeIn(root,folder,imageNum) {
    var op = 0.1;  // initial opacity
    var element = document.getElementById('full_sized_image');
    var timer = setInterval(function () {
        if (op >= 1){
            clearInterval(timer);
        }
        element.src = root + "/"+folder+"/full/"+imageNum+".jpg";
        element.style.opacity = op;
        op += 0.1;
    }, 10);
}


/**
 * MISC PAGES
 */

/**
 * function used to redirect to specific hotel page
 * @param id    page id
 */
function redirect(id){
    window.location = "page.php?id="+id;
}

//function used to mark current page
function markCurrent(){
    var title = document.title;
    switch(title){
        case "Dubrovnik - Home":{
            document.getElementById('nav1').classList.add('active');
        }break;

        case "Leave a comment!":{
            document.getElementById('nav4').classList.add('active');
        }break;

        case "Dubrovnik - What to visit":{
            document.getElementById('nav3').classList.add('active');
        }break;

        default:{
            document.getElementById('nav2').classList.add('active');
        }break;
    }
}


/**
 * COMMENT FORM FUNCTIONS
 */

//function used to display option to post a comment
function showPost(){
    var postDiv = document.getElementById('form_div');
    if(postDiv.style.display == "none" || postDiv.style.display == ""){
        postDiv.style.display = "block";
    }
    else{
        postDiv.style.display = "none";
    }
}



/**
 * Function used to validate form input on client side
 */
function validate(){
    var error_area = document.getElementById('error_log');
    var error = false;
    if( document.comment_form.poster.value == "" )
    {
        // alert( "Please provide your name!" );
        // document.comment_form.poster.focus() ;
        // return false;
        error_area.innerHTML += "<div style=\"color:lightcoral\">Poster field must not be empty!</div><br>"
        error = true;
    }
    else{
        if(document.comment_form.poster.value.length < 3){
            error_area.innerHTML += "<div style=\"color:lightcoral\">Poster entry must be greater than 3!</div><br>"
            error = true;
        }
        else if(!("[a-zA-Z]+.+".test(document.comment_form.poster.value))){
            error_area.innerHTML += "<div style=\"color:lightcoral\">Poster entry must start with a letter!</div><br>"
            error = true;
        }
    }

    if( document.comment_form.comment.value == "" )
    {
        error_area.innerHTML += "<div style=\"color:lightcoral\">Comment field must not be empty!</div><br>"
        error = true;
    }
    else{
        if(document.comment_form.comment.value.length < 3){
            error_area.innerHTML += "<div style=\"color:lightcoral\">Comment entry must be greater than 3!</div><br>"
            error = true;
        }
    }

    if(error) return false;
}


/**
 * FINAL SETUP
 */

document.body.onload = initMap;

// Get the modal
var modal = document.getElementById('fullsize');

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

var content = document.getElementById('spacing_div');
var navbar  = document.getElementsByTagName('nav')[0];


content.style.paddingTop = navbar.clientHeight+"px";        //dinamically setting the padding for the navbar
markCurrent();