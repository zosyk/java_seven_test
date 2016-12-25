function createCreditLine(closeDate, createCreditLinesContainer, clientId) {

    if (new Date(closeDate.value).getTime() < new Date().getTime()) {
        alert(strings['error.end.time']);
        return;
    }

    if (createCreditLinesContainer.offsetHeight == 0) {
        createCreditLinesContainer.style.display = 'block';
        return;
    }

    var credit = {
        "closeDate": new Date(closeDate.value).getTime(),
        "clientId": clientId,
        "condition": strings['credit.lines.opened']
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'post',
        url: '/createCreditLine',
        data: JSON.stringify(credit),
        complete: function () {
            console.log("in complete method, createCreditLine");
        },
        success: function () {
            loadCredits(clientId);
            console.log("in success method, createCreditLine");
            createCreditLinesContainer.style.display = 'none';
        },
        error: function (jqXHR, testStatus, errorThrown) {
            console.log("in error method, error: " + errorThrown);
        }
    });
}


function loadCredits(clientId) {
    $.ajax({
        url: "/getAllCredits?id=" + clientId,
        method: 'get',
        success: function (data) {
            callBackLoad(data)
        },
        error: function (jqXHR, testStatus, errorThrown) {
            console.log("in getAllCredits method, error: " + errorThrown);
        }
    });
}

function callBackLoad(data) {

    var table = "<table class=' table '>";
    var credits = data.credits;
    var size = credits.length;
    if (size == 0) {
        table += "<p class='no-client'>" + strings['no.credit.line'] + "</p>"
    }
    for (var i = 0; i != size; ++i) {
        if (i == 0) {
            table += "<tr><th>" + strings['credit.number'] + "</th><th>" + strings['open.date'] + "</th><th>" + strings['close.date'] + "</th><th>" +
                strings['condition'] + "</th><th>" + strings['show.payments'] + "</th></th>"
        }

        var credit = credits[i];
        var date = new Date(credit.openDate);
        var openDateToString = date.getDate() + "." + (date.getMonth() + 1) + "." + date.getFullYear();
        date = new Date(credit.closeDate);
        var closeDateToString = date.getDate() + "." + (date.getMonth() + 1) + "." + date.getFullYear();

        table += "<tr><td>" + (i + 1) + ".</td><td>" + openDateToString + "</td><td>" + closeDateToString + "</td><td>" + credit.condition + "</td><td>"
            +
            "<form method='post' action='/showPayments' id='show-payments-form'>" +
            "<input type='hidden' name='id' value='" + credit.id + "'>" +
            "<input type='hidden' name='credit_number' value='" + (i + 1) + "'>" +
            "<a href='javascript: submitShowPaymentsForm();'>" + strings['credit.lines.show'] + "</a></form>"
            + "</td></tr>"
    }
    table += "</table>"

    $('#clients_table').html(table);
}

function submitShowPaymentsForm() {
    $('#show-payments-form').submit();
}
