### Natas 4

Здесь сервер сообщает нам о том что нам доступ запрещён и говорит откужа нам нужно перейти.

Открываем панель разработчика и видим файл index.php, там мы видим структуру http-запроса, нас интересует заголовок reqesterer. 

Затем переходим в burp suite. Нажимаем Intercepter -> Intercept is On и затем логинимся из внутреннего браузера. В нём мы уже сможем рассмотреть HHTP-запрос подробней и изменить его. 

Нажимаем ПКМ и отправляем в Repeater. Этот самый заголовок Requesterer изменяем на natas5.natas.labs.overthewire.org/ и отправляем. После этого в поле Respond у нас появится заветный флаг

> Access granted. The password for natas5 is 0n35PkggAPm2zbEpOU802c0x0Msn1ToK