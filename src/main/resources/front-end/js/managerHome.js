var selectBtn = document.getElementById('filterSelect');
var signoutLink = document.getElementById('signout');
let requestTbl = document.getElementById('tixTable');
const url = 'http://localhost:8080/';

signoutLink.addEventListener('click', signout);
selectBtn.addEventListener('click', selectTicketOpt);

async function selectTicketOpt() {
  const option = selectBtn.value; //value attribute for each <option>
  switch (
    option //switch cases for select filter options
  ) {
    case 'all': // trigger different filter functions
      getAllTix();
      break;
    case 'approved':
      getApproved();
      break;
    case 'denied':
      getDenied();
      break;
    case 'pending':
      getPending();
      break;
  }
}

//returns all reimbursments
async function getAllTix() {
  console.log('running get All');
  let response = await fetch(url + 'manager/reimbursements', {
    credentials: 'include',
  });

  if (response.status === 200) {
    let tickets = await response.json();
    console.log(tickets);
    displayRequests(tickets); //calls function to display on table
  } else {
    console.log('Error occurred returning tickets');
  }
}

//returns all approved reimbursments
async function getApproved() {
  console.log('running get approved');
  let response = await fetch(url + 'manager/reimbursements/filter/approved', {
    credentials: 'include',
  });

  if (response.status === 200) {
    let tickets = await response.json();
    console.log(tickets);
    displayRequests(tickets);
  } else {
    console.log('Error occurred returning tickets');
  }
}

//returns all denied reimbursments
async function getDenied() {
  console.log('running get denied');
  let response = await fetch(url + 'manager/reimbursements/filter/denied', {
    credentials: 'include',
  });

  if (response.status === 200) {
    let tickets = await response.json();
    console.log(tickets);
    displayRequests(tickets);
  } else {
    console.log('Error occurred returning tickets');
  }
}

//returns all pending reimbursments
async function getPending() {
  console.log('running get pending');
  let response = await fetch(url + 'manager/reimbursements/filter/pending', {
    credentials: 'include',
  });

  if (response.status === 200) {
    let tickets = await response.json();
    console.log(tickets);
    displayRequests(tickets);
  } else {
    console.log('Error occurred returning tickets');
  }
}

//handles formatting data returned
async function displayRequests(Tickets) {
  requestTbl.innerHTML = '';
  for (let ticket of Tickets) {
    //loop through each request
    let row = document.createElement('tr');

    //returns object properties: request, type, status, user
    let request = ticket.request;
    let type = ticket.type;
    let status = ticket.status;
    let user = ticket.user;

    //create table data
    let idData = document.createElement('td');
    let firstNameData = document.createElement('td');
    let lastNameData = document.createElement('td');
    let amountData = document.createElement('td');
    let descrData = document.createElement('td');
    let timeSubData = document.createElement('td');
    let timeResData = document.createElement('td');
    let typeData = document.createElement('td');
    let statusData = document.createElement('td');

    //insert each data key into corresponding row and column
    let reimID = request.reimbursement_ID;
    idData.innerText = reimID;
    firstNameData.innerText = user.user_First_Name;
    lastNameData.innerText = user.user_Last_Name;
    amountData.innerText = request.reimbursement_Amount;
    descrData.innerText = request.description;
    timeSubData.innerText = request.time_Submitted;
    timeResData.innerText = request.time_Resolved;
    typeData.innerText = type;
    statusData.innerText = status;

    //appends all to row
    row.appendChild(idData);
    row.appendChild(firstNameData);
    row.appendChild(lastNameData);
    row.appendChild(amountData);
    row.appendChild(descrData);
    row.appendChild(timeSubData);
    row.appendChild(timeResData);
    row.appendChild(typeData);

    if (status == 'pending') {
      //create buttons to attach to pending requests
      let approveBtn = document.createElement('button');
      approveBtn.innerText = 'Approve';
      let denyBtn = document.createElement('button');
      denyBtn.innerText = 'Deny';

      //add buttons to status column
      statusData.appendChild(approveBtn);
      statusData.appendChild(denyBtn);
      row.appendChild(statusData);

      approveBtn.setAttribute('type', 'button');
      denyBtn.setAttribute('type', 'button');
      approveBtn.setAttribute('status', status);
      denyBtn.setAttribute('status', status);
      approveBtn.setAttribute('id', reimID);
      denyBtn.setAttribute('id', reimID);

      //update request status by button
      approveBtn.addEventListener('click', function () {
        updateStatus(reimID, 'approved');
      });
      denyBtn.addEventListener('click', function () {
        updateStatus(reimID, 'denied');
      });
    } else if (status != 'pending') {
      row.appendChild(statusData);
    }

    //add to table body
    requestTbl.appendChild(row);
  }
}

async function updateStatus(reimID, status) {
  let response = await fetch(
    url + 'manager/reimbursements/request/' + reimID + ':' + status,
    {
      method: 'PUT',
      credentials: 'include',
    }
  );
  if (response.status === 200) {
    document.location.reload();
    console.log('Okay' + response.status);
  } else {
    console.log('Error Status:' + response.status);
  }
}
