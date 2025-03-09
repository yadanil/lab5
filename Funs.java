public class Funs {
    public static int[] meowsCare(int meowTimes, Meowable... meowables) {
        int[] meowCounts = new int[meowables.length];
        for (int i = 0; i < meowables.length; i++) {
            if (meowables[i] instanceof Cat) {
                Cat cat = (Cat) meowables[i];
                for (int j = 0; j < meowTimes; j++) {
                    cat.meow(); // Мяукаем указанное количество раз
                }
                meowCounts[i] = cat.getMeowCount(); // Получаем количество мяуканий
            }
        }
        return meowCounts;
    }
}