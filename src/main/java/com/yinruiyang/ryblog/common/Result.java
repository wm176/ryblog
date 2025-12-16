package com.yinruiyang.ryblog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>{
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    public static Result<?> success() {
        return new Result<>(200, "Success", null);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(500, msg, null);
    }
}
