package cn.eg.airadmindemo.service;

import cn.eg.airadmindemo.pojo.TsFlight;

import java.util.List;

public interface TsFlightService {
    List<TsFlight> getFlight(String startCity, String endCity, String startTime);

}
