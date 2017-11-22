import com.seckin.utils.LambdaOps;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LambdaOps ops = new LambdaOps();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        ops.printList(numbers);
    }
}
