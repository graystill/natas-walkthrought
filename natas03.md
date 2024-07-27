### Natas 3

Логинимся, на сайте видим надпись "There is nothing on this page" _(пер.: На этой странице ничего нет)_, смотрим исходный код и видим сей комментарий:

> <!-- No more information leaks!! Not even Google will find it this time... -->
_(пер.: Больлше никаких утечек!! Даже через Google вы их не найдёте)_

Запускаем сканирование файлов и директорий.

#### Через DIRB 
```
dirb http://natas3.natas.labs.overthewire.org/ -u natas3:3gqisGdR0pjm6tpkDKdIWO2hSvchLeYH
```
через совсем чуть-чуть времени получаем вот такой ответ:

> Scanning URL: http://natas3.natas.labs.overthewire.org/ ----
> http://natas3.natas.labs.overthewire.org/cgi-bin/ (CODE:403|SIZE:298)                               
> http://natas3.natas.labs.overthewire.org/index.html (CODE:200|SIZE:923)                             
> http://natas3.natas.labs.overthewire.org/robots.txt (CODE:200|SIZE:33)                              
> http://natas3.natas.labs.overthewire.org/server-status (CODE:403|SIZE:298)

нас итересует эта строка: http://natas3.natas.labs.overthewire.org/robots.txt (CODE:200 SIZE:33)

переходим по ссылке и видим:
> User-agent: *
> Disallow: /s3cr3t/

идём в директорию в s3cr3t и видим файл users.txt, идёь туда и получаем пароль уже от 4 уровня

> natas4:QryZXc2e0zahULdHrtHxzyYkj59kUxLQ

_впринципе это +- такое же действие можно провернуть и через другие подобные интсрументы типо gobuster_