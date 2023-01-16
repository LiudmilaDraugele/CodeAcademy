let mydateplaninput = document.getElementById("dateForPlanInput");
let mydateforplan;

let tasksarrayforplan;
let employeearrayforplan;
let activitieslistforplan;
let competenciesarrayforplan;
getTasksForPlan();
getEmployeesForPlan();
getActivitiesListForPlan();
getCompetenciesArrayForPlan();
let additionaltimearrayforplan;
let countingarrayforplan;
let databuttonclickcount=0;
const additionalCollumnCountFront = 5;
const additionalCollumnCountBack = 2;
const additionalRowCount = 2;

mydateplaninput.addEventListener("change", resetPlan);

function resetPlan(){
    console.log("pakeista data");
    clearPlanGridValues(tasksarrayforplan, employeearrayforplan, activitieslistforplan);
    mydateforplan = document.getElementById("dateForPlanInput").value.toString();
    console.log(mydateforplan);
    getAdditionalTimesForPlan(mydateforplan);
    getCountingForPlan(mydateforplan);
    createPlanGrid(tasksarrayforplan, employeearrayforplan, activitieslistforplan);

    createInputsForValuesInPlanGrid(competenciesarrayforplan,tasksarrayforplan, employeearrayforplan);

    setTimeout(() => {
        populateAdditionalTimesToPlan(additionaltimearrayforplan);
        populateCountingToPlan(countingarrayforplan);
        checkIfPlanExistAndPopulateWithValues(mydateforplan);
          }, "300")

          

    setTimeout(() => {
        populateHoursNeeded(countingarrayforplan);
        populateRemainingVolumes(employeearrayforplan);
        calculateRemainingTimeAfterAdditional(employeearrayforplan);
        calculateRemainingTime(employeearrayforplan);
        
          }, "500")
}

let myplandatebutton = document.getElementById("getDateForPlan");
myplandatebutton.addEventListener("click", () => {
    
    if (databuttonclickcount!=0){
        console.log("dar karta paspaustas mygtukas");
        clearPlanGridValues(tasksarrayforplan, employeearrayforplan, activitieslistforplan);
        databuttonclickcount = 0;
    }
   
    databuttonclickcount++;
    mydateforplan = document.getElementById("dateForPlanInput").value.toString();
    console.log(mydateforplan);
    getAdditionalTimesForPlan(mydateforplan);
    getCountingForPlan(mydateforplan);
    createPlanGrid(tasksarrayforplan, employeearrayforplan, activitieslistforplan);

    createInputsForValuesInPlanGrid(competenciesarrayforplan,tasksarrayforplan, employeearrayforplan);

    setTimeout(() => {
    populateAdditionalTimesToPlan(additionaltimearrayforplan);
    populateCountingToPlan(countingarrayforplan);
    checkIfPlanExistAndPopulateWithValues(mydateforplan);
      }, "300")
     
    

    setTimeout(() => {
        populateHoursNeeded(countingarrayforplan);
        //populateHoursAssigned(countingarrayforplan, employeearrayforplan, tasksarrayforplan)
        populateRemainingVolumes(employeearrayforplan);
        calculateRemainingTimeAfterAdditional(employeearrayforplan);
        calculateRemainingTime(employeearrayforplan);
          }, "500")


});

async function getTasksForPlan() {

    await fetch("http://localhost:8886/planning/api/task/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        tasksarrayforplan = data;
        });
}

async function getEmployeesForPlan() {

    await fetch("http://localhost:8886/planning/api/employee/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        employeearrayforplan = data;
        });
}

async function getActivitiesListForPlan(){

    await fetch("http://localhost:8886/planning/api/activity/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        activitieslistforplan = data;
    });
}

async function getCompetenciesArrayForPlan(){

    await fetch("http://localhost:8886/planning/api/competency/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        competenciesarrayforplan = data;
        });
}

async function getAdditionalTimesForPlan(mydateforplan){
    await fetch(`http://localhost:8886/planning/api/additional/bydate/${mydateforplan}`,{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        additionaltimearrayforplan = data;
        });
}

async function getCountingForPlan(mydateforplan){
    await fetch(`http://localhost:8886/planning/api/counting/bydate/${mydateforplan}`,{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        countingarrayforplan = data;
        });
}

async function checkIfPlanExistAndPopulateWithValues(mydateforplan){

    console.log(`ar ateiname cia?? >${mydateforplan}`)
   
    await fetch(`http://localhost:8886/planning/api/plan/bydate/${mydateforplan}`,{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        console.log(`ar ateiname cia?? >${data.length}`)
        if(data.length != 0){
            populatePlanGridWithValues(data);
            console.log(`asasasdasd>${data}`)
        } 
        else{
            console.log("pasirinktai datai - irasu nerasta")
        }
            })
}

function createPlanGrid(tasksarrayforplan, employeearrayforplan, activitieslistforplan){

    let collumncount = employeearrayforplan.length + additionalCollumnCountFront + additionalCollumnCountBack;
    console.log(collumncount)
    let rowcount = tasksarrayforplan.length+activitieslistforplan.length+additionalRowCount;
    console.log(rowcount)

    let planmaingrid = document.getElementById("planGrid");
    planmaingrid.classList="planGrid";
    planmaingrid.style.gridTemplateColumns = `repeat(${collumncount}, fit-content(200px))`;
    //planmaingrid.style.gridTemplateRows = `repeat(${rowcount}, 1fr)`;
    
    for(let x =0;x<collumncount; x++){
        let plancollumn = document.createElement("div");
        plancollumn.classList = "plancollumn";
        plancollumn.id="plancollumn-"+x;
        planmaingrid.appendChild(plancollumn);

        for(let y=0; y<rowcount; y++){
        let plancell = document.createElement("div");
        plancell.classList = "planscell";
        plancell.id = "cell-"+ x +"-"+ y;
        plancollumn.appendChild(plancell);
    }
    }
    
    let invisiblecell;
    for(let inv = 0; inv<additionalCollumnCountFront;inv++){
        invisiblecell = document.getElementById(`cell-${inv}-0`);
    invisiblecell.classList = "planscellinvisible";
    }
    invisiblecell = document.getElementById(`cell-${collumncount-2}-0`);
    invisiblecell.classList = "planscellinvisible";
    invisiblecell = document.getElementById(`cell-${collumncount-1}-0`);
    invisiblecell.classList = "planscellinvisible";

    let titlecell0 = document.getElementById("cell-0-1");
    titlecell0.textContent = "Task name";
    let titlecell1 = document.getElementById("cell-1-1");
    titlecell1.textContent = "Target time";
    let titlecell2 = document.getElementById("cell-2-1");
    titlecell2.textContent = "Hours needed";
    // let titlecell3 = document.getElementById("cell-3-1");
    // titlecell3.textContent = "Hours assigned";
    // let titlecell4 = document.getElementById("cell-4-1");
    // titlecell4.textContent = "Hours of backlog";
    let titlecell5 = document.getElementById("cell-3-1");
    titlecell5.textContent = "Volumes";
    let titlecell6 = document.getElementById("cell-4-1");
    titlecell6.textContent = "Remaining volumes";
    let titlecell7 = document.getElementById(`cell-${collumncount-additionalCollumnCountBack}-1`);
    titlecell7.textContent = "Comments";
    titlecell7.style.fontFamily = "Verdana, Geneva, Tahoma, sans-serif";
    titlecell7.style.height = "160px";
    titlecell7.style.width = "250px";
    titlecell7.style.textAlign = "center";
    let titlecell8 = document.getElementById(`cell-${collumncount-(additionalCollumnCountBack-1)}-1`);
    titlecell8.textContent = "SLA";
    titlecell8.style.height = "160px";
    titlecell8.style.fontFamily = "Verdana, Geneva, Tahoma, sans-serif";
    titlecell8.style.width = "26px";
    titlecell8.style.textAlign = "start";
    titlecell8.style.writingMode = "vertical-rl";

    let namecell, timeleftcell, e;
    
    for(let emp = 0; emp<employeearrayforplan.length;emp++){
        e = emp+additionalCollumnCountFront;
        namecell = document.getElementById(`cell-${e}-1`);
        namecell.textContent = employeearrayforplan[emp].name;
        namecell.data = employeearrayforplan[emp].id;
        namecell.style.height = "160px";
        namecell.style.width = "26px";
        namecell.style.writingMode = "vertical-rl";
        namecell.style.fontFamily = "Verdana, Geneva, Tahoma, sans-serif";
        namecell.style.backgroundColor = "rgb(217, 232, 218)";
        namecell.style.textAlign = "end";
        timeleftcell = document.getElementById(`cell-${e}-0`);
        timeleftcell.style.height = "26px";
        timeleftcell.style.width = "26px";
    }

    let taskcell, tasktimecell, taskslacell, activitynamecell;
    
    for(let i = 0; i<tasksarrayforplan.length;i++){
        e = i+additionalRowCount;
        taskcell = document.getElementById(`cell-0-${e}`);
        taskcell.textContent = tasksarrayforplan[i].name;
        taskcell.data = tasksarrayforplan[i].id;
        taskcell.style.backgroundColor = "rgb(217, 232, 218)";
        taskcell.style.height = "26px";
        tasktimecell = document.getElementById(`cell-1-${e}`);
        tasktimecell.textContent = tasksarrayforplan[i].minutes;
        tasktimecell.style.backgroundColor = "rgb(217, 232, 218)";
        tasktimecell.style.height = "26px";
        tasktimecell.style.width = "26px";

        taskslacell = document.getElementById(`cell-${collumncount-1}-${e}`);
        if(tasksarrayforplan[i].type == "EXTERNAL"){
            taskslacell.textContent = `E-${tasksarrayforplan[i].sla}`;
        }
        if(tasksarrayforplan[i].type == "INTERNAL"){
            taskslacell.textContent = `I-${tasksarrayforplan[i].sla}`;
        }
    }
    for(let i = 0; i<activitieslistforplan.length;i++){
        e = i+2+tasksarrayforplan.length;
        activitynamecell = document.getElementById(`cell-0-${e}`);
        activitynamecell.textContent = activitieslistforplan[i].name;
        console.log(`>>>.>>${activitieslistforplan[i].id} /// ${activitieslistforplan[i].name}`)
        activitynamecell.data = activitieslistforplan[i].id;
        activitynamecell.style.height = "26px";
    }

}

function createInputsForValuesInPlanGrid(competenciesarrayforplan,tasksarrayforplan, employeearrayforplan){

    let cellXnr, cellYnr, cellforinput;
    
    for(let x=0; x<employeearrayforplan.length; x++){
        for(let y=0; y<tasksarrayforplan.length; y++){
            cellYnr=y+additionalRowCount;
            cellXnr = x+additionalCollumnCountFront;
        for(let i=0; i<competenciesarrayforplan.length; i++){
                if((document.getElementById(`cell-0-${cellYnr}`).data == competenciesarrayforplan[i].taskId)
                &&(document.getElementById(`cell-${cellXnr}-1`).data == competenciesarrayforplan[i].employeeId)){
                    cellforinput = document.getElementById(`cell-${cellXnr}-${cellYnr}`);
                    let inputinthecell = document.createElement("input");
                    inputinthecell.classList = "inputinthecell";
                    inputinthecell.id = `input-${cellXnr}-${cellYnr}`;
                    if(competenciesarrayforplan[i].level == 1){
                        inputinthecell.style.backgroundColor = "rgb(171, 167, 167)";
                        cellforinput.style.backgroundColor = "rgb(171, 167, 167)";
                    } else if (competenciesarrayforplan[i].level == 2){
                        inputinthecell.style.backgroundColor = "rgb(152, 213, 152)";
                        cellforinput.style.backgroundColor = "rgb(152, 213, 152)";
                    } else if(competenciesarrayforplan[i].level == 3){
                        inputinthecell.style.backgroundColor = "rgb(150, 200, 74)";
                        cellforinput.style.backgroundColor = "rgb(150, 200, 74)";
                    } else if(competenciesarrayforplan[i].level == 4){
                        inputinthecell.style.backgroundColor = "rgb(246, 246, 84)";
                        cellforinput.style.backgroundColor = "rgb(246, 246, 84)";
                    } else {
                        cellforinput.style.backgroundColor = "red";
                    }

                    ///////
                    /////   cia mano pasikeitimu event listeneris!!!!
                    /////
                    /////
                    /////
                    ////
                    inputinthecell.addEventListener("change", () => {
                        setTimeout(() => {
                            populateHoursNeeded(countingarrayforplan);
                            //populateHoursAssigned(countingarrayforplan, employeearrayforplan, tasksarrayforplan)
                            populateRemainingVolumes(employeearrayforplan);
                            calculateRemainingTimeAfterAdditional(employeearrayforplan);
                            calculateRemainingTime(employeearrayforplan);
                              }, "300")
                        
                    })
                    cellforinput.appendChild(inputinthecell);
                }
                else{
                    cellforinput = document.getElementById(`cell-${cellXnr}-${cellYnr}`);
                    cellforinput.style.backgroundColor = "rgb(220, 224, 220)";
                }
            }
        }
    }
}

function populateCountingToPlan(countingarrayforplan){
    
    let cellYnr, countingcell, commentcell;
    let collumncount = employeearrayforplan.length + additionalCollumnCountFront + additionalCollumnCountBack;
    
    for(let i=0; i<tasksarrayforplan.length; i++){
        cellYnr=i+additionalRowCount;
        for(let j=0; j<countingarrayforplan.length; j++){
        if(document.getElementById(`cell-0-${cellYnr}`).data == countingarrayforplan[j].taskId){
            console.log(countingarrayforplan[j].count);
            countingcell = document.getElementById(`cell-3-${cellYnr}`);
            countingcell.style.backgroundColor = "rgb(217, 232, 218)";
            countingcell.textContent = countingarrayforplan[j].count;
            commentcell = document.getElementById(`cell-${collumncount-additionalCollumnCountBack}-${cellYnr}`);
            commentcell.style.backgroundColor = "rgb(217, 232, 218)";
            commentcell.textContent = countingarrayforplan[j].comment;
        }
        }
    }

}

function populateAdditionalTimesToPlan(additionaltimearrayforplan){
    
    let cellYnr, cellXnr, additionalcell, str;
    for(let x=0; x<employeearrayforplan.length; x++){
        
        for(let y=0; y<tasksarrayforplan.length; y++){
            cellYnr=y+additionalRowCount+tasksarrayforplan.length;
            cellXnr=x+additionalCollumnCountFront;
            for(let i=0; i<additionaltimearrayforplan.length; i++){   
                if((document.getElementById(`cell-0-${cellYnr}`).data == additionaltimearrayforplan[i].activityId)
                &&(document.getElementById(`cell-${cellXnr}-1`).data == additionaltimearrayforplan[i].employeeId)){

                    additionalcell = document.getElementById(`cell-${cellXnr}-${cellYnr}`);
                    str = (additionaltimearrayforplan[i].duration/60).toString();
                    str = str.slice(0, (str.indexOf(".")) + 2 + 1);
                    additionalcell.textContent = str;
                    additionalcell.value = additionaltimearrayforplan[i].duration;
                }  
            }
        }
     }
}

function populatePlanGridWithValues(data){

    let mycount, myemployeeId, mytaskId, cellYnr, cellXnr, myinput, mymarked, mydone;
    
    for(let x=0; x<employeearrayforplan.length; x++){
        for(let y=0; y<tasksarrayforplan.length; y++){
            cellYnr=y+additionalRowCount;
            cellXnr=x+additionalCollumnCountFront;
            for(let i=0; i<competenciesarrayforplan.length; i++){
                if((document.getElementById(`cell-0-${cellYnr}`).data == data[i].taskId)
                    &&(document.getElementById(`cell-${cellXnr}-1`).data == data[i].employeeId)){
                    
                     myinput = document.getElementById(`input-${cellXnr}-${cellYnr}`);
                     myinput.value = data[i].count;
                     myinput.innerHTML = data[i].count;
                }
            }
        }
    }
}

function populateHoursNeeded(countingarrayforplan){

    let cellYnr, hoursneededcell, str;
    
    for(let i=0; i<tasksarrayforplan.length; i++){
        cellYnr=i+additionalRowCount;
        for(let j=0; j<countingarrayforplan.length; j++){
        
            hoursneededcell = document.getElementById(`cell-2-${cellYnr}`);
            hoursneededcell.style.backgroundColor = "rgb(217, 232, 218)";
            hoursneededcell.value = document.getElementById(`cell-1-${cellYnr}`).textContent * document.getElementById(`cell-3-${cellYnr}`).textContent;
            str = (hoursneededcell.value/60).toString();
            str = str.slice(0, (str.indexOf(".")) + 2); 
            hoursneededcell.textContent = str; 
        }
    }

}

function populateRemainingVolumes(employeearrayforplan){

    let cellYnr,cellXnr, remainingcell;
    let assignedtasks = 0;
    let totalvolumes;
    let colorthat;
    
    for(let y=0; y<tasksarrayforplan.length; y++){
        cellYnr=y+additionalRowCount;

        for(let x=0; x<employeearrayforplan.length; x++){
        cellXnr=x+additionalCollumnCountFront;

            if(document.getElementById(`input-${cellXnr}-${cellYnr}`) != null){
                mycount = document.getElementById(`input-${cellXnr}-${cellYnr}`).value;
                assignedtasks = assignedtasks + parseInt(mycount);
            }}
            remainingcell = document.getElementById(`cell-4-${cellYnr}`);
            
            totalvolumes = document.getElementById(`cell-3-${cellYnr}`).textContent;
            remainingcell.textContent = parseInt(totalvolumes) - assignedtasks;
            assignedtasks = 0;
            colorthat = parseInt(remainingcell.textContent);
            if (colorthat == 0 ) {
                remainingcell.style.backgroundColor = "rgb(150, 200, 74)";
            } else if (colorthat < 0 ) {
                remainingcell.style.backgroundColor = "yellow";
            } else {
                remainingcell.style.backgroundColor = "orange";
            }
    }
   
}

function calculateRemainingTimeAfterAdditional(employeearrayforplan){

    let cellYnr,cellXnr, remainingtimecell, myremainingtime;
    let usedminutes = 0;
    let mytotalusedminutes = 0;
    let myactivitytime;
    let colorthat;
    
    for(let x=0; x<employeearrayforplan.length; x++){
        cellXnr=x+additionalCollumnCountFront;

        for(let y=0; y<activitieslistforplan.length; y++){   
        cellYnr=y+tasksarrayforplan.length+additionalRowCount;

        if(document.getElementById(`cell-${cellXnr}-${cellYnr}`).value != null){

            myactivitytime = document.getElementById(`cell-${cellXnr}-${cellYnr}`).value;
            usedminutes = parseInt(myactivitytime);
            mytotalusedminutes = mytotalusedminutes + usedminutes;
            usedminutes=0;
        }
            remainingtimecell = document.getElementById(`cell-${cellXnr}-0`);
            myremainingtime = employeearrayforplan[x].minutes - mytotalusedminutes;
            remainingtimecell.textContent = myremainingtime;
            myremainingtime = 0;

            colorthat = parseInt(remainingtimecell.textContent);
            if (colorthat == 0 ) {
                remainingtimecell.style.backgroundColor = "rgb(150, 200, 74)";
                } else if (colorthat > 0 ) {
                    remainingtimecell.style.backgroundColor = "lightgreen";
                } else {
                    remainingtimecell.style.backgroundColor = "red";
                }
            }
            mytotalusedminutes =0;
        }
    }

function calculateRemainingTime(employeearrayforplan){

    let cellYnr,cellXnr, remainingtimecell, myremainingtime, remainingminutes;
    let targettime; 
    let usedminutes = 0;
    let mytotalusedminutes = 0;
    let mytaskcount;
    let colorthat;
    
    for(let x=0; x<employeearrayforplan.length; x++){
        cellXnr=x+additionalCollumnCountFront;

        for(let y=0; y<tasksarrayforplan.length; y++){   
        cellYnr=y+additionalRowCount;

        if(document.getElementById(`input-${cellXnr}-${cellYnr}`) != null){
            mytaskcount = document.getElementById(`input-${cellXnr}-${cellYnr}`).value;
            targettime = document.getElementById(`cell-1-${cellYnr}`).textContent;
            usedminutes = parseInt(targettime) * parseInt(mytaskcount);
            mytotalusedminutes = mytotalusedminutes + usedminutes;
            usedminutes =0;
        } 
            remainingtimecell = document.getElementById(`cell-${cellXnr}-0`);
            remainingminutes = document.getElementById(`cell-${cellXnr}-0`).textContent;
            myremainingtime = remainingminutes - mytotalusedminutes;
            mytotalusedminutes =0;
            remainingtimecell.textContent = myremainingtime;
            myremainingtime = 0;
            colorthat = parseInt(remainingtimecell.textContent);
            if (colorthat == 0 ) {
                remainingtimecell.style.backgroundColor = "rgb(150, 200, 74)";
                } else if (colorthat > 0 ) {
                    remainingtimecell.style.backgroundColor = "lightgreen";
                } else {
                    remainingtimecell.style.backgroundColor = "red";
                }
            }
            mytotalusedminutes =0;
        }
    }



function clearPlanGridValues(tasksarrayforplan, employeearrayforplan, activitieslistforplan){

    let rowcount = tasksarrayforplan.length+activitieslistforplan.length+additionalRowCount;
    let collumncount = employeearrayforplan.length + additionalCollumnCountFront+additionalCollumnCountBack;
    let plancell;
    
    for(let i =0; i<rowcount; i++){
            for( let j=0; j <collumncount; j++ ){
            plancell = document.getElementById(`cell-${j}-${i}`);
            plancell.parentNode.removeChild(plancell);
        }
    }
    console.log(`plano lentele isvalyta`)
}

let createupdateplanbutton = document.getElementById("savePlanButton");
createupdateplanbutton.addEventListener("click", createUpdatePlan);

async function createUpdatePlan(){
	

    await fetch(`http://localhost:8886/planning/api/plan/bydate/${mydateforplan}`,{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {

        if(data.length == 0){
            createNewPlan();
        }
        else{
            updateExistingPlan(data);

}
})

    document.getElementById("planPage").classList = "optionaldivvisible";  
}

async function createNewPlan(){

    let mydone =false;
    let mymarked = false;
    let mycount, myemployeeId, mytaskId, cellYnr, cellXnr, myinput;
    
    for(let x=0; x<employeearrayforplan.length; x++){
        for(let y=0; y<tasksarrayforplan.length; y++){
        cellYnr=y+additionalRowCount;
        cellXnr=x+additionalCollumnCountFront;
            for(let i=0; i<competenciesarrayforplan.length; i++){
                if((document.getElementById(`cell-0-${cellYnr}`).data == competenciesarrayforplan[i].taskId)
                    &&(document.getElementById(`cell-${cellXnr}-1`).data == competenciesarrayforplan[i].employeeId)){
                               
                     mycount = document.getElementById(`input-${cellXnr}-${cellYnr}`).value;
                    myemployeeId = competenciesarrayforplan[i].employeeId;
                    mytaskId = competenciesarrayforplan[i].taskId;
                    
                await fetch("http://localhost:8886/planning/api/plan/create",{
                    method: "POST",
                    headers: {
                        "Content-type": "application/json",
                        "Authorization":`Bearer `+`${localStorage.getItem("token")}`
                        },
                        body: JSON.stringify({taskId: mytaskId, date:mydateforplan, employeeId:myemployeeId,
                        count:mycount, marked: mymarked, done: mydone})
                        })
                    .then(res => res.json())
                }
            }
        }   
    }
}

async function updateExistingPlan(data){
    let mydone =false;
    let mymarked = false;
    let mycount, myemployeeId, mytaskId, cellYnr, cellXnr, myinput, myplanIDupdate;
  
    for(let x=0; x<employeearrayforplan.length; x++){
        for(let y=0; y<tasksarrayforplan.length; y++){
            cellYnr=y+additionalRowCount;
            cellXnr=x+additionalCollumnCountFront;
            for(let i=0; i<competenciesarrayforplan.length; i++){
                if((document.getElementById(`cell-0-${cellYnr}`).data == data[i].taskId)
                    &&(document.getElementById(`cell-${cellXnr}-1`).data == data[i].employeeId)){
                    
                        myinput = document.getElementById(`input-${cellXnr}-${cellYnr}`);
                        mycount = myinput.value;
                        myemployeeId = data[i].employeeId;
                         myplanIDupdate = data[i].id;
                        mytaskId = data[i].taskId;
                    
                     await fetch(`http://localhost:8886/planning/api/plan/${myplanIDupdate}`,{
                            method: "PUT",
                            headers: {
                                "Content-type": "application/json",
                                "Authorization":`Bearer `+`${localStorage.getItem("token")}`
                            },
                            body: JSON.stringify({id:myplanIDupdate, taskId: mytaskId, date:mydateforplan, employeeId:myemployeeId,
                                 count:mycount, marked: mymarked, done: mydone})
                        })
                    .then(res => res.json())
                }
            }
        }   
    }
}

