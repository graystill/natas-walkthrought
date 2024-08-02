## Natas 5

Здесь мы видим сообщение что не залогинены. Внутри кода сайта тоже ничего нет. Открытваем средства разработчка (Development Tools) и пылесосим их в надежде что-то найти. 

Взгляд падает на куки с параметром loggedin, который равен 0. В секции Storage изменяем этоти самый нолик на единицу, рефрешим страцу и полуаем заветное:

> Access granted. The password for natas6 is 0RoJwHdSKWFTYR5WuiAewauSuNaBXned

Гайд на изменение куки:
1. DevTools -> console -> document.cookie="name=value" <kbd>Enter</kbd>
2. DevTools -> Storage -> меняем поле value
3. Burp Suit -> Proxy -> логинимся через внутренный браузер -> send to Repeater -> в рипетере в поле "Cookie" меняем его значение -> send -> Previev/Render