package com.abbkit.tmp.spider.po;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author J
 * @since 2023-02-12
 */
@Getter
@Setter
  @Accessors(chain = true)
public class TDiseaseEntity  {

      /**
     * 传染病名称
     */
    private String name;

      /**
     * 传染病分类
     */
    private String category;


}
