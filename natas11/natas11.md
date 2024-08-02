### Natas 11
Опять логинимся. Видим на странице, что куки зашифрованы XOR и поле для ввода. Смотрим исхзодный код.

``` php
<?
if($data["showpassword"] == "yes") {
    print "The password for natas12 is <censored><br>";
}

?>
```
Здесь мы видим что пароль становится доступен если значение из массива по ключу showpassword будет yes


```php
$data = loadData($defaultdata);
```
тут видим что массив data создаётся функцией loadData, в которую передаются данные по умолчанию.


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
данные загружаются из cookie, затем кодируются в base64 -> затем шифруются в XOR -> декодируются в формате JSON
_XOR-метод шифрования, заключающийся в "наложении" последовательности случайных чисел на открытый тект (ист.Википедия)_


```php
function xor_encrypt($in) {
    $key = '<censored>';
    $text = $in;
    $outText = '';

    // Iterate through each character
    for($i=0;$i<strlen($text);$i++) {
    $outText .= $text[$i] ^ $key[$i % strlen($key)];
    }

    return $outText;
}
```
наконец, все значения устанавливаются.

Что требуется сделать:

1. Расшифровать XOR
    - взять зашифрованные данные из куки
    - декодировать base64
    - закодировать данные по умолчанию в json-формат
    - проксорить полученные строки
2. Закодировать и зашифровать по обратному алгоритму новые данные
3. вставить новые данные в cookie и перезагрузить страницу

[//]: # (я нихуя не понимаю ч тут делать, ну вот не ебу)


вытаскваем такой куки: HmYkBwozJw4WNyAAFyB1VUcqOE1JZjUIBis7ABdmbU1GIjEJAyIxTRg%3D, затем декодим его в burp suit и получем: HmYkBwozJw4WNyAAFyB1VUcqOE1JZjUIBis7ABdmbU1GIjEJAyIxTRg=
декодируем из base64, а затем шифреуем в xor на cyberchef

после идём в любой онлайн-редактор пыхи (он же php) и вставляем данный код:
```php
<?php
$defaultdata = array( "showpassword"=>"no", "bgcolor"=>"#ffffff");
echo json_encode($defaultdata);
?>
```
на выходе в формате JSON: 
> {"showpassword":"no","bgcolor":"#ffffff"}

ВСТАВЛЯЕМ ЕГО И ПОЛУЧАЕМ:
eDWoeDWoeDWoeDWoeDWoeDWoeDWoeDWoeDWoeDWoe

ПОЛЕ СНОВА - XOR -> base64:
