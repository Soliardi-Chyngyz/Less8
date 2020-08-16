package com.company;

import java.security.Key;
import java.util.*;

public class Main {
    //Копировать все элементы словаря в большой словарь как они есть.
// Затем нужно написать алгоритм автоматического дополнения
// большого словаря, таким образом чтоб каждый из элементов массива синонимов по 1 разу выступил в роли КЛЮЧА
    //       Текущие ключи маленького словаря также должны будут перейти в массив на роль одного из синонимов.
    //       Подсказка массив легко конвертируется в ArrayList, для проверки правильности работы вашего алгоритма в
//       конце распечатайте содержимое всего большого словаря

    public static void main(String[] args) {

        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("большой", new String[]{"колосальный", "огромный", "громадный", "гигантский"});
        dictionary.put("колосальный", new String[]{"огромный", "громадный", "гигантский", "большой"});
        dictionary.put("человек", new String[]{"персона", "личность", "индивидум"});
        dictionary.put("дом", new String[]{"жилище", "хата", "квартира", "недвижимость"});

        HashMap<String,String[]> bigdicitionary = new HashMap<>();
        Set<String> keys = dictionary.keySet();

        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<<<");
            String key = iterator.next().toString();
            String[] word = dictionary.get(key);
            bigdicitionary.put(key, word);
            for (int i = 0; i < word.length; i++) {
                String novKey = word[i];
                ArrayList<String> words = new ArrayList<>(word.length);
                words.addAll(Arrays.asList(word));
                words.remove(novKey);
                words.add(key);
                String[] wo = new String[words.size()];
                wo = words.toArray(wo);
                bigdicitionary.put(novKey, wo);
                System.out.println("_________________________________");
                for (Map.Entry <String, String[]> item : bigdicitionary.entrySet()) {
                    System.out.println(item.getKey() + " " + Arrays.toString(item.getValue()));
                }
            }
        }

        
    }
}