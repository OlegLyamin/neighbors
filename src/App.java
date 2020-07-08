import java.util.*;

public class App {
    public static void main(String[] args) {
        int SIZE = 9;

        Element[][] matrix = new Element[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Element(i, j);
            }
        }

        for (Element[] elements : matrix) {
            for (Element element : elements) {
                System.out.print(element.toString() + " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Соседние элементы: " + getNeighbours(new Element(0 , 0), matrix));
    }

    public static Set<Element> getNeighbours(Element element, Element[][] arr) {
        Set<Element> elements = new HashSet<>();

        int xStart;
        int xEnd;
        int yStart;
        int yEnd;
        short offset = 1;

        if (element.getX() - offset < 0) {
            xStart = element.getX();
        } else {
            xStart = element.getX() - offset;
        }
        if (element.getX() + offset > arr.length - offset) {
            xEnd = element.getX();
        } else {
            xEnd = element.getX() + offset;
        }
        if (element.getY() - offset < 0) {
            yStart = element.getY();
        } else {
            yStart = element.getY() - offset;
        }
        if (element.getY() + offset > arr.length - offset) {
            yEnd = element.getY();
        } else {
            yEnd = element.getY() + offset;
        }

        try {
            for (int i = xStart; i <= xEnd; i++) {
                for (int j = yStart; j <= yEnd; j++) {
                    if (i == element.getX() && j == element.getY()) {
                        continue;
                    }
                    elements.add(arr[i][j]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) { // Некоторые элементы могут быть соседними даже если вводимый элемент находится вне матрицы
            System.out.println("Координаты элемента находятся вне матрицы");
        }

        return elements;
    }

}
