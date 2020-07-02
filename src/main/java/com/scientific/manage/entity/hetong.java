package com.scientific.manage.entity;

import lombok.Data;

//合同
@Data
public class hetong {

    //合同ID
    private String htid;

    //合同标题
    private String htbt;

    //合同编号
    private String htbh;

    //合同内容
    private String htnr;

    //起草时间
    private String qcsj;

    //起草人
    private String qcr;

    //甲方
    private String jf;

    //甲方联系方式
    private String jflxfs;

    //乙方
    private String yf;

    //乙方联系方式
    private String yflxfs;

    //状态
    private String zt;

    //附件
    private String fj;

}
