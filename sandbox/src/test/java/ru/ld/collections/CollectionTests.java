package ru.ld.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {
    @Test
    //создаем тестовый метод, который проверяет, что в массиве действительно есть те строки, которые мы в него поместили//
    void arrayTests(){
        //для того, чтобы создать массив, вызываем конструктор (используем квадратные скобки!, это указатель создания массива)//
        //в фигурных скобках перечисляются элементы массива//
        //var array = new String[]{"a", "b", "c"};
        //массив с размером три и с элементами со значениями "null"//
        var array = new String[3];
        Assertions.assertEquals(3, array);
        //присваивание значения элементу 0//
        array[0] = "a";
        //через квадратные скобки указывается индекс массива, начинается с 0//
        Assertions.assertEquals("a", array.length);
        //поменять элемент массива тоже через квадратные скобки//

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);
        //изменять количество элементов массива НЕЛЬЗЯ!//
    }

    @Test
//стандартная библиотека список. списки можно изменять//
    void listTests() {
        //создаем список сразу с элементами. Список созданный при помощи функции List.of не модифицируемый//
        //var list =  List.of("a", "b", "c");
        //создаем объект и в угловых скобках указываем какие элементы в этом списке//
        //список для хранения строк. есть разные варианты реализаций списка, Array использует внутри массивы, отсюда и название//
        var list = new ArrayList<>(List.of("a", "b", "c"));
        Assertions.assertEquals(3, list.size());

        //добавить элементы в этот список//
        //list.add("a");
        //list.add("b");
        //list.add("c");

        //проверяем размер списка//
        //Assertions.assertEquals(3, list.size());
        //проверяем, что список имеет элементы, необходимо указать индекс. В этом списке элементы имеют индексы 0,1,2//
        Assertions.assertEquals("a", list.get(0));

        //изменяем элемент//
        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));

    }
}
