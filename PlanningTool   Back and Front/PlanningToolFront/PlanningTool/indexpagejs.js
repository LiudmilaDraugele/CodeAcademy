makeAllPagesInvisible();

//reikes padaryti, kad mygtukus ir funkcijas galetu matyti tik reikiamos roles
//kad USER galetu tik savo pass pasikeisti ir daugiau nieko keist negaletu

//sumastyti, kaip padaryti funkcija, kad mano puslapiai butu rodomi graziai po funkcijos suveikimo

function makeAllPagesInvisible(){
    document.getElementById("additionalTimePage").classList = "optionaldiv";
    document.getElementById("caseCountingPage").classList = "optionaldiv";
    document.getElementById("planPage").classList = "optionaldiv";
    document.getElementById("checklistPage").classList = "optionaldiv";
    document.getElementById("competenciesPage").classList = "optionaldiv";
    document.getElementById("tasksPage").classList = "optionaldiv";
    document.getElementById("employeesPage").classList = "optionaldiv";
    document.getElementById("teamsPage").classList = "optionaldiv";
}

let logoutbutton = document.getElementById("logoutButton");
logoutbutton.addEventListener("click", logOut);

function logOut(e){
    e.preventDefault();
    localStorage.removeItem("user");
    localStorage.removeItem("shortname");
	localStorage.removeItem("token");
	localStorage.removeItem("userid");
    localStorage.removeItem("userrole");
    window.location.assign("http://127.0.0.1:3000/PlanningToolFront/index.html");
    //window.close();
	//window.open("./index.html");
}

function toggleMenuPage(){

    makeAllPagesInvisible();
    switch (event.target.id){
        case "additionalTimeMenuButton":
            document.getElementById("additionalTimePage").classList = "optionaldivvisible"; 
            break;
        case "caseCountingMenuButton":
            document.getElementById("caseCountingPage").classList = "optionaldivvisible"; 
            break;
        case "planMenuButton":
            document.getElementById("planPage").classList = "optionaldivvisible"; 
            break;
        case "checklistMenuButton":
            document.getElementById("checklistPage").classList = "optionaldivvisible"; 
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

    
