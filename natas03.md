# Natas 3
<kbd>Username</kbd> natas3

<kbd>Password</kbd> 3gqisGdR0pjm6tpkDKdIWO2hSvchLeYH

<kbd>Flag</kbd> QryZXc2e0zahULdHrtHxzyYkj59kUxLQ

Заходим на сайт. На странице ничего. Смотрим исходный код. Там особо ничего нет, но привлекое внимание данный комментарий:
```html
<!-- No more information leaks!! Not even Google will find it this time... -->
```
Если сделать базовый поиск и прочесть пару интервнет-статей, то можно наткнуться на упоминание robots.txt _(файл, который индексирует поисковую выдачу, исключая страницы из поиска, которые там указаны)_. Внутри:
> User-agent: *
>
> Disallow: /s3cr3t/

Переходим в /s3cr3t/. Там тоже файл users.txt в котором и есть наш флаг:
> natas4:QryZXc2e0zahULdHrtHxzyYkj59kUxLQ