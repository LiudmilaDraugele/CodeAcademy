let mydatecountinginput = document.getElementById("dateForCountingInput");
let mydateforcounting;
let tasksarrayforcounting;
mydatecountinginput.addEventListener("change", () => {
    clearCountingGridValues();
    mydateforcounting = document.getElementById("dateForCountingInput").value.toString();
    console.log(mydateforcounting);
})
populateCountingGridWithTasks(mydateforcounting);

let mydatebutton = document.getElementById("getDateForCounting");
mydatebutton.addEventListener("click",checkIfCountingValuesExist);


async function populateCountingGridWithTasks() {

    await fetch("http://localhost:8886/planning/api/task/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        tasksarrayforcounting = data;
        let countinggrid = document.getElementById("countingGrid");
        for(let i =0; i<data.length; i++){
        
           let row = document.createElement("div");
           row.classList = "countingrow";
           row.id = "row-" + i+1;
           countinggrid.appendChild(row);

           let nameColumn = document.createElement("div");
           nameColumn.classList = "countingtitle";
           nameColumn.innerHTML=data[i].name;
           nameColumn.id = "nameColumn-" + i+1;
           row.appendChild(nameColumn);

        //    let countColumn = document.createElement("div");
        //    countColumn.id = "countColumn-" + task.id;
        //    row.appendChild(countColumn);

           let countInput = document.createElement("input");
           countInput.classList = "countingCountinput";
           countInput.id = "countInput-" + i+1;
           row.appendChild(countInput);

        //    let commentColumn =  document.createElement("div");
        //    commentColumn.id = "commentColumn-" + task.id;
        //    row.appendChild(commentColumn);

           let commentInput = document.createElement("input");
           commentInput.classList = "countingCommentinput";
           commentInput.id = "commentInput-" + i+1;
           row.appendChild(commentInput);
        }});
    
}

async function checkIfCountingValuesExist(){
   
    await fetch(`http://localhost:8886/planning/api/counting/bydate/${mydateforcounting}`,{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {

        if(data.length != 0){
            populateCountingGridWithValues(data);
        } 
        else{
            console.log("pasirinktai datai - irasu nerasta")
            clearCountingGridValues()
        }
            })
}

function populateCountingGridWithValues(data){
    let populatedcount;
    let populatedcomment;
    for(let i =0; i<data.length; i++){
        populatedcount = document.getElementById(`countInput-${i}1`);
        populatedcount.value = data[i].count;
        populatedcomment = document.getElementById(`commentInput-${i}1`);
        populatedcomment.value = data[i].comment;
        
    }
}

function clearCountingGridValues(){
    let countingcell;
    let commentcell;
    
    for(let i =0; i<tasksarrayforcounting.length; i++){
        countingcell = document.getElementById(`countInput-${i}1`);
        countingcell.value = "";
        commentcell = document.getElementById(`commentInput-${i}1`);
        commentcell.value = "";
        
    }
}

let createcounting = document.getElementById("createupdateCountingButton");
createcounting.addEventListener("click", createUpdateCounting);

async function createUpdateCounting(){
	
    await fetch(`http://localhost:8886/planning/api/counting/bydate/${mydateforcounting}`,{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {

        if(data.length == 0){
            createNewCounting();
        }
        else{
            updateExistingCounting(data);

}
})
    document.getElementById("caseCountingPage").classList = "optionaldivvisible";  
}

async function createNewCounting(){

    let taskidforcounting;
    let taskcount;
    let taskcomment;

    for(let i=0; i<tasksarrayforcounting.length; i++){

        taskidforcounting = tasksarrayforcounting[i].id;
        taskcount=document.getElementById(`countInput-${i}1`).value;
        taskcomment=document.getElementById(`commentInput-${i}1`).value;

    await fetch("http://localhost:8886/planning/api/counting/create",{
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
        body: JSON.stringify({taskId: taskidforcounting, date:mydateforcounting,
             count:taskcount, comment:taskcomment})
    })
    .then(res => res.json())

}
}

async function updateExistingCounting(data){

    let mycountingidupdate, mytaskidupdate, mytaskdateupdate, mytaskcountupdate, mytaskcommentupdate;

    for(let i=0; i<data.length; i++){
        mycountingidupdate = data[i].id;
        mytaskidupdate = data[i].taskId;
        mytaskdateupdate = data[i].date;
        mytaskcountupdate = document.getElementById(`countInput-${i}1`).value;
        mytaskcommentupdate = document.getElementById(`commentInput-${i}1`).value;

    await fetch(`http://localhost:8886/planning/api/counting/${mycountingidupdate}`,{
        method: "PUT",
        headers: {
             "Content-type": "application/json",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
        body: JSON.stringify({id:mycountingidupdate, taskId: mytaskidupdate, date: mytaskdateupdate,
            count:mytaskcountupdate, comment:mytaskcommentupdate})
       })
   .then(res => res.json())
    }
}


