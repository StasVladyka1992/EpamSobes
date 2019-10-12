package Stream;

import java.util.Optional;

/**
 * @project EpamSobes
 * author Stas Vladyka on 19.07.2019.
 */
public class OptionalExamples {

    //TODO read more https://stackify.com/optional-java/
    public static void main(String[] args) {

        OptionalExamples example = new OptionalExamples();

        example.optionalWithNotNullValue();
        example.emptyOptional();
        example.optionalWithNullOrWithout();
        example.ifPresentExample();
        example.orElseExample();


        //exception NoSuchElementException
//        Optional<Person> emptyOpt = Optional.empty();
//        emptyOpt.get();

    }

    private void optionalWithNotNullValue() {
        Person person = new Person();
        //use this, when sure that there can't be null pointer exception. If null - NullPointerException is thrown
        Optional<Person> opt1 = Optional.of(person);
        opt1.get();
    }

    private void emptyOptional() {
        Optional<Person> opt1 = Optional.empty();
//        NoSuchElementException is thrown
//        opt1.get();
    }

    private void optionalWithNullOrWithout(){
        Person person = new Person();
        Person person1 = null;
        //when we don't know whether it can be null or not
        Optional<Person> opt = Optional.ofNullable(person);
        Optional<Person> opt1 = Optional.ofNullable(person);
    }


    private void ifPresentExample(){
        //ifPresent() used to execute code if value not null, else - do nothing
        Person person = new Person();
        Person person1 = null;
        Optional.ofNullable(person1).ifPresent(System.out::println);
        Optional.of(person).ifPresent(System.out::println);
    }

    private void orElseExample(){
        //orElse() used when value is null, it is opposite to ifPresent()
        Person person = null;
        System.out.println(Optional.ofNullable(person).orElse(new Person("asa", 10)));
    }
}
