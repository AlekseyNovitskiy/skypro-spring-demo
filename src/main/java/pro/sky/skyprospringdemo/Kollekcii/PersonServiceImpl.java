package pro.sky.skyprospringdemo.Kollekcii;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {
    /*Person[] persons = {
            new Person("Жан", "Рено", "12345", 2),
            new Person("Люк", "Бессон", "54321", 3),
            new Person("Жерар", "Депардье", "41232", 0),
            new Driver("Джейсон", "Стетхем", "928374", "3491", 1),
            new TruckDriver("Роберт", "Патрик", "1000", "2345", 4)
    };*/
    // Из массива в лист List
    /*List<Person> persons = new ArrayList<>(List.of(
            new Person("Жан", "Рено", "12345", 2),
            new Person("Люк", "Бессон", "54321", 3),
            new Person("Жерар", "Депардье", "41232", 0),
            new Driver("Джейсон", "Стетхем", "928374", "3491", 1),
            new TruckDriver("Роберт", "Патрик", "1000", "2345", 3))
    );*/

    // Из массива в Map
    Map<String, Person> persons = new HashMap<>(Map.of("12345",
            new Person("Жан", "Рено", "12345", 2),
            "54321",
            new Person("Люк", "Бессон", "54321", 3),
            "41232",
            new Person("Жерар", "Депардье", "41232", 0),
            "3491",
            new Driver("Джейсон", "Стетхем", "928374", "3491", 1),
            "1000",
            new TruckDriver("Роберт", "Патрик", "1000", "2345", 3))
    );


    // Из массива в лист
    /*String[] professions = {
            "Безработный",
            "Водитель",
            "плотник",
            "столяр"
    };*/
    List<String> professions = List.of(
            "Безработный",
            "Водитель",
            "плотник",
            "столяр",
            "Актер"
    );

    Map<String, Integer> professionsCodes = Map.of(
            "Безработный", 0,
            "Водитель", 1,
            "Плотник", 2,
            "Столяр", 3,
            "Актер", 4);
    @Override
    public List<Person> getPersonsByProfession(Integer professionNumber) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().contains(professionNumber)) {
                result.add(person);
            }
        }
        return result;
    }
    @Override
    public List<Person> getPersonsByProfessions(List<Integer> professionNumbers) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().containsAll(professionNumbers)) {
                result.add(person);
            }
        }
        return result;
    }

    /*@Override
    public String getPerson(Integer number) { // принимает индекс в массиве
        final Person person;
        // if (number >= persons.length) {
        if (number >= persons.size()) {
            throw new BadPersonNumberException("ошибка в том, что номер человека заведома больше размера массива");
        }
        // person = persons[number]; //  по этому номеру получает человека
        person = persons.get(number);
        // далее склеивает значения
        final String personDescription = "" + person.getName() + " " + person.getSurname() + " "
                + person.getPassport()+" "+ professions.get(person.getProfessionNumber()); // professions[person.getProfessionNumber()]
        return personDescription;
    }*/
    @Override
    public void addProfession(String passport, Integer profession) {  // добавляем профессию по паспорту
        final Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек с таким номером паспорта не найден");
        }
        //if (!person.getProfessionNumbers().contains(profession)) { // если похожая профессия не найдена
        person.getProfessionNumbers().add(profession);
        //}
    }

    @Override
    public void addPerson(Person person) {
        //  persons.add(person);
        //преобразуем в Мар
        persons.put(person.getPassport(), person);
    }

    @Override
    public String getPersonByPassport(String passport) {
        // for (Person person : persons) { // перебирает лист и записывает в person
        // Преобразуем в Мар
        //for (Person person : persons.values()) {
        final Person person = persons.get(passport);
        //if (person.getPassport().equals(passport)) {
        if (person == null) {
            throw new RuntimeException("Человек с таким номером паспорта не найден");
        }
        final String personDescription = "" + person.getName() + " " + person.getSurname() + " "
                + person.getPassport() + " " + getProfessionNames(person.getProfessionNumbers());
        return personDescription;
    }

    private String getProfessionNames(Set<Integer> professionNumbers) {
        String result = ""; // создали новую строку, чтобы добовлять новые элементы
        for (Integer professionNumber : professionNumbers) { // в цикле проходиться по номерам профессий
            result = result + " " + professions.get(professionNumber); // передаем номер профессии
        }
        return result;

    }

}

