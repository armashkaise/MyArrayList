import java.sql.Array;

public class MyArrayList {
    private int[] values;
    private int count = 0;

    public void add(int val){

        if (count == 0){
            values = new int[1];
            values[0] = val;
        }
        else {
            int lengthNewArray;
            if (count == values.length) lengthNewArray = values.length * 2;
            else lengthNewArray = values.length;

            int[] newValues = new int[lengthNewArray];
            System.arraycopy(values, 0, newValues, 0, values.length);
            newValues[count] = val;
            values = newValues;
        }
        count++;
    }

    public void add(int index, int val){
        if (index < 0 || index > count ) {
            System.out.println("Недопустимый интервал");
            return;
        }
        int lengthNewArray;
        if (count == values.length) lengthNewArray = values.length * 2;
        else lengthNewArray = values.length;

//        int lengthNewArray = values.length + 1;
        int[] newArray = new int[lengthNewArray];
        int[] firstArray = new int[index];
        System.arraycopy(values, 0, firstArray, 0, index);
        int[] lastArray = new int[count - index];
        System.arraycopy(values, index, lastArray, 0, count - index);
        System.arraycopy(firstArray, 0, newArray, 0, firstArray.length);
        newArray[firstArray.length] = val;
        System.arraycopy(lastArray, 0, newArray, firstArray.length + 1, lastArray.length);
        values = newArray;
        count++;
    }

    public int count(){
        return count;
    }

    public void delete(int index){
        if (index < 0 || index > count - 1) {
            System.out.println("Недопустимый интервал");
            return;
        }
        int lengthNewArray = values.length - 1;
        int[] newArray = new int[lengthNewArray];
        int[] firstArray = new int[index];
        System.arraycopy(values, 0, firstArray, 0, index);
        int[] lastArray = new int[count - index];
        System.arraycopy(values, index, lastArray, 0, count - index);
        System.arraycopy(firstArray, 0, newArray, 0, firstArray.length);
        System.arraycopy(lastArray, 1, newArray, firstArray.length, lastArray.length - 1);
        values = newArray;
        count--;
    }

    public void deleteAll(){
        int [] i = null;
        values = i;
        count = 0;
    }

    public int[] getValues(){
        return values;
    }

    public void printValues(){
        if (count > 0) {
            for (int i =0; i < count; i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println();
        }
        else System.out.println("Массив пуст");
    }
}
