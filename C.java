// Generic Data Container using Generic Class, Generic Method, and Bounded Types

// Generic Class
class DataContainer<T> {
    private T data;

    public DataContainer(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void display() {
        System.out.println("Data: " + data);
    }

    // Generic Method
    public static <E> void printArray(E[] array) {
        System.out.print("Array Elements: ");
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Bounded Type Parameter
    public static <N extends Number> double calculateSum(N[] numbers) {
        double sum = 0;
        for (N num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }
}

// Main Class
public class GenericDataContainer {
    public static void main(String[] args) {

        // Generic Class with Integer
        DataContainer<Integer> intData = new DataContainer<>(100);
        intData.display();

        // Generic Class with String
        DataContainer<String> strData = new DataContainer<>("Hello Java");
        strData.display();

        // Generic Method Example
        Integer[] intArray = {10, 20, 30, 40};
        String[] strArray = {"Apple", "Banana", "Cherry"};

        DataContainer.printArray(intArray);
        DataContainer.printArray(strArray);

        // Bounded Type Parameter Example
        Double[] values = {10.5, 20.5, 30.0};
        System.out.println("Sum = " + DataContainer.calculateSum(values));
    }
}
