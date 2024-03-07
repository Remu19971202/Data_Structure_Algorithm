package Arrays_;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {

    private int size = 0;
    private int capacity = 8;
    private int[] array = {};

    public void addLast(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    public void add(int index, int element) {
        //容量检查
        checkAndGrow();
        //添加逻辑
        if (index >= 0 && index < size) {
            System.arraycopy(array, index,
                    array, index + 1, size - index);
            //System.arraycopy(源数组(src), 源数组的起始索引(srcPos),
            // 目标数组(dest), 目标数组的起始索引(destPos), 复制元素数量(length))
        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        }else if (size == capacity) {
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int get(int index) { //[0..size)
        return array[index];
    }

    public void foreach(Consumer<Integer> consumer) { //函数式接口
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    //实现Iterator接口
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    //流
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    public int remove(int index) { //[0..size)
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1,
                    array, index, size - index - 1);
        }
        size--;
        return removed;
    }
}
