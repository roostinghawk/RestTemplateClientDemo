package com.edudigital.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 交易DTO
 * @author liuwei
 * @date 2019/10/15
 */
@Getter
@Setter
public class TransactionDTO {

    /**
     * 交易ID
     */
    private Long id;

    /**
     * 交易价格
     */
    private Double price;

    /**
     * 交易人
     */
    private String name;

    /**
     * 交易时间
     */
    private Date updateTime;

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("id" + id);
        builder.append(",price" + price);
        builder.append(",name" + name);
        builder.append(",updateTime" + updateTime);

        return builder.toString();
    }


}
