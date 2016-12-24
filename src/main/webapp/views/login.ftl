<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>West bank</title>

    <link href="../css/bootstrap.css" rel="stylesheet"/>
    <link href="../css/custom_input.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="../js/customInput.js" type="text/javascript"></script>
    <script type="text/javascript" src="../js/custom/index.js"></script>

    <link href="../css/login.css" rel="stylesheet"/>

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>

<body>

<div class="main">
    <div class="header">
        <h1>West Bank</h1>
    </div>
    <div class="btn_style">
        <@spring.message "language.text"/> : <a href="?lang=en"><img src="../img/ic_en.jpg" width="30" height="20"></a>
        <a href="?lang=ru"><img src="../img/ic_ru.png" width="30" height="20"></a>
    </div>
    <div class="icons">
        <div class="feature">
            <div class="icon    statements"></div>
            <div class="title"><@spring.message "statements.of.card"/></div>
            <div><@spring.message "controll.cash.flow"/> </div>
        </div>
        <div class="feature">
            <div class="icon mobile"></div>
            <div class="title"><@spring.message "recharge.mobile"/> </div>
            <div><@spring.message "mobile.operations"/> </div>
        </div>
        <div class="feature">
            <div class="icon utilities"></div>
            <div class="title"><@spring.message "regular.utilities"/> </div>
            <div><@spring.message "automatic.payment"/> </div>
        </div>
        <div class="feature">
            <div class="icon translation"></div>
            <div class="title"><@spring.message "translations.worldwide"/></div>
            <div><@spring.message "on.the.card.visa"/></div>
        </div>
        <div class="feature">
            <div class="icon deposits"></div>
            <div class="title"><@spring.message "deposits.text"/> </div>
            <div><@spring.message "remotely.open.with"/> </div>
        </div>
    </div>


    <div class="action-container">
        <div class="action-form">

            <form action="/j_spring_security_check" method="post">

                <#if error??>
                    <!-- Display error message -->
                    <div class="error">
                        <#--<@spring.message "error.login.attempt.not.successful"/>-->
                            ${error}
                        <br/>
                    </div>
                </#if>

                <h2 class="form-signin-heading"><@spring.message "please.sign.in"/> </h2>

                <div class="field">

                    <label for="j_username" class="field-label"><@spring.message "email.label"/> </label>

                    <input type="text" class="field-input" id="j_username" name="j_username" required autofocus
                           value="">

                </div>

                <div class="field">

                    <label for="j_password" class="field-label"><@spring.message "password.label"/> </label>

                    <input type="password" class="field-input" id="j_password" name="j_password" required value="">


                </div>

                <button class="btn  btn-lg btn-primary btn-block form-item-margin-top" type="submit"><@spring.message "signin.button"/> </button>
            </form>
            <form action="/registration/" method="get">
                <button class="btn btn-lg btn-primary btn-block form-item-margin-top" type="submit" id="btn_reg">
                    Registration
                </button>
            </form>

        </div>

    </div>
</div>

</body>
</html>
