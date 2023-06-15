package com.iwu.ywuu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Scom {
    @TableId
    Integer scomid;
    String scomname;
    String scomintr;
    String scompho;
    Integer scomprice;
    Integer scomnum;
    String scomstate;
    Integer scommoq;
    Integer freight;
    Integer outbound;
}
