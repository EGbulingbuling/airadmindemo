package cn.eg.airadmindemo.mapper;

import cn.eg.airadmindemo.pojo.TsTakeperson;

public interface TsTakepersonMapper {
    int insTak(String PersonName,String IdNumber,String PersonPhone);

    int selTakId();

    TsTakeperson selTakById(String IdNumber);
}
