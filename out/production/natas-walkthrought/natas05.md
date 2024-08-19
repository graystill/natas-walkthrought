# Natas 5

<kbd>Username</kbd> natas5

<kbd>Password</kbd> 0n35PkggAPm2zbEpOU802c0x0Msn1To

<kbd>Flag</kbd> 0RoJwHdSKWFTYR5WuiAewauSuNaBXned 

Здесь сайт говорит что мы не залогинены. Прожимаем F12. Тыкаемся в разные места пока не заходим в storage.
Там хранятся куки. Видим одно с названием loggedin. Меняем значение с 0 на 1 и получаем пароль от следующего уровня.

### Как поменять value (значение) у cookie:
1. Через burp suit. Тут аналогично уровню 4, но меняем поел cookie, а не Referer
2. Чеpeз консоль. document.cookie="name=value" (правда значение придётся ручками писать)
3. cURL --cookie "name=value" -username:password url