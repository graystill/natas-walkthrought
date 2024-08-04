### Natas 11

Логинимся. Сайт говорит, что куки зашифрованы через XOR, ещё есть поле для ввода, где возможно менять цвет задника и возможность просмотреть исходный код.

```php
if($data["showpassword"] == "yes") {
    print "The password for natas12 is <censored><br>";
}
```
 Видим, что если showpassword в массиве data будет иметь значение yes, то нам покажут пароль.

 ```php
 $data = loadData($defaultdata);
 ```
 data - массив, созданный функцией loadData, принимающтй на вход 

```php
$defaultdata = array( "showpassword"=>"no", "bgcolor"=>"#ffffff");
```
defaultdata - строка, где ключу showpassword присвоено значение no, а bgcolor значение ffffff

```php
function loadData($def) {
    global $_COOKIE;
    $mydata = $def;
    if(array_key_exists("data", $_COOKIE)) {
    $tempdata = json_decode(xor_encrypt(base64_decode($_COOKIE["data"])), true);
    if(is_array($tempdata) && array_key_exists("showpassword", $tempdata) && array_key_exists("bgcolor", $tempdata)) {
        if (preg_match('/^#(?:[a-f\d]{6})$/i', $tempdata['bgcolor'])) {
        $mydata['showpassword'] = $tempdata['showpassword'];
        $mydata['bgcolor'] = $tempdata['bgcolor'];
        }
    }
    }
    return $mydata;
}
```
рассмотрим функцию loadData, у которой есть параметр def. Так же эта функция работает с cookie (а это подсказка откуда начинать). Затем переменной mydata присваевается параметр def. Затем проверяет есть ли в массиве cookie ключ data, если да, то кодирует его в base64, шифрует xor и декодирует в формате json. Это всё, что нам требуется ~~(на данный момент, может оно потом дополнятся будет)~~.

1. Вытаскиваем куки. Лично у меня он такой: HmYkBwozJw4WNyAAFyB1VUcqOE1JZjUIBis7ABdmbU1GIjEJAyIxTRg%3D. %3D это как правило URL-шифрование, заменяем его на = и получется: HmYkBwozJw4WNyAAFyB1VUcqOE1JZjUIBis7ABdmbU1GIjEJAyIxTRg=.
[//]: # ( сча как дома буду, начну думать над решенем
1 - understand what that original "clear text" value is.
2 - understand XOR encryption: no need to dive deep into the mathematical properties of the XOR operator: you need to focus on the relations between clear text, cipher text and key.
3 - apply this knowledge to get the missing part of the source code
4 - use that missing part to make that script do what you want.)