populateTeamSelect();
let addteam = document.getElementById("addNewTeamForm");
addteam.addEventListener("submit", createTeam);

async function createTeam(e){
	e.preventDefault();
	
	let myteamname = document.getElementById("teamNameCreationInput").value;

	await fetch("http://localhost:8886/planning/api/team/create",{
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
        body: JSON.stringify({name: myteamname})
    })
    .then(res => res.json())
    
        
    window.location.reload();  
    
    document.getElementById("teamsPage").classList = "optionaldivvisible";  
}

async function populateTeamSelect() {

    await fetch("http://localhost:8886/planning/api/team/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        let teamnameselect = document.getElementById("teamNameToChangeSelect");
        let teamnameselect2 = document.getElementById("teamNameToDeleteSelect");
        data.forEach(team => {
           let optionref = document.createElement("option");
           optionref.value = team.id;
           optionref.innerHTML=team.name;
           teamnameselect.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = team.id;
           optionref2.innerHTML=team.name;
           teamnameselect2.appendChild(optionref2);

        })});
    
}

let updateteam = document.getElementById("changeTeamNameForm");
updateteam.addEventListener("submit", updateTeam);

async function updateTeam(e){
	e.preventDefault();
    let myteamid = document.getElementById("teamNameToChangeSelect").value;
    let newteamname = document.getElementById("changeTeamNameInput").value;

    await fetch(`http://localhost:8886/planning/api/team/${myteamid}`,{
        method: "PUT",
        headers: {
             "Content-type": "application/json",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
        body: JSON.stringify({name: newteamname})
       })
   .then(res => res.json())
   .then(data => {
    window.location.reload();
    });
    document.getElementById("teamsPage").classList = "optionaldivvisible";
}

let deleteteam = document.getElementById("deleteTeamForm");
deleteteam.addEventListener("submit", deleteTeam);

async function deleteTeam(){
   
    let myteamid = document.getElementById("teamNameToDeleteSelect").value;
    await fetch (`http://localhost:8886/planning/api/team/${myteamid}`,{
                     method: "DELETE",
                     headers: {
                          "Content-Type": "application/json",
                          "Authorization":`Bearer `+`${localStorage.getItem("token")}`
                      },
                    })
                    window.location.reload();
                    document.getElementById("teamsPage").classList = "optionaldivvisible";           
 }