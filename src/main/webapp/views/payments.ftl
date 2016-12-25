<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Payments</title>
    <link rel="stylesheet" href="../css/payments.css">
    <link rel="stylesheet" href="../css/style.css">
    <link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>

<div class="payments-container">

    <div class="title"><h4>Credit №: ${credit_number}</h4></div>


    <table class="table">

        <tr>
            <th>Payment №</th>
            <th>Sum</th>
            <th>Payment date</th>
        </tr>
    <#list payments as payment>
        <tr>
            <td>${payment_index + 1}</td>
            <td>${payment.sum} $</td>
            <td>${payment.paymentDate}</td>
        </tr>
    </#list>
    </table>

</div>

</body>
</html>
