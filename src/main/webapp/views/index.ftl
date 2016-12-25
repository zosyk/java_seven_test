<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="../js/index.js"></script>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/style.css">
    <link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>

<div class="navigation-bar">
    <a class="navbar-item" href="/logout"><@spring.message "log.out"/></a>
    <a href="?lang=en"><img src="../img/ic_en.jpg" width="30" height="20"></a>
    <a href="?lang=uk"><img src="../img/ic_uk.png" width="30" height="20"></a>
    <a href="?lang=ru"><img src="../img/ic_ru.png" width="30" height="20"></a>
</div>

<div class="title"><h4><@spring.message "bank.clients"/></h4></div>

<div id="clients_table" class="container cards-table all-cards-empty-text">

</div>
<div id="pagination" class="center">


</div>

<div class="form">

    <div id="create-new-client-container">
        <input type="text" name="client_name" id="client_name" required placeholder="<@spring.message "enter.name"/>"/>
        <input type="text" name="client_surname" id="client_surname" required placeholder="<@spring.message "enter.surname"/>"/>
        <input type="text" name="client_address" id="client_address" required placeholder="<@spring.message "enter.address"/>"/>
        <input type="text" name="client_phone" id="client_phone" required placeholder="<@spring.message "enter.phone"/>"/>

    </div>

    <input type="button" class="btn btn-success btn-create-new-client" value="Create new client" onclick="return createClient(
                                                                             document.getElementById('client_name'),
                                                                             document.getElementById('client_surname'),
                                                                             document.getElementById('client_address'),
                                                                             document.getElementById('client_phone'),
                                                                             document.getElementById('create-new-client-container'))">

</div>

<script type="text/javascript">
    loadClients();
</script>


<script type="text/javascript">
    var strings = new Array();
    strings['name.label'] = "<@spring.message "name.label"/>";
    strings['surname.label'] = "<@spring.message "surname.label"/>";
    strings['address.label'] = "<@spring.message "address.label"/>";
    strings['phone.label'] = "<@spring.message "phone.label"/>";
    strings['create.new.client'] = "<@spring.message "create.new.client"/>";
    strings['credit.line.info'] = "<@spring.message "credit.line.info"/>";
    strings['no.clients'] = "<@spring.message "no.clients"/>";
    strings['show.history'] = "<@spring.message "show.history"/>";
    strings['count.opened.line'] = "<@spring.message "count.opened.line"/>";
    strings['count.closed.line'] = "<@spring.message "count.closed.line"/>";
    strings['edit.profile'] = "<@spring.message "edit.profile.title"/>";
    strings['credit.info'] = "<@spring.message "credit.info"/>";
</script>

</body>
</html>
