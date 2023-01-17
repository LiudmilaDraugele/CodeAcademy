makeAllPagesInvisible();
makeButtonsInvisibleByRole();

function makeAllPagesInvisible(){
    document.getElementById("additionalTimePage").classList = "optionaldiv";
    document.getElementById("caseCountingPage").classList = "optionaldiv";
    document.getElementById("planPage").classList = "optionaldiv";
    document.getElementById("competenciesPage").classList = "optionaldiv";
    document.getElementById("tasksPage").classList = "optionaldiv";
    document.getElementById("employeesPage").classList = "optionaldiv";
    document.getElementById("teamsPage").classList = "optionaldiv";
}

function makeButtonsInvisibleByRole(){
    let myrole = localStorage.getItem("userrole");

    switch(myrole){
        case "ROLE_USER": 
            document.getElementById("caseCountingMenuButton").style.display = "none";
            document.getElementById("competenciesMenuButton").style.display = "none";
            document.getElementById("tasksMenuButton").style.display = "none";
            document.getElementById("teamsMenuButton").style.display = "none";
            break;
        case "ROLE_LEADER": 
            document.getElementById("caseCountingMenuButton").style.display = "none";
            break;
        case "ROLE_PLANNER": 
            document.getElementById("competenciesMenuButton").style.display = "none";
            document.getElementById("tasksMenuButton").style.display = "none";
            document.getElementById("teamsMenuButton").style.display = "none";
            break;
        default: console.log("Welcome Admin");
            break;
    }
}

let logoutbutton = document.getElementById("logoutButton");
logoutbutton.addEventListener("click", logOut);

function logOut(e){
    e.preventDefault();
    localStorage.removeItem("user");
    localStorage.removeItem("shortname");
	localStorage.removeItem("token");
	localStorage.removeItem("userid");
    localStorage.removeItem("username");
    localStorage.removeItem("userrole");
    localStorage.removeItem("dateforcounting");
    window.location.assign("http://127.0.0.1:3000/PlanningToolFront/index.html");
}

function toggleMenuPage(){

    makeAllPagesInvisible();
    switch (event.target.id){
        case "additionalTimeMenuButton":
            document.getElementById("additionalTimePage").classList = "optionaldivvisible";
            function1();
            break;
        case "caseCountingMenuButton":
            document.getElementById("caseCountingPage").classList = "optionaldivvisible"; 
            break;
        case "planMenuButton":
            document.getElementById("planPage").classList = "optionaldivvisible"; 
            break;
        case "competenciesMenuButton":
            document.getElementById("competenciesPage").classList = "optionaldivvisible"; 
            break;
        case "tasksMenuButton":
            document.getElementById("tasksPage").classList = "optionaldivvisible"; 
            break;
        case "employeesMenuButton":
            document.getElementById("employeesPage").classList = "optionaldivvisible"; 
            break;
        case "teamsMenuButton":
            document.getElementById("teamsPage").classList = "optionaldivvisible"; 
            break;
    }
    }

    
