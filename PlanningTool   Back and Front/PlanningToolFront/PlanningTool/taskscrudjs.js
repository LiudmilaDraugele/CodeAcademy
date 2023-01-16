
populateSlaSelect();
populateTeamSelect();
populateTaskSelect();

// reikes padaryti, kad update task (tipas ir team) graziai populatintusi pagal atitinkama taska, 
//o ne bendrai is visu variantu

async function populateSlaSelect() {

    await fetch("http://localhost:8886/planning/api/slatype/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        let slatypeselect1 = document.getElementById("createTaskTypeSelect");
        let slatypeselect2 = document.getElementById("updateTaskTypeSelect");
        data.forEach(slatype => {
           let optionref = document.createElement("option");
           optionref.value = slatype.type;
           optionref.innerHTML=slatype.type;
           optionref.text=slatype.type;
           
           slatypeselect1.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = slatype.type;
           optionref2.innerHTML=slatype.type;
           optionref2.text=slatype.type;
           slatypeselect2.appendChild(optionref2);

        })
        console.log("sla type lists in task page populated")});   
}

async function populateTeamSelect() {

    await fetch("http://localhost:8886/planning/api/team/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Access-Control-Allow-Origin":"http://127.0.0.1:3000",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        let teamnameselect = document.getElementById("createTaskBelongsToTeam");
        let teamnameselect2 = document.getElementById("updateTaskBelongsToTeam");
        data.forEach(team => {
           let optionref = document.createElement("option");
           optionref.value = team.id;
           optionref.innerHTML=team.name;
           teamnameselect.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = team.id;
           optionref2.innerHTML=team.name;
           teamnameselect2.appendChild(optionref2);

        })
        console.log("teams lists in task page populated")}); 
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
        let taskselect = document.getElementById("updateTaskNameSelect");
        let taskselect2 = document.getElementById("deleteTaskNameSelect");
        data.forEach(task => {
           let optionref = document.createElement("option");
           optionref.value = task.id;
           optionref.innerHTML=task.name;
           taskselect.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = task.id;
           optionref2.innerHTML=task.name;
           taskselect2.appendChild(optionref2);

        })
        console.log("task lists in task page populated")}); 
}

let addtask = document.getElementById("addNewTaskForm");
addtask.addEventListener("submit", createTask);

async function createTask(e){
	e.preventDefault();
	
	let mytaskname = document.getElementById("createTaskNameInput").value;
    let mytasktime = document.getElementById("createTaskDurationInput").value;
    let mytaskSlaType = document.getElementById("createTaskTypeSelect").value;
    let mytasksla = document.getElementById("createTaskSlaInput").value;
    let mytaskteam = document.getElementById("createTaskBelongsToTeam").value;

	await fetch("http://localhost:8886/planning/api/task/create",{
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Access-Control-Allow-Origin":"http://127.0.0.1:3000",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
        body: JSON.stringify({name: mytaskname, minutes:mytasktime, type:mytaskSlaType, sla:mytasksla, teamId:mytaskteam})
    })
    .then(res => res.json())
    .then(data => { 
        console.log(data);
        window.location.reload();  
    });
    document.getElementById("teamsPage").classList = "optionaldivvisible";  
}


let updatetaskselect = document.getElementById("updateTaskNameSelect");
updatetaskselect.addEventListener("change", populateTaskDetailsForUpdate);

async function populateTaskDetailsForUpdate() {

    let mytaskid = document.getElementById("updateTaskNameSelect").value;

    console.log(mytaskid);

    await fetch(`http://localhost:8886/planning/api/task/${mytaskid}`,{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Access-Control-Allow-Origin":"http://127.0.0.1:3000",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(task => {
        let mynewtaskname = task.name;
        document.getElementById("updateTaskNameInput").value = mynewtaskname;
        let mynewtaskduration = task.minutes;
        document.getElementById("updateTaskDurationInput").value = mynewtaskduration;
        let mynewtasksla = task.sla;
        document.getElementById("updateTaskSla").value = mynewtasksla;

        })
        console.log("task details in update field in task page populated")
    } 

let updatetask = document.getElementById("updateTaskForm");
updatetask.addEventListener("submit", updateTask);

async function updateTask(e){
	e.preventDefault();
    let mytaskid = document.getElementById("updateTaskNameSelect").value;
    console.log(mytaskid)
    let mynewtaskname = document.getElementById("updateTaskNameInput").value;
    console.log(mynewtaskname)
    let mynewtaskduration = document.getElementById("updateTaskDurationInput").value;
    console.log(mynewtaskduration)
    let mynewtasktype = document.getElementById("updateTaskTypeSelect").value;
    console.log(mynewtasktype)
    let mynewtasksla = document.getElementById("updateTaskSla").value;
    console.log(mynewtasksla)
    let mynewtaskteam = document.getElementById("updateTaskBelongsToTeam").value;
    console.log(mynewtaskteam)

    await fetch(`http://localhost:8886/planning/api/task/${mytaskid}`,{
        method: "PUT",
        headers: {
             "Content-type": "application/json",
             "Access-Control-Allow-Origin":"http://127.0.0.1:3000",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
        body: JSON.stringify({id:mytaskid, name:mynewtaskname, minutes:mynewtaskduration,
            type:mynewtasktype, sla:mynewtasksla, teamId:mynewtaskteam})
       })
   .then(res => res.json());


    window.location.reload();
    
    document.getElementById("employeePage").classList = "optionaldivvisible";
}

let deletetask = document.getElementById("deleteTaskForm");
deletetask.addEventListener("submit", deleteTask);

async function deleteTask(){
   
    let mytaskid = document.getElementById("deleteTaskNameSelect").value;
    await fetch (`http://localhost:8886/planning/api/task/${mytaskid}`,{
                     method: "DELETE",
                     headers: {
                          "Content-Type": "application/json",
                          "Authorization":`Bearer `+`${localStorage.getItem("token")}`
                      },
                    });
                    window.location.reload();
                    document.getElementById("tasksPage").style.display = "block";           
 }
