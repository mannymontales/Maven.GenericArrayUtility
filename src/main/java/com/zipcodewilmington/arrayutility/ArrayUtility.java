package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<Thing> {

    private Thing[] array;


    //Dont need to write methods that take in inputArray because this line of code
    //"ArrayUtility<Integer> arrayUtility = new ArrayUtility<Integer>(inputArray);"
    //so we create a constructor that creates a new generic instance with the given inputArray so we just write methods that manipulate
    //this new instance by calling this line of code arrayUtility.countDuplicatesInMerge(arrayToMerge, valueToEvaluate);
    public ArrayUtility(Thing[] inputArray) {
        this.array = inputArray;

    }

    public Integer countDuplicatesInMerge(Thing[] arrayToMerge, Thing valueToEvaluate) {
        List<Thing> inputArray = new ArrayList<>(Arrays.asList(this.array));
        List<Thing> merged = new ArrayList<>(Arrays.asList(arrayToMerge));
        //using this line below did not work because i tried to add two FIXED-SIZED arrays which threw an error
                //Arrays.asList(arrayToMerge);

        inputArray.addAll(merged);
        System.out.println(inputArray);

        int count = 0;
        for (Thing element: inputArray){
            if (element.equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public Thing getMostCommonFromMerge(Thing[] arrayToMerge){
        List<Thing> inputArray = new ArrayList<>(Arrays.asList(this.array));
        List<Thing> merged = new ArrayList<>(Arrays.asList(arrayToMerge));
        inputArray.addAll(merged);

        Thing commonElement = null;
        int maxCount = 0;

        //one for loop to compare the current element and the second for loop to compare it to the rest of the array
        //store the value after it is done comparing the array
        for (int i = 0; i < inputArray.size(); i++){

            int currentElementCount = 0;

            for (int j = 0; j < inputArray.size(); j++){
                if (inputArray.get(j).equals(inputArray.get(i))){
                    currentElementCount++;
                }
            }

            if (currentElementCount > maxCount){
                maxCount = currentElementCount;
                commonElement = inputArray.get(i);
            }
        }

        return commonElement;
    }

    public  Integer getNumberOfOccurrences(Thing valueToEvaluate){

        int count = 0;

        for (Thing element: this.array){
            if (element.equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public  Thing[] removeValue(Thing valueToRemove){

        List<Thing> newArr = new ArrayList<>(Arrays.asList(this.array));
        // Create an Object[] of the same size as the list

        //https://rollbar.com/blog/java-concurrentmodificationexception/#:~:text=The%20above%20exception%20can%20also,a%20given%20condition%20is%20true.
        //Since the enhanced for loop uses an Iterator internally to traverse elements in a Collection,
        // running the above code causes a ConcurrentModificationException since the remove() method of the Collection is used instead of the iterator:

        for (int i = 0; i < newArr.size(); i++){
            if (newArr.get(i).equals(valueToRemove)){
                newArr.remove(i);
            }
        }

        Thing[] tempArr = (Thing[]) newArr.toArray();
                tempArr = (Thing[]) Array.newInstance(newArr.getClass(), newArr.size());
        //do this method with out collection only use array and newInstance and getClass
        //research type erasure
        Thing[] arr = (Thing[]) tempArr;
        return tempArr;
    }


//    public static <Thing> Thing[] countDuplicatesInMerge(List<Thing> list){
//        Thing[] array = list.toArray(new Thing[0]);
//        return
//                array;
//    }
}
