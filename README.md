# Домашнее задание к занятию 11 «Teamcity»

## Выполненные шаги:
1. Настроен TeamCity Server и агент в Yandex Cloud.
2. Создан проект на основе fork-репозитория, настроен autodetect.
3. Настроены условия сборки: `clean deploy` для ветки master и `clean test` для остальных.
4. Настроен Nexus и загружен файл `settings.xml` для авторизации.
5. Обновлен `pom.xml` для деплоя в локальный Nexus.
6. Успешно выполнена сборка `master`, артефакт загружен в Nexus.
7. Создана ветка `feature/add_reply`, добавлен метод `getHunterReply()` и тест к нему.
8. Выполнено слияние (Merge) ветки `feature/add_reply` в `master`.
9. Настроены артефакты сборки (`.jar` файлы) в TeamCity.
10. Конфигурация мигрирована в репозиторий (Kotlin DSL).

## Ссылка на репозиторий
[https://github.com/michaelkoch51/example-teamcity3110koch](https://github.com/michaelkoch51/example-teamcity3110koch)

![](https://github.com/user-attachments/assets/26a32a62-cb0f-416a-a20b-fb57c4263eb4)
![](https://github.com/user-attachments/assets/8648c26d-b09e-4cf7-b2da-d2e23fdbbc46)
