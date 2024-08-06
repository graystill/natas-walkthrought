## Natas 8
Логинимся.
На сайте видим +- то же самое что и на 6 уровне. Просматриваем код.
Натыкаемся на это

```
<?

$encodedSecret = "3d3d516343746d4d6d6c315669563362";

function encodeSecret($secret) {
    return bin2hex(strrev(base64_encode($secret)));
}

if(array_key_exists("submit", $_POST)) {
    if(encodeSecret($_POST['secret']) == $encodedSecret) {
    print "Access granted. The password for natas9 is <censored>";
    } else {
    print "Wrong secret";
    }
}
?>
```

Нам дают что-то закодированное таким способом: закодировали base64, затем строку перевернули и перервели из бинарного вида в hex-представление, следовательно, чтобы декордировать это нам требуется сделать то же самое, но в обратной последловательности

пишем декодер (в итоге должно получится oubWYF2kBq). Как только вводим расшифрованный секрет в поле, сайт нам выводит:
> Access granted. The password for natas9 is ZE1ck82lmdGIoErlhQgWND6j2Wzz6b6t 