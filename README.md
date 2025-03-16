# homework-5
#### Необходимо реализовать Stub сервер на Wiremock со следующими endpoint'ами: <br>
#### /user/get/{name} для получение оценки пользователя <br>
#### /course/get/all для получения списка курсов <br>
#### /user - для получения user <br>
##### Контракты:
Для user
{
"name":"Test user",
"course":"QA",
"email":"test@test.test"
"age": 23
}

Для оценки:
{
"name":"Test user",
"score": 78
}

Для курсов:
[
{
"name":"QA java",
"price": 15000
},
{
"name":"Java",
"price": 12000
}
]
## Инструкции:
#### 1. Установить docker для своей системы (Windows, Linux).
#### 2. В терминале выполните команду:<br>
   docker pull wiremock/wiremock<br> 
#### 3. docker run -d --name wiremock -p 8080:8080 \
#### -v //c/Users/Pol/Downloads/otus/wireMock_Stub/src/test/resources/__files:/home/wiremock/__files \
#### wiremock/wiremock --verbose<br>
   -d — запускает контейнер в фоне<br>
   используется полный путь к папке на хосте: C:/Users/Pol/Downloads/otus/wireMock_Stub/src/test/resources/__files<br>
   Папка монтируется внутри контейнера: /home/wiremock/__files, чтобы WireMock мог найти файлы в правильной директории.<br> 
   --name wiremock — задает имя контейнера<br>
   -p 8080:8080 — пробрасываем порт <br>
#### 4. Проверить что контейнер работает:<br>
   docker ps<br>
#### 5. откройте браузер и введите: http://localhost:8080/__admin
#### 6. Остановить контейнер:<br> 
docker stop wiremock
#### 7. Удалить контейнер:<br>
docker rm wiremock
#### 8. Запустить контейнер:<br>
docker start wiremock
#### 9. **PS.** У вас должен быть локально установлен Maven и JDK 17.<br>