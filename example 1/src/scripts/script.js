//setMargin();
setActive();
// Get the modal
var modal = document.getElementById('myModal');
var signup_modal = document.getElementById('login-modal');

document.title += " "+document.getElementById('page_title').childNodes[0].innerHTML;

// Get the button that opens the modal
if((location.pathname.split("/").slice(-1) == "forum_index.php") || (location.pathname.split("/").slice(-1) == "category.php") || (location.pathname.split("/").slice(-1) == "thread.php")) {
    var btn = document.getElementById("login");
    var btn2 = document.getElementById("signup");


// Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];
    var span2 = document.getElementById("close_signup");
// When the user clicks the button, open the modal
    btn.onclick = function () {
        modal.style.display = "block";
    }
    btn2.onclick = function () {
        signup_modal.style.display = "block";
    }

// When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }

    span2.onclick = function () {
        signup_modal.style.display = "none";
    }

// When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal || event.target == signup_modal) {
            modal.style.display = "none";
            signup_modal.style.display = "none";
        }
    }
}

window.onresize = resizeActions;


function displayOptions(session_flag){
    var loginOK = document.getElementById("login_ok").style.display;
    var loginFAIL = document.getElementById("login_fail").style.display;
    var button = document.getElementById("thread_button");
    var text = document.getElementById("thread_button_text").innerHTML;
    if((loginOK == "none"  && loginFAIL == "none") ||(loginOK == ""  && loginFAIL == "")) {
        if (session_flag == true) {
            document.getElementById("login_ok").style.display = "block";
        }
        else {
            document.getElementById("login_fail").style.display = "block";
        }
        button.innerHTML = "CLOSE";
    }else
    {
        document.getElementById("login_ok").style.display = "none";
        document.getElementById("login_fail").style.display = "none";
        button.innerHTML = text;
    }
}


function resizeActions(){
    addSpace();
}

function addSpace(){
    document.getElementById("space").style.height = 2*document.getElementById("footer").clientHeight+"px";
}

function setActive(){

    var pagename = location.pathname.split("/").slice(-1);
    //alert(pagename);
    var setActivePage = "";
    if(!(pagename == "page.php" )){
        if (pagename == "index.php") setActivePage  = "home";
        if (pagename == "types.php") setActivePage = "types";
        if (pagename == "regions.php") setActivePage = "regions";
        if (pagename =="forum_index.php" || pagename=="category.php" || pagename=="thread.php") setActivePage  = "forum";
    }
    else{
        var title = document.getElementById('page_title').childNodes[0].innerHTML;
        switch(title) {
            case "About Coffee": setActivePage  = "about";
                break;
            case "Types of Beans": setActivePage  = "types";
                break;
            case "Frequently asked questions": setActivePage  = "faq";
                break;
            case "Harvesting of Coffee": setActivePage  = "harvesting";
                break;
            case "Trivia": setActivePage  = "trivia";
                break;
            case "Types of Product": setActivePage  = "types";
                break;
            case "Coffee in Africa": setActivePage  = "regions";
                break;
            case "Coffee in Asia": setActivePage  = "regions";
                break;
            case "Coffee in Europe": setActivePage  = "regions";
                break;
            case "Coffee in Americas": setActivePage  = "regions";
                break;
            default: "";
                break;
        }
    }

    //alert(setActivePage )

    document.getElementById(setActivePage).classList.add('active');
}