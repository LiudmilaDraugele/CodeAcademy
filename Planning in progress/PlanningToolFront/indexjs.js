let loginbutton = document.getElementById("loginbutton");
loginbutton.addEventListener("click", check);
loginbutton.addEventListener("click", savedata);
loginbutton.addEventListener("click", logIn);

let shortnames = [];

async function savedata(){
    
    let myshortname = document.getElementById("shortname").value;
    myshortname = myshortname.toString().toUpperCase();
    let myrole;
    await fetch("http://localhost:8886/planning/api/employee/all")
    .then(res => res.json())
    .then( data => data.forEach(element => {
        if (myshortname == element.shortname){
            localStorage.setItem('user', element.shortname);
            localStorage.setItem('userid',element.id);
            myrole = element.role.name;
            localStorage.setItem('userrole', myrole)
        }
    }))
}


// async function savedata(e){
//     e.preventDefault();
//     let myshortname = document.getElementById("shortname").value
//     myshortname = myshortname.toString().toUpperCase();
//     let myrole;
//     await fetch("http://localhost:8886/planning/api/employee/all")
//     .then(res => res.json())
//     .then( data => data.forEach(element => {

//         console.log(element)
//         if ((myshortname == element.shortname)){
//             localStorage.setItem('user', element.shortname);
//             localStorage.setItem('employeename', element.name);
//             localStorage.setItem('userid', element.id);
//             myrole = element.role.name;
//             console.log(myrole)
//             localStorage.setItem('userrole', myrole)
//         }
//         // else{
//         // let errormessage = document.getElementById("errormessage-disabled");
//         // errormessage.style.display="block";
//         // }
//     }))
// }

fetch(`http://localhost:8886/planning/api/employee/all`)
.then (res => res.json())
.then(data => data.forEach (element => {
    shortnames.push(element.shortname)
}))

async function logIn(e){
    e.preventDefault();
    let myshortname = document.getElementById("shortname").value
    myshortname= myshortname.toString().toUpperCase();
    let mypassword = document.getElementById("password").value;
    
    await fetch("http://localhost:8886/planning/api/auth/login",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        
        },
        body:JSON.stringify({shortname:myshortname, password:mypassword})
    })
    .then(res => 
        {
            if (res.status==200) {
                res.text().then(tokenBody => {
                    localStorage.setItem('token', tokenBody);
                    localStorage.setItem('shortname', myshortname)
                    console.log(`user ${myshortname} got to another window`);
                    window.location.assign("http://127.0.0.1:3000/PlanningToolFront/PlanningTool/indexpage.html");
            })}
else{
    let errormessage = document.getElementById("errormessage");
            errormessage.style.display="block";
            console.log("user error message!");
}});
}

function check(e){
    e.preventDefault();
    let myshortname = document.getElementById("shortname").value
    myshortname= myshortname.toString().toUpperCase();
    if(shortnames.includes(myshortname)){

    }
    else{
        let errormessage = document.getElementById("errormessage");
        errormessage.style.display="block"; 
    }
}

        



