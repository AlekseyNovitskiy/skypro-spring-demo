package pro.sky.skyprospringdemo.Kollekcii;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}