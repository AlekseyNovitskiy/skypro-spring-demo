package pro.sky.skyprospringdemo.Kollekcii;

import pro.sky.skyprospringdemo.Kollekcii.Person;

import java.util.List;

public interface PersonService {
    // String getPerson(Integer number);  // принимает индекс в массиве

    List<Person> getPersonsByProfession(Integer professionNumber);

    List<Person> getPersonsByProfessions(List<Integer> professionNumbers);

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
    void addProfession(String passport, Integer profession);

    void addPerson(Person person);

    String getPersonByPassport(String passport);
}
