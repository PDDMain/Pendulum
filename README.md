# Pendulum
## Ссылки
* [jar-ник](https://github.com/PDDMain/Pendulum/blob/main/out/artifacts/pendulum_jar/pendulum.jar) для запуска приложения
* [Выкладки и пересчет](https://github.com/PDDMain/Pendulum/blob/main/images/photo_2021-01-19_08-50-43.jpg)
* [Сам код](https://github.com/PDDMain/Pendulum/tree/main/pendulum/src)

## Остальное
Управление только кнопкой пробела

Симуляция взаимодействия маятника и летящего в него в круглого объекта

![](https://github.com/PDDMain/Pendulum/blob/main/images/screen.png)


Модель взаимодействие максимально упрощена, при попадании мяча в маятник считаем, что мяч просто приклеивается и не дает каких-то вращающих моментов вокруг груза маятника.
Меняется только вращательный момент вокруг точки опоры маятника. И масса маятника. Центр масс так же не меняем (картинка получается не очень)

В итоге, период раскачивания не менятся.
Меняется угловая скорость, а вследсвии и амплитуда.

После приклееивания можно отклеить шарик нажатием на пробел и снова запустить в маятник.
