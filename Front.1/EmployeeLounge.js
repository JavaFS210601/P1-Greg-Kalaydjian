const url = 'http://localhost:8080/P1-Greg-Kalaydjian/' //I grabbed this base URL from postman
//it's also what shows up when you run as server and get your 404 page
//Eventually, we'll use this base URL and make calls to the server by adding endpoints to it

//login functionality below-------------------------------------
//add functionality to our button using an event listener
document.getElementById('getPastTicketsButton').addEventListener('click', getPastTicketsFunc);
document.getElementById("createTicketButton").addEventListener('click', createTicketButtonFunc);
//so when this button gets clicked, the function called assembleFunc will run

//this function will get all avengers from our Java server
async function getPastTicketsFunc() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    //await makes the async functions wait until the promise returns with the fetched data
    let response = await fetch(url + 'getEmployeeReimbursements', {credentials: "include"});

    console.log(response);

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object


        //now, I want to put each avenger into my table
        for(let ers_reimbursement of data) { //for every avenger in the data variable/object

            console.log(ers_reimbursement); //just for debug, print the avenger in the console

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = ers_reimbursement.reimb_id; //fill the cell with avenger data
            row.appendChild(cell) //this row now has the first cell (av_id)

            //the we'll do this^ for each field in the avenger model
            let cell2 = document.createElement("td");
            cell2.innerHTML = ers_reimbursement.reimb_amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = ers_reimbursement.reimb_submitted;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = ers_reimbursement.reimb_resolved;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = ers_reimbursement.reimb_description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = ers_reimbursement.reimb_author;
            row.appendChild(cell6);

            let cell7 = document.createElement("td");
            cell7.innerHTML = ers_reimbursement.reimb_resolver;
            row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell8.innerHTML = ers_reimbursement.reimb_status_id;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = ers_reimbursement.reimb_type_id;
            row.appendChild(cell9);


            document.getElementById("pastTicketBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML
        }
    }
}

//this function will send the user-inputted login credentials to the server (For Employees)
async function createTicketButtonFunc() {

    //get the user inputs for the login
    let reimb_type_idVal = document.getElementById("typeID").value; 
    let reimb_amountVal = document.getElementById("requestAmount").value; 
    let reimb_descriptionVal = document.getElementById("descriptionText").value; 


    let reimb_json = {
        reimb_type_id:reimb_type_idVal ,
        reimb_amount:reimb_amountVal,
        reimb_description:reimb_descriptionVal
    }

    console.log(reimb_json);

    //now I'm going to set up my fetch request to the server
    //rememeber the second parameter a fetch() can take? 
    //a configuration object!! Essentially the settings of a fetch request
    //if you don't include a second param, it'll just send a GET request to the URL.
    let response = await fetch(url + "addErs_Reimbursement_Request", {

        method: "POST", //send as a POST request
        body: JSON.stringify(reimb_json), //turn into JSON
        credentials: "include" //this will ensure that the cookie is captured
                              //future fetches will also require this value to send the cookie back
        //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
        //Don't worry too much, we will learn Angular and life will be grand
    });

    console.log(response.status);

    //control flow based on success or failed login
    if(response.status === 200) {
        //this will wipe our login row, and welcome the user
        document.getElementById("typeID").value="Success";
        document.getElementById("requestAmount").value="Success";
        document.getElementById("descriptionText").value="Success";
 
    } else {
        document.getElementById("typeID").innerText="Ticket Creation Failed";
    }

}
