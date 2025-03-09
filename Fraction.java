import java.util.Objects;

public class Fraction implements FractionOperations {
    private int numerator; //Числитель
    private int denominator; //Знаменатель
    private Double cachedRealValue; //Кэшированное вещественное значение

    //Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть меньше нуля");
        }
        this.numerator = numerator;
        this.denominator = Math.abs(denominator);
        normalize(); //Нормализация дроби
    }

    //Нормализация дроби (упрощение знаков)
    private void normalize() {
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    //Получение вещественного значения с кэшированием
    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = (double) numerator / denominator;
        }
        return cachedRealValue;
    }

    //Установка числителя
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedRealValue = null; //Сбрасываем кэш при изменении знаменателя
    }

    //Установка знаменателя
    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть меньше нуля");
        }
        this.denominator = Math.abs(denominator);
        normalize();
        cachedRealValue = null; //Сбрасываем кэш при изменении знаменателя
    }

    //Получение строкового представления дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    //Переопределение метода equals для сравнения дробей по состоянию
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction otherFraction = (Fraction) obj;
        return numerator == otherFraction.numerator && denominator == otherFraction.denominator;
    }

    //Переопределение метода hashCode для согласованности с equals
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}