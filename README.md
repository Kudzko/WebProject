# WebProject
Общие требования к проекту:
Приложение реализовано на технологиях Servlet и JSP.
Архитектура приложения строится по шаблонам Layered architecture и
Model-View-Controller.

**_Требования:_**

Информация о предметной области хранится в БД:
- данные в базе хранятся на кириллице, рекомендуется применять кодировку utf-8
- технология доступа к БД – JDBC (только JDBC)
- для работы с БД в приложении должен быть реализован пул соединений
- при проектировании БД рекомендуется не использовать более 6-8 таблиц
- доступ к данным в приложении осуществлять с использованием шаблона DAO.
Интерфейс приложения должен быть интернационализирован; выбор языков:
английский, русский.
Приложение должно корректно обрабатывать возникающие исключительные
ситуации, в том числе вести их журналирование. В качестве логгера использовать Log4j.
Классы и другие сущности приложения должны быть грамотно структурированы по
пакетам и иметь отражающую их функциональность название.
При реализации бизнес-логики приложения следует при необходимости
использовать шаблоны проектирования (например, шаблоны GoF: Factory Method,
Command, Builder, Strategy, State, Observer etc), а также необходимо избегать процедурного
стиля программирования.
Для хранения пользовательской информации между запросами использовать сессию.
Для обработки объектов запроса(request) и ответа(response) применить фильтры
(например, для установки параметра кодировки запроса/ответа).
При реализации страниц JSP следует использовать теги библиотеки JSTL,
использовать скриплеты запрещено. Обязательным требованием является реализация и
использование пользовательского тега. Просмотр “длинных списков” желательно
организовывать в постраничном режиме.
Документацию к проекту необходимо оформить согласно требованиям javadoc.
Оформление кода должно соответствовать Java Code Convention.


Общие требования к функциональности проекта:
1. Вход(sign in) и выход(sign out) в/из системы.
2. Регистрация.
3. Просмотр информации (например: просмотр всех курсов, имеющихся кредитных
карт, счетов и т.д.)
4. Удаление информации (например: отмена заказа, медицинского назначения, отказ
от курса обучения и т.д.)
5. Добавление и модификация информации (например: создать и отредактировать
курс, создать и отредактировать заказ и т.д.)


**Функциональность:** <br>
