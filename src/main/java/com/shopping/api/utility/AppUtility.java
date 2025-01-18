package com.shopping.api.utility;

import com.shopping.api.exception.RecordNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppUtility {


    public static <T, R> List<R> parseList(List<T> list, Function<T, R> parseFunction) {
        if (list == null || list.isEmpty()) {
            throw new RecordNotFoundException("No Records found");
        } else {
            return list.stream().map(parseFunction).toList();
        }
    }

}
