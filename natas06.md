### Natas 6

Логинимся. Страничка говорит нам ввести некий секрет и даёт нам посмотреть свой исходный код, просматриваем его. Нас интересует следующее:
```
<?

include "includes/secret.inc";

    if(array_key_exists("submit", $_POST)) {
        if($secret == $_POST['secret']) {
        print "Access granted. The password for natas7 is <censored>";
    } else {
        print "Wrong secret";
    }
    }
?>
```
заостряем внимаение на этом:

``` 
include "includes/secret.inc
```

вставляем это в ссылку, переходим пор ней и находим тот самый секрет, копируем его и вписываем его в поле для ввода.

затем находим пароль для natas7

> Access granted. The password for natas7 is bmg8SvU1LizuWjx3y7xkNERkHxGre0GS