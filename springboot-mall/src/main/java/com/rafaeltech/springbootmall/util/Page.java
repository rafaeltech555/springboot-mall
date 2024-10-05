package com.rafaeltech.springbootmall.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Page<T> {

    private Integer limit;
    private Integer offset;
    private Integer total;
    private List<T> results;
}
