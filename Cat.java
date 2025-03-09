public class Cat implements Meowable {
    private String name;
    private int meowCount; //Счетчик мяуканий

    public Cat(String name) {
        this.name = name;
        this.meowCount = 0;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++; //Увеличиваем счетчик мяуканий
    }

    //Метод для мяуканья несколько раз
    public void meow(int times) {
        for (int i = 0; i < times; i++) {
            meow(); //Вызываем обычное мяуканье
        }
    }

    public String getName() {
        return name;
    }

    public int getMeowCount() {
        return meowCount;
    }
}