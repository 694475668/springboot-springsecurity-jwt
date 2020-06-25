package com.ratta.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ******Title:<p> 程序的奥秘 </p> ******
 * ******Description:<p> </p>******
 * ******Company: <p> 雷塔智能科技有限公司 </p> ******
 *
 * @version :
 * @author: 刘 明
 * @date:Created in 2020/6/24 17:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenVO extends BaseVO {

    @ApiModelProperty(value = "令牌")
    private String token;
}
