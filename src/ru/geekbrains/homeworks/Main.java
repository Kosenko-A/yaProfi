package ru.geekbrains.homeworks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String exampleNew = " Президент Турции Тайип Эрдоган заявил о намерении усилить разведку газовых месторождений в Черном море и начать использовать добытое там топливо уже в 2023 году, пишет Прайм. Фото: EPA";
        System.out.println("Новость:" + exampleNew);
        List<String> liExamp = Arrays.asList(exampleNew.trim().split("\\s"));
        // Найдем слова с большой буквы

        List<String> potentialSubjects = new ArrayList<>();
        for (int i = 0; i < liExamp.size(); i++) {
            if ((liExamp.get(i).charAt(0) > 'А') && (liExamp.get(i).charAt(0) < 'Я')){
               potentialSubjects.add(liExamp.get(i));
            }
        }

        //имитируем наличие БД
        //БД популярных имен и имен и фамилий известных деятелей
        List<String> names = new ArrayList<>();
        names.add("Алексей");
        names.add("Сергей");
        names.add("Эрдоган");
        names.add("Путин");

        //БД маркеры компаний
        List<String> markersKomp = new ArrayList<>();
        markersKomp.add("компания");
        markersKomp.add("организация");
        markersKomp.add("ООО");

        //БД маркеры событий
        HashMap<Integer, String> markers = new HashMap<>();
        markers.put(0, "Президент");
        markers.put(1, "Театр");

        HashMap<Integer, String> categoriesM = new HashMap<>();
        categoriesM.put(0, "Политика");
        categoriesM.put(1, "Культура");

        System.out.println("Потенциальные субъекты:" + potentialSubjects);

        //список действующих лиц
        List<String> subjects = new ArrayList<>();
        //Категория
        String category = "";

        for (int i = 0; i<potentialSubjects.size(); i++){
            for (int j = 0; j<names.size(); j++){
                if(potentialSubjects.get(i).equals(names.get(j))){
                    subjects.add(potentialSubjects.get(i));
                    break;
                }
            }


            int indexMarker = 0;

            if (liExamp.indexOf(potentialSubjects.get(i))!=0) {
                indexMarker = liExamp.indexOf(potentialSubjects.get(i)) - 1;
            }

            for (int j = 0; j<markersKomp.size(); j++){
                if(liExamp.get(indexMarker).equals(markersKomp.get(j))){
                    subjects.add(potentialSubjects.get(i));
                }
            }

            for (int j = 0; j<markers.size(); j++){
                if(potentialSubjects.get(i).equals(markers.get(j))){
                    category = categoriesM.get(j);
                }


            }

        }
        System.out.println("Действующие лица:" + subjects);
        System.out.println("Категория новости:" + category);


    }


}
