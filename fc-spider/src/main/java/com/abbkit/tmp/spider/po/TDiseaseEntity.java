package com.abbkit.tmp.spider.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
  @TableName("t_disease")
public class TDiseaseEntity extends Model<TDiseaseEntity> {

      /**
     * 传染病名称
     */
      @TableField("`name`")
    private String name;

      /**
     * 传染病分类
     */
      @TableField("category")
    private String category;


    @Override
    public Serializable pkVal() {
          return null;
      }

}
