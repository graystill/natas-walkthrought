# Natas 6
<kbd>Username</kbd> natas6

<kbd>Password</kbd> 0RoJwHdSKWFTYR5WuiAewauSuNaBXned

<kbd>Flag</kbd> bmg8SvU1LizuWjx3y7xkNERkHxGre0GS

Видим поле для ввода, которое предлагает нам ввести некий секрет, а так же нас дают просмотреть исходный код на отдельной странице.

#### Проанализируем код на php построчно:

```php
include "includes/secret.inc";
```
include в php подключает внешние файлы, ну и видим сурс самого файла

```php
if(array_key_exists("submit", $_POST)) 
```
Здесь идёт проверка существует ли ключ submit в массиве POST

```php
if($secret == $_POST['secret']) {
        print "Access granted. The password for natas7 is <censored>";
```
И ещё одно условие, проверяющее, соответствует ли переменная secret ключу secret внутри массива POST, если да, то нам выдадут пароль для natas7

#### Далее:
Переходим в файл который импотировали и смотрим его исходный код. Там и есть тот самый секрет.
>
>$secret = "FOEIUWGHFEEUHOFUOIU";

Копируем и втавляем в поле для ввода, забираем пароль.