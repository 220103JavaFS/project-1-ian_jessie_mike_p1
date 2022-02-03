var selectBtn = document.getElementById('typeSelect');
var submitBtn = document.getElementById('submitBtn');
submitBtn.addEventListener('click', submitRequest);
const url = 'http://localhost:8080/';

//submitting new reimburs request
async function submitRequest() {
  //convert select option values to match type ID
  let option = selectBtn.value;
  if (option === 'lodging') {
    option = 1;
  } else if (option === 'travel') {
    option = 2;
  } else if (option == 'food') {
    option = 3;
  } else {
    option = 4;
  }
  //date variable for timestamps
  var today = new Date();
  var date =
    today.getFullYear() +
    '-' +
    (today.getMonth() + 1) +
    '-' +
    today.getDate() +
    ' ' +
    today.getHours() +
    ':' +
    today.getMinutes() +
    ':' +
    today.getSeconds();
  //create object for new request
  let request = {
    reimbursement_Amount: document.getElementById('reimbursAmount').value,
    time_Submitted: date,
    time_Resolved: null, //null data for fields that will later be updated
    description: document.getElementById('reimbursDesc').value,
    reciept: null,
    author_ID: null,
    resolver_ID: null,
    status_ID: null,
    type_ID: option,
  };

  let response = await fetch(url + 'employee/submit', {
    method: 'POST',
    body: JSON.stringify(request),
    credentials: 'include',
  });

  if (response.status === 200) {
    document.location.replace(url + 'html/employeeHome.html');
  } else {
    console.log('Error Status:' + response.status);
  }
}
