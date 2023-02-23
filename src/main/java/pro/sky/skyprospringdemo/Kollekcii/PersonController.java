package pro.sky.skyprospringdemo.Kollekcii;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /*@GetMapping(path = "/person")
    public String getPersonInfo(@RequestParam("number") Integer number) {
        try {
            return personService.getPerson(number);
        } catch (BadPersonNumberException e) {
            e.printStackTrace();
            return "Попробуйте другой номер";
        } catch (Exception e) {
            e.printStackTrace();
            return "Попробуйте позже";
        }
    }*/
    @GetMapping(path = "/person/profession/add")
    public String  addProfession(@RequestParam("passport") String passport,
                              @RequestParam("profession") Integer profession) {
        personService.addProfession(passport,profession);
        return "Профессия успешно добавлена";
    }

    @GetMapping(path = "/person/by-passport")
    public String getPersonInfo(@RequestParam("passport") String passport){

            return personService.getPersonByPassport(passport);
    }

    @GetMapping(path = "/person/add")
    public String addPerson(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("passport") String passport,
                            @RequestParam("profession") Integer profession) {
        Person person = new Person(
                name,
                surname,
                passport,
                profession
        );
        personService.addPerson(person);
            return "Person added";
    }
    @GetMapping(path="/persons/by-profession")
    public String getByProfession(@RequestParam("profession") int profession) {
        List<Person> personsByProfession = personService.getPersonsByProfession(profession);
        //List<String> passports = new ArrayList<>();
        /*for (int i = 0; i < personsByProfession.size(); i++) {
            Person person = personsByProfession.get(i);
            passports.add(person.getPassport());
        }*/
        List<String> streamPassports = personsByProfession.stream()
                .map(e->e.getPassport())
                .map(passport->"~"+passport+"~")
                .collect(Collectors.toList());
        return streamPassports.toString();

    }


}
