# Natas 7
<kbd>Username</kbd> natas7

<kbd>Password</kbd> bmg8SvU1LizuWjx3y7xkNERkHxGre0GS

<kbd>Flag</kbd> xcoXLmzMkoIP9D7hlgPlh9XD7OgLAe5Q 

Логинимся. Видим кнопки Home и About. Если на них потыкать то ничено не произойдёт. Открываем исходный код и видим подсказку:
```html
<!-- hint: password for webuser natas8 is in /etc/natas_webpass/natas8 -->
```

Смотрим на ссылку: http://natas7.natas.labs.overthewire.org/index.php?page=about, но в параметре указываем тот самый путь который был указан в комментарии.
Переходим и забираем флаг. 