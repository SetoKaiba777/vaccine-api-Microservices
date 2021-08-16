package com.kaibacorp.vaccineapi.Api.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {
    private Integer status;
    private OffsetTime dateHour;
    private String title;
    private List<Field> fields;

    @Getter
    @Setter
    public static class Field{
        private String name;
        private String msg;

        public Field(String name, String msg){
            super();
            this.name=name;
            this.msg=msg;
        }
    }
}
