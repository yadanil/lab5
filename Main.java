import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;

public class Main {
    public static <T> void removeAllOccurrences(List<T> list, T element) {
        list.removeAll(List.of(element));
    }

    private static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    //Метод для проверки, является ли строка числом
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        //Задание 1 1
        System.out.println("\nЗадание 1.1\n");

        Fraction fraction = new Fraction(3, 9);
        System.out.println("Строковое представление дроби: " + fraction);
        System.out.println("Вещественное значение: " + fraction.getRealValue());

        //Изменение числителя и знаменателя
        fraction.setNumerator(5);
        fraction.setDenominator(10);
        System.out.println("Дробь после изменения: " + fraction);
        System.out.println("Вещественное значение: " + fraction.getRealValue());

        //Сравнение дробей
        Fraction fraction2 = new Fraction(1, 2);
        Fraction fraction3 = new Fraction(1, 2);
        System.out.println("Дробь 2: " + fraction2);
        System.out.println("Дробь 3: " + fraction3);
        System.out.println("Дробь 2 и дробь 3 равны: " + fraction2.equals(fraction3));


        //Задание 2 1
        System.out.println("\nЗадание 2.1\n");

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Барсик"));

        int[] meowCounts = Funs.meowsCare(4, cats.toArray(new Meowable[0])); //Ввод количества мяуканий

        for (int i = 0; i < cats.size(); i++) {
            System.out.println("\n" + cats.get(i).getName() + " мяукал: " + meowCounts[i] + " раз");
        }


        //Задание 3 1
        System.out.println("\nЗадание 3.1\n");

        //Пример с целыми числами
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        numbers.add(2);

        System.out.println("Исходный список чисел: " + numbers);
        removeAllOccurrences(numbers, 2); //Выбор числа для удаления
        System.out.println("Список чисел после удаления всех 2: " + numbers);

        //Пример со строками
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("apple");
        strings.add("orange");

        System.out.println("\nИсходный список строк: " + strings);
        removeAllOccurrences(strings, "apple"); //Выбор строки для удаления
        System.out.println("Список строк после удаления всех 'apple': " + strings);


        //Задание 4 1
        System.out.println("\nЗадание 4.1\n");

        Scanner scanner = new Scanner(System.in);

        //Ввод количества учеников
        System.out.print("Введите количество учеников: ");
        int N = scanner.nextInt();
        scanner.nextLine(); //Поглощаем оставшийся символ новой строки

        //Хранения количества вхождений каждой фамилии
        Map<String, Integer> surnameCount = new HashMap<>();

        //Обработка каждой строки с фамилией и именем
        for (int i = 0; i < N; i++) {
            System.out.print("Введите фамилию и имя ученика: ");
            String fullName = scanner.nextLine();

            //Разделение фамилии и имени
            String surname = fullName.split(" ")[0];

            //Проверяем, встречалась ли фамилия ранее
            if (surnameCount.containsKey(surname)) {
                //Если фамилия уже встречалась, увеличиваем счетчик
                int count = surnameCount.get(surname) + 1;
                surnameCount.put(surname, count);
                System.out.println(surname + count); //Логин с числом
            } else {
                //Если фамилия встречается впервые, добавляем её с количеством 1
                surnameCount.put(surname, 1);
                System.out.println(surname); //Логин без числа
            }
        }

        scanner.close();

        //Задание 5 1
        System.out.println("\nЗадание 5.1\n");

        //Множество звонких согласных букв
        Set<Character> voicedConsonants = new HashSet<>(Arrays.asList(
                'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р',
                'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'Л', 'М', 'Н', 'Р'
        ));

        //Множество для хранения уникальных звонких согласных
        Set<Character> uniqueSonorous = new TreeSet<>();

        try {
            //Чтение файла
            File file = new File("C:\\Users\\yadan\\IdeaProjects\\lab5\\src\\input.txt");
            Scanner scanner1 = new Scanner(file);

            //Обработка текста
            while (scanner1.hasNextLine()) {
                String line = scanner1.nextLine();
                for (char c : line.toCharArray()) {
                    if (voicedConsonants.contains(c)) {
                        uniqueSonorous.add(Character.toLowerCase(c)); //Добавление в нижний регистр
                    }
                }
            }

            scanner1.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            return;
        }

        //Вывод результата
        System.out.println("Звонкие согласные буквы в тексте (в алфавитном порядке):");
        for (char c : uniqueSonorous) {
            System.out.print(c + " ");
        }


        //Задание 6 1
        System.out.println("\n\nЗадание 6.1\n");

        //Создаем очередь и добавляем элементы
        Queue<Integer> L = new LinkedList<>();
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        L.add(5);

        System.out.println("Исходная очередь: " + L);

        //Печатаем элементы в обратном порядке
        System.out.print("Элементы в обратном порядке: ");
        for (int i = L.size() - 1; i >= 0; i--) {
            System.out.print(((LinkedList<Integer>) L).get(i) + " ");
        }


        //Задание 7 1
        System.out.println("\n\nЗадание 7.1\n");

        //Пример набора точек
        List<Point> points = Arrays.asList(
                new Point(1, -2),
                new Point(3, 4),
                new Point(2, 3),
                new Point(1, -2),
                new Point(-1, 5),
                new Point(0, 0)
        );

        //Обработка стримом
        Polyline polyline = points.stream()
                .distinct() //Убираем дубликаты
                .sorted(Comparator.comparingInt(Point::getX)) //Сортируем по X
                .map(p -> new Point(p.getX(), Math.abs(p.getY()))) //Делаем Y положительными
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Polyline::new
                )); //Собираем в Polyline

        //Вывод результата
        System.out.println(polyline);


        //Задание 7 2
        System.out.println("\n\nЗадание 7.2\n");

        try {
            //Чтение файла
            File file = new File("C:\\Users\\yadan\\IdeaProjects\\lab5\\src\\input1.txt");
            Scanner scanner1 = new Scanner(file);

            //Обработка строк
            Map<Integer, List<String>> groupedNames = scanner1
                    .useDelimiter("\n") //Разделитель строк
                    .tokens() //Получаем поток строк
                    .map(line -> line.trim().split("\\s*:\\s*")) //Разделяем строку на имя и номер, удаляя пробелы вокруг разделителя
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty() && isNumeric(parts[1])) //Убираем строки без номера и некорректные номера
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1]), //Группируем по номеру
                            Collectors.mapping(
                                    parts -> capitalize(parts[0]), //Приводим имя к нужному формату
                                    Collectors.toList()
                            )
                    ));

            scanner.close();

            System.out.println("Результат группировки: " + groupedNames);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}
