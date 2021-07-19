package com.lqz.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity(value = "android")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AndroidData {

    @Id
    private String id;


    private String icon;

    /**
     * 游戏简介
     */
    private String desc;

    /**
     * 下载链接
     */
    private String downloadUrl;

    /**
     * 开发公司
     */
    private String dev;

    /**
     * 发行公司
     */
   
    private String publisher;

    /**
     * 海报
     */
   
    private String poster;

    /**
     * 五图大
     */
   
    private List<String> screenB;

    /**
     * 五图小
     */
   
    private List<String> screenL;

    /**
     * 状态
     */
   
    private Integer status;

    /**
     * 排序
     */
   
    private Integer sort;

    /**
     *游戏类别
     */
   
    private String type;


    /**
     * 前三预览图
     */
   
    private String previewImage;


}

