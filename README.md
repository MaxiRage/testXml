# testXml

В приложении реализовано 4 эндпоинта:

1. http://localhost:8080/api/entries/{inputNumber} - принимает на вход число N и добавляет N-записей со значениями 1..N в таблицу

*Пример: http://localhost:8080/api/entries/10*

2. http://localhost:8080/api/entries/all-xml - выводит на экран все данные в XML виде

3. http://localhost:8080/api/entries/all-xslt - добавляет XSLT-преобразование исходной XML

4. http://localhost:8080/api/entries/sum-all-value - возвращает сумму всех значений таблицы

**Для доступа к базе данных используйте:** <br> 
url: jdbc:postgresql://localhost:5432/testXml <br> 
username: postgres <br> 
password: admin

*Все эндпоинты используют метод Get для возможности запроса напрямую через браузер*
