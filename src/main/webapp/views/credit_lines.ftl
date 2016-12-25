<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><@spring.message "credit.lines.title"/></title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="../js/credit_lines.js"></script>
    <link rel="stylesheet" href="../css/credit_lines.css">
    <link rel="stylesheet" href="../css/style.css">
    <link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>

<div class="title"><h4><@spring.message "credit.lines.of"/>${client.name} ${client.surname}</h4></div>

<div id="clients_table" class="container cards-table all-cards-empty-text">

</div>

<div id="pagination" class="center">


</div>

<div class="form">


    <div id="create-new-credit-line-container">
        <label for="ended_time"><@spring.message "choose.ended.time"/></label>
        <input type="date" name="ended_time" id="ended_time" value="2017-03-08" required
        />
    </div>

    <input type="button" class="btn btn-success btn-create-new-client"
           value="<@spring.message "create.new.credit.line"/>"
           onclick="return createCreditLine(
                   document.getElementById('ended_time'),
                   document.getElementById('create-new-credit-line-container'),
           ${client.id})">

</div>

<script type="text/javascript">
    loadCredits(${client.id});

    var strings = new Array();

    strings['credit.lines.opened'] = "<@spring.message "credit.lines.opened"/>";
    strings['no.credit.line'] = "<@spring.message "no.credit.line"/>";
    strings['credit.number'] = "<@spring.message "credit.number"/>";
    strings['open.date'] = "<@spring.message "open.date"/>";
    strings['close.date'] = "<@spring.message "close.date"/>";
    strings['condition'] = "<@spring.message "condition"/>";
    strings['show.payments'] = "<@spring.message "show.payments"/>";
    strings['credit.lines.show'] = "<@spring.message "credit.lines.show"/>";
    strings['error.end.time'] = "<@spring.message "error.end.time"/>";

</script>

</body>
</html>
