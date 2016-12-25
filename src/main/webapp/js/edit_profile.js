
var errorMessage = "Internal error";


function updateClient(name, surname, address, phone){

    var result = true;
    var errorString = "Please recheck next fields: \n";
    if(name.val().trim().length == 0){
        errorString += "name\n";
        result = false;
        name.val("");
    }

    if(surname.val().trim().length == 0){
        errorString += "surname\n";
        result = false;
        surname.value = "";
    }

    if(address.val().trim().length == 0){
        errorString += "address\n";
        result = false;
        address.val("");
    }

    if(phone.val().trim().length == 0){
        errorString += "phone\n";
        result = false;
        phone.val("");
    }



    if(result == false){
        alert(errorString);
        return;
    }

    $('#update-client').submit();

}


