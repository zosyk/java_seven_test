<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><@spring.message "edit.profile.title"/></title>

    <link href="../css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="../js/edit_profile.js"></script>

    <link href="../css/edit_profile.css" rel="stylesheet">

    <link href="../css/custom_input.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="../js/customInput.js" type="text/javascript"></script>
</head>

<body class="main">

<div class="container">
    <form action="/" method="post" id="update-client">
        <h2 class="form-signin-heading"><@spring.message "edit.profile.title"/></h2>

        <div class="field">

            <label for="name" class="field-label"><@spring.message "your.name"/></label>

            <input type="text" class="field-input" name="name" id="name" autofocus value="${client.name}">

        </div>

        <div class="field">

            <label for="surname" class="field-label"><@spring.message "your.surname"/></label>

            <input type="text" class="field-input" name="surname" id="surname"  value="${client.surname}">


        </div>

        <input type="hidden" name="id" id="id"  value="${client.id}">

        <div class="field">

            <label for="address" class="field-label"><@spring.message "your.address"/></label>

            <input type="text" class="field-input" name="address" id="address" value="${client.address}">

        </div>

        <div class="field">

            <label for="phone" class="field-label"><@spring.message "your.phone"/></label>

            <input type="phone" class="field-input" name="phone" id="phone" value="${client.phone}">


        </div>


        <button class="btn btn-lg btn-primary btn-block form-item-margin-top"
                onclick="updateClient($('#name'), $('#surname'), $('#address'), $('#phone'))"
                type="button"><@spring.message "btn.update.text"/>
        </button>
    </form>

</div>

<script type="text/javascript">
    $(".field-input").parent().addClass("has-label");
</script>

</body>
</html>
