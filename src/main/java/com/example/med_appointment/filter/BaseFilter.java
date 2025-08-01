package com.example.med_appointment.filter;

import com.example.med_appointment.entity.enums.SortType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
public class BaseFilter {
    private Integer size;
    private Integer page;
    private String searchKey;
    private SortType sortType;

    @JsonIgnore
    public int getStart(){
        return this.page * this.size;
    }

    @JsonIgnore
    public PageRequest getPageable(){
        return PageRequest.of(this.getPage(), this.getSize());
    }

    @JsonIgnore
    public String getSearchKey(){
        return StringUtils.isNoneEmpty(searchKey) ? "%" + searchKey.toLowerCase() + "%" : searchKey;
    }

}
