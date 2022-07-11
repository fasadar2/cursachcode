<h1>список реализованнаых запросов</h1>
<h2>
GET:
</h2>
<p>
<b>путь: </b>/getErrorList
<br><b> метод:</b>getErrorList
<br><b>описание:</b>возвращает json из объектов содержащих данные из таблицы erorrmessage
</p>
<p>
<b>путь: </b>/machineTable
<br><b> метод:</b>:getMachineList
<br><b>описание:</b>возвращает json из объектов содержащих данные из таблицы machint
</p>
<p>
<b>путь: </b>/getServiceList
<br><b> метод:</b>GetServiceMachineList
<br><b>описание:</b>возвращает json из объектов содержащих данные из таблицы servicemachine
</p>
<p>
<b>путь: </b>/getTimeTableList
<br><b> метод:</b>GetTimeTableList
<br><b>описание:</b>описание:возвращает json из объектов содержащих данные из таблицы timeTable
</p>
<br>
<h2>
POST
</h2>
<p>
<b>путь: </b>/login
<br><b> метод:</b>checkLogin
<br><b>описание:</b>проверяет введенные логина и пароля
</p>
<p>
<b>путь: </b>/machineUpdateStatus
<br><b> метод:</b>updateStatus
<br><b>описание:</b> изменяет статус оборудования в таблице machine согласно инвентарному номеру
</p>
<p>
<b>путь: </b>/machineUpdateRecomendation
<br><b> метод:</b>updateRecomendation
<br><b>описание:</b>обновляет рекомендации к использованию в таблице machine
</p>
<p>
<b>путь: </b>/machineTOUpdate
<br><b> метод:</b>updateTO
<br><b>описание:</b>обновляет данные о последнем ТО в таблице machine
</p>
<p>
<b>путь: </b>/newMachine
<br><b> метод:</b>NewMachine
<br><b>описание:</b>добовляет в бд запись о новом оборудовании
</p>
<p>
<b>путь: </b>/NewServiceMachine
<br><b> метод:</b>NewServiceMachine
<br><b>описание:</b>добовляет запись в бд оп постановке оборудования в сервис
</p>
<p>
<b>путь: </b>/UpdateServiceMachine
<br><b> метод:</b> UpdateServiceMachine
<br><b>описание:</b> изменяет в бд данные о стаусе оборудования в сервисе и/или меняет дату конца обслуживания в сервисе
</p>
<br>
<p>Посмотреть запросы к серверу можно в файле practic.postman_collection.json </p>
<p>На данный момент ведется работа над junit тестами</p>