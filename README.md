## Объектно-ориентированные паттерны

Закончить разработку паттерна Фабричный метод

### UML-диаграмма шаблона

![uml-factory-method](https://github.com/user-attachments/assets/5450aef1-181a-4c29-ba7b-acde41cce44d)

Согласно диаграмме:

* _Product'ом_  является всякий объект, реализующий интерфейс [Reader](src/main/java/edu/alexey/factorymethodpattern/Reader.java).

* Назначение _Reader'ов_  &mdash; используя входные данные начиная с некоторой указанной позиции возвращать последовательность оставшихся элементов данных, реализующих контракт [DataEntry](src/main/java/edu/alexey/factorymethodpattern/DataEntry.java), и представленной в виде итератора `Iterable<? extends DataEntry>`.

* _AbstractCreator'ом_  является абстрактный класс [ReaderCreator](src/main/java/edu/alexey/factorymethodpattern/ReaderCreator.java)

* Конкретная реализация _AbstractCreator'а_  &mdash; [ConcreteReaderCreator](src/main/java/edu/alexey/factorymethodpattern/concrete/ConcreteReaderCreator.java)

* Конкретные подклассы-реализации _Reader'а_ (то есть _Product'а_ ) расположены вместе с _ConcreteReaderCreator_ в отдельном пакете [edu.alexey.factorymethodpattern.concrete](src/main/java/edu/alexey/factorymethodpattern/concrete/).
