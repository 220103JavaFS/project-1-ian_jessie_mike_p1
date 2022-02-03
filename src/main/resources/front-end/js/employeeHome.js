let viewTicketBtn = document.getElementById('viewTicketBtn');
let newTicketBtn = document.getElementById('newTicketBtn');
let signoutLink = document.getElementById('signout');
let requestTbl = document.getElementById('tixTable');

const url = 'http://localhost:7000/';

viewTicketBtn.addEventListener('click', viewMyTickets);
newTicketBtn.addEventListener('click', createTicket);
signoutLink.addEventListener('click', signout);

async function viewMyTickets() {
  let response = await fetch(url + 'employee/tickets', {
    credentials: 'include',
  });

  if (response.status === 200) {
    let allMyTickets = await response.json();

    displayAllMyTix(allMyTickets);
  } else {
    console.log('Could not direct you to the correct page.');
  }
}

function displayAllMyTix(allMyTickets) {
  for (let ticket of allMyTickets) {
    //ticket is one object from 'allMyTickets
    let row = document.createElement('tr');

    let request = ticket.request; //returns object properties
    let type = ticket.type;
    let status = ticket.status;

    //create table elements
    let idData = document.createElement('td');
    let amountData = document.createElement('td');
    let descrData = document.createElement('td');
    let timeSubData = document.createElement('td');
    let timeResData = document.createElement('td');
    let typeData = document.createElement('td');
    let statusData = document.createElement('td');

    idData.innerText = request.reimbursement_ID;
    amountData.innerText = request.reimbursement_Amount;
    descrData.innerText = request.description;
    timeSubData.innerText = request.time_Submitted;
    timeResData.innerText = request.time_Resolved;
    typeData.innerText = type;
    statusData.innerText = status;

    //append td to row
    row.appendChild(idData);
    row.appendChild(amountData);
    row.appendChild(descrData);
    row.appendChild(timeSubData);
    row.appendChild(timeResData);
    row.appendChild(typeData);
    row.appendChild(statusData);

    requestTbl.appendChild(row);
  }
}

//button click redirects to new ticket page
function createTicket() {
  document.location.replace(url + 'html/newTicket.html');
}

// async function signout() {
//   let response = await fetch(url + 'signout', {
//     //find endpoint path
//     method: 'POST',
//     credentials: 'include',
//   });

//   if (response.status === 200) {
//     //if signout is successful, redirect to correct page
//     document.location.replace(url + 'login'); //add api
//   } else {
//     console.log(
//       'Error Status:' +
//         response.status +
//         'A problem occurred trying to signout.'
//     );
//   }
// }
