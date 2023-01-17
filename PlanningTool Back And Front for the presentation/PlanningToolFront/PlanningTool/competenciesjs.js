populateEmployeeSelect();
populateTaskSelect();
populateLevelSelect();


async function populateEmployeeSelect() {

    await fetch(`http://localhost:8886/planning/api/employee/all`)
    .then(res => res.json())
    .then(data => {
        let employeeselect1 = document.getElementById("createCompetencyForEmployeeSelect");
        let employeeselect2 = document.getElementById("updateCompetencyForEmployeeSelect");
        let employeeselect3 = document.getElementById("deleteCompetencyForEmployeeSelect");
        
        data.forEach(employee => {
           let optionref = document.createElement("option");
           optionref.value = employee.id;
           optionref.innerHTML=employee.name;
           employeeselect1.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = employee.id;
           optionref2.innerHTML=employee.name;
           employeeselect2.appendChild(optionref2);

           let optionref3 = document.createElement("option");
           optionref3.value = employee.id;
           optionref3.innerHTML=employee.name;
           employeeselect3.appendChild(optionref3);

        })
    });  
}

async function populateTaskSelect() {

    await fetch("http://localhost:8886/planning/api/task/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Access-Control-Allow-Origin":"http://127.0.0.1:3000",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        let taskselect = document.getElementById("createCompetencyInTaskSelect");
        let taskselect2 = document.getElementById("updateCompetencyInTaskSelect");
        let taskselect3 = document.getElementById("deleteCompetencyInTaskSelect");
        data.forEach(task => {
           let optionref = document.createElement("option");
           optionref.value = task.id;
           optionref.innerHTML=task.name;
           taskselect.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = task.id;
           optionref2.innerHTML=task.name;
           taskselect2.appendChild(optionref2);

           let optionref3 = document.createElement("option");
           optionref3.value = task.id;
           optionref3.innerHTML=task.name;
           taskselect3.appendChild(optionref3);

        })}); 
}

async function populateLevelSelect() {

        let levelselect = document.getElementById("updateCompetencyLevelSelect");
        let optionref;
        for (let i =1; i<=4; i++) {
           optionref = document.createElement("option");
           optionref.setAttribute('value', i)
           optionref.innerHTML=i;
           levelselect.appendChild(optionref);
        }
    }

 
let addcompetency = document.getElementById("addCompetencyForm");
addcompetency.addEventListener("submit", createCompetency);

async function createCompetency(e){
	e.preventDefault();
	
	let myemployeeid = document.getElementById("createCompetencyForEmployeeSelect").value;
    let mytaskid = document.getElementById("createCompetencyInTaskSelect").value;
    
	await fetch("http://localhost:8886/planning/api/competency/create",{
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
        body: JSON.stringify({employeeId: myemployeeid, taskId:mytaskid, level:"0"})
    })
    .then(res => res.json());
    document.getElementById("competenciesPage").classList = "optionaldivvisible";  
}

let updatecompetency = document.getElementById("updateCompetencyForm");
updatecompetency.addEventListener("submit", updateCompetency);

async function updateCompetency(e){
	e.preventDefault();
    
    let myemployeeid = document.getElementById("updateCompetencyForEmployeeSelect").value;
    let mytaskid = document.getElementById("updateCompetencyInTaskSelect").value;
    let mylevel = document.getElementById("updateCompetencyLevelSelect").value;
    let mycompid;

    await fetch(`http://localhost:8886/planning/api/competency/all`,{
        method: "GET",
        headers: {
             "Content-type": "application/json",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
       })
   .then(res => res.json())
   .then(data => data.forEach(element => {
    if (myemployeeid == element.employeeId && mytaskid == element.taskId){
        mycompid = element.id;
    }}
   ))
   await fetch(`http://localhost:8886/planning/api/competency/${mycompid}`,{
        method: "PUT",
        headers: {
             "Content-type": "application/json",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
        body: JSON.stringify({level: mylevel})
       })
   .then(res => res.json());
    document.getElementById("competenciesPage").classList = "optionaldivvisible";
}

let deletecompetency = document.getElementById("deleteCompetencyForm");
deletecompetency.addEventListener("submit", deleteCompetency);

async function deleteCompetency(){
   
    let myemployeeid = document.getElementById("deleteCompetencyForEmployeeSelect").value;
    let mytaskid = document.getElementById("deleteCompetencyInTaskSelect").value;
    let mycompid;

    await fetch(`http://localhost:8886/planning/api/competency/all`,{
        method: "GET",
        headers: {
             "Content-type": "application/json",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
       })
   .then(res => res.json())
   .then(data => data.forEach(element => {
    if (myemployeeid == element.employeeId && mytaskid == element.taskId){
        mycompid = element.id;
    }}
   ))
   await fetch(`http://localhost:8886/planning/api/competency/${mycompid}`,{
        method: "DELETE",
        headers: {
             "Content-type": "application/json",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
       })
   .then(res => res.json())
   .then(data => {
    window.location.reload();
    });
    document.getElementById("competenciesPage").classList = "optionaldivvisible";
}
  


