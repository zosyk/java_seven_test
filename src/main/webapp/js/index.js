var page = 0;


function createClient(name, surname, address, phone, createClientContainer) {

    if (createClientContainer.offsetHeight == 0) {
        createClientContainer.style.display = 'block';
        return;
    }

    if (validate(name.value, surname.value, address.value, phone.value)) {

        var client = {
            "name": name.value,
            "surname": surname.value,
            "address": address.value,
            "phone": phone.value
        };

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'post',
            url: '/createClient',
            data: JSON.stringify(client),
            complete: function () {
                console.log("in complete method, createCreditLine");
            },
            success: function () {
                loadClients();
                console.log("in success method, createCreditLine");
                createClientContainer.style.display = 'none';
                name.value = '';
                surname.value = '';
                address.value = '';
                phone.value = '';
            },
            error: function (jqXHR, testStatus, errorThrown) {
                console.log("in error method, error: " + errorThrown);
            }
        });
    }
}

function validate(name, surname, address, phone) {

    var result = true;
    var errorMes = "";

    if (name == '') {
        result = false;
        errorMes += "Enter your name\n";
    }
    if (surname == '') {
        result = false;
        errorMes += "Enter your surname\n";
    }
    if (surname == '') {
        result = false;
        errorMes += "Enter your address\n";
    }
    if (surname == '') {
        result = false;
        errorMes += "Enter your phone\n";
    }

    if (!result)
        alert(errorMes);

    return result;
}

function loadClients() {
    $.ajax({
        url: "/getAllClients?page=" + page,
        method: 'get',
        success: function (data) {
            callBackLoad(data)
        },
        error: function (jqXHR, testStatus, errorThrown) {
            console.log("in getAllClients method, error: " + errorThrown);
        }
    });
}

function callBackLoad(data) {
    console.log("success : getAll");

    var table = "<table class=' table '>";

    console.log("offset: " + data.offset + " , limit: " + data.limit + " , size: " + data.size);
    var size = data.clients.length;
    if (size == 0) {
        table += "<p class='no-client'>" + strings['no.clients'] + "</p>"
    }
    for (var i = 0; i != size; ++i) {
        if (i == 0) {
            table += "<tr><th>" + strings['name.label'] + "</th><th>" + strings['surname.label'] + "</th><th>" +
                strings['address.label'] + "</th><th>" + strings['phone.label'] + "</th><th>" + strings['edit.profile'] + "</th><th>" + strings['credit.info'] + "</th>"
        }

        var client = data.clients[i];

        table += "<tr><td>" + client.name + "</td><td>" + client.surname + "</td><td>" + client.address + "</td><td>" +
            client.phone + "</td><td>"
            +
            "<form method='post' action='/editProfile' id='edit-profile-form'>" +
            "<input type='hidden' name='id' id='id' value='" + client.id + "'>" +
            "<a href='javascript: submitEditProfileForm();' ><img border='0' src='../img/ic_edit_2.png' width='25' height='25'></a></form>"
            +
            "</td><td>" + strings['count.opened.line'] + client.countOpenedLine + strings['count.closed.line'] +
            client.countClosedLine
            +
            "<form method='post' action='/showCreditLines' id='show-credit-lines-form'>" +
            "<input type='hidden' name='id' id='id' value='" + client.id + "'>" +
            "<a href='javascript: submitShowCreditLinesForm();'>" + strings['show.history'] + "</a></form>"
            +
            "</td></tr>"
    }
    table += "</table>"
    drawPagination(data.offset, data.limit, data.size);

    // usersBlock.innerHTML = table;
    $('#clients_table').html(table);
    $('#client_name').val('');
    $('#client_surname').val('');
    $('#client_address').val('');
    $('#client_phone').val('');
}

function submitEditProfileForm() {
    $('#edit-profile-form').submit();
}

function submitShowCreditLinesForm() {
    $('#show-credit-lines-form').submit();
}

function drawPagination(offset, limit, size) {

    var table = "<table>";

    var size = size / limit;
    table += "<tr>";
    for (var i = 0; i < size; i++) {
        var pag = i + 1;
        table += "<td>" + "<a onclick='paginate(" + (i + 1) + ")'  id='pag' href=" + "#page" + (i + 1) + ">" + (i + 1) + "</a>" + "</td>";
    }
    table += "</tr>"
    table += "</table>"

    $('#pagination').html(table);

}

function paginate(pag) {
    page = pag - 1;
    loadClients();
}