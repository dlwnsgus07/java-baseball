package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputNumberList {
    public List<Number> userInputNumberList;

    public UserInputNumberList(String input) {
        userInputNumberList = verificationDuplicateNumbers(input);
    }

    private List<Number> verificationDuplicateNumbers(String input) {
        List<Number> inputList = Arrays.stream(input.split(""))
                .map(Number::new)
                .collect(Collectors.toList());
        List<Number> nonRedundantInputList = inputList.stream().distinct().collect(Collectors.toList());
        if (inputList.size() != nonRedundantInputList.size()) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        } else if (inputList.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        } else {
            return inputList;
        }
    }
}
