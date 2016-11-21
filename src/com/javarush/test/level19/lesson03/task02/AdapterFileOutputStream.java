package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/


import java.io.FileOutputStream;
import java.io.IOException;

/*
для того, чтобы создать адаптер, нужно:
1. создать класс-адаптер, имплементирующий второй класс
2. создать в адаптере приватную ссылку на объект первого класса (который адаптируем)
3. создать конструктор (с импортом ссылки первого класса), который будет ссылать нашу ссылку на первый класс
4. переназначить методы как на примере
*/

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;    //приватная ссылка
    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {    //конструктор с импортом
        this.fileOutputStream = fileOutputStream;    //ссылка на импорт
    }

    public void flush() throws IOException {    //переназначение метода
        this.fileOutputStream.flush();    //пример переназначения
    }

    public void writeString(String s) throws IOException {
        this.fileOutputStream.write(s.getBytes());
    }

    public void close() throws IOException {
        this.fileOutputStream.close();
    }

}

