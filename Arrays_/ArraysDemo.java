package Arrays_;

public class ArraysDemo {
    public static void main(String[] args) {
        ArraysDemo arraysDemo = new ArraysDemo();
        arraysDemo.arraysDemo();
    }

    public void arraysDemo() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);

        dynamicArray.add(2, 5);
        dynamicArray.remove(2);
//        for (int i = 0; i < 7; i++) {
//            System.out.println(dynamicArray.get(i));
//        }
//
//        dynamicArray.stream().forEach((element) -> {
//            System.out.println(element);
//        });

//        for (Integer element : dynamicArray) {
//            System.out.println(element);
//        }

    }
}
