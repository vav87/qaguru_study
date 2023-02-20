1. На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.  
Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."  

2. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
- Откройте https://the-internet.herokuapp.com/drag_and_drop
- Перенесите прямоугольник А на место В
- Проверьте, что прямоугольники действительно поменялись
- В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
