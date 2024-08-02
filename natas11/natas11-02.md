### Natas 11
Логинимся. Видим что на странчке можно менять цвет и то, что куки теперь зашифрованы через XOR. Смотрим исходный код.
Разберём код построчно.

```php
$defaultdata = array( "showpassword"=>"no", "bgcolor"=>"#ffffff");
```
У нас есть переменная defaultdata, которой присвоена строка, в ней ключу showpassword присвоено значение no и цыет заднего фона поставлен белым.

```php
if($data["showpassword"] == "yes") {
    print "The password for natas12 is <censored><br>";
}
```
Здесь есть условие что если у ключа showpassword значените yes, то оно покажет нам пароль для следующего уровня

```php
$data = loadData($defaultdata)
```
Видим что в переменную data вложена функция loadData _(она обрабатывает или закгружает передаваемые ей в параметре данные)_, которые она берёт из defaultdata

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
Просматриваем функцию loadData. В качестве паараметра ей передаётся некий def, внутри же она читает cookie, так же есть переменная mydata, которой присвается def. 
После идёт проверка условия существует ли в массиве cookie ключ data, если да то: кодирует в формате base64 -> шифрует методом xor -> декодирует это в формат json, что сохраняется в переменной tempdata. 
После идёт ещё одна проверка на наличие в массиые tempdata ключей showpassword и bgcolor, если есть то showpassword и bgcolor уходя в массив mydata, после чего функция возвращает mydata.

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
так же можнопросмгтреть на функцию, овечающую за шифрование. Ей на вход подаётся параметр in, так же переменным key, text, outText присвоены следующие значения <censored>, in и ''.
Ещё есть цикл, который и отвечает за шифрование, после чего функия возвращает нам outText

В конце концов, заглядываем сайту под капот через дев-тулсы и достаём куки с графы data. Лично у меня оно такое: HmYkBwozJw4WNyAAFyB1VUcqOE1JZjUIBis7ABdmbU1GIjEJAyIxTRg%3D, но после убираем %3D, заменяя его на "=".

Идём в cyberchef.com, в поде инпут вставляем наш куки
Сначала декриптим Base64 -> XOR с ключом {"showpassword":"no","bgcolor":"#ffffff"} и кодировкой UTF-8. 
Затем полученный XOR-ключ с той-же UTF-8 мешаем с инпутом {"showpassword":"yes","bgcolor":"#ffffff"} и кодируем в base64. Вуаля! На выходе у нас есть готовый куки: P3UcDSsgHwQ3JBgKNjNNX2YuChZme00HIzQACSslTV9mdAkDIjEJA2Yq
Переходим на сайт и через девтулс заменяем наш куки-файл. Если обновить страницу, то у нас будет пароль от следующего уровня

[//]: # (я нихуя не понимаю ч тут делать, ну вот не ебу, надо в дискорд будет напаисать)