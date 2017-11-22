package com.seckin.utils;

import java.util.List;
import java.util.function.Predicate;

public class LambdaOps {

    public void printList(List<Integer> numbers) {

        numbers.forEach(System.out::println);

        /*
        //another way to do it
        numbers.forEach(eleman -> System.out.println(eleman));
        //an old way to do it
        numbers.forEach(new Consumer<Integer>() {
            public void accept(Integer value) {
                System.out.println(value);
            }
        });
        */
    }


    public int sumWithPredicate(List<Integer> numbers, Predicate<Integer> predicate) {
        int total = 0;
        for (int number : numbers) {
            if (predicate.test(number)) {
                total += number;
            }
        }
        return total;
    }


    public void someComplicatedOpsWithStream(List<Integer> numbers){
        System.out.println(
                numbers.stream()
                        .filter(n->isEven(n))
                        .map(n-> doubleIt(n))
                        .filter(n->isGreaterThan5(n))
                        .findFirst()
        );



        //Lazy::MethodName does not work
        System.out.println(
                numbers.stream()
                        .filter(Lazy::isEven)
                        .map(Lazy::doubleIt)
                        .filter(Lazy::isGreaterThan5)
                        .findFirst()
        );

    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int doubleIt(int number) {
        return number * 2;
    }

    public boolean isGreaterThan5(int number) {
        return number > 5;
    }
}
