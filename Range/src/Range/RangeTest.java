package Range;

public class RangeTest {
    public static void main(String[] args) {
        Range range1 = new Range(1, 10);

        System.out.println("Начало диапазона - " + range1.getFrom());
        System.out.println("Конец диапазона - " + range1.getTo());

        System.out.println("Длина диапазона - " + range1.getLength());

        System.out.println("Находится ли число 1 в диапазоне - " + range1.isInside(1));
        System.out.println("Находится ли число 12 в диапазоне - " + range1.isInside(12));

        System.out.println();

        range1.setFrom(3);
        range1.setTo(6);

        System.out.println("Начало диапазона - " + range1.getFrom());
        System.out.println("Конец диапазона - " + range1.getTo());

        System.out.println("Длина диапазона - " + range1.getLength());

        System.out.println("Находится ли число 4 в диапазоне - " + range1.isInside(4));
        System.out.println("Находится ли число 8 в диапазоне - " + range1.isInside(8));

        System.out.println();

        range1 = new Range(1, 5);
        Range range2 = new Range(3, 12);

        Range range3 = range1.getIntersection(range2);

        System.out.println("Пересечение выбранных интервалов: " + range3.getFrom() + " - " + range3.getTo());

        System.out.println();

        range1 = new Range(1, 3);
        range2 = new Range(5, 7);

        Range[] ranges = range1.getMerge(range2);

        System.out.print("Объединение выбранных интервалов: ");

        for (Range range : ranges) {
            if (range != null) {
                System.out.print(range.getFrom() + " - " + range.getTo() + "; ");
            }
        }

        System.out.println();
        System.out.println();

        range1 = new Range(1, 8);
        range2 = new Range(3, 5);

        ranges = range1.getSubtraction(range2);

        System.out.print("Разность выбранных интервалов: ");

        for (Range range : ranges) {
            if (range != null) {
                System.out.print(range.getFrom() + " - " + range.getTo() + "; ");
            }
        }
    }
}
