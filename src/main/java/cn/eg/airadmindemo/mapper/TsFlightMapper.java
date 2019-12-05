package cn.eg.airadmindemo.mapper;

import cn.eg.airadmindemo.pojo.TsFlight;

import java.util.List;

public interface TsFlightMapper {
    List<TsFlight> selFli(String startCity, String endCity, String startTime);

    int updFliForBuy(int flightId);

    int udpFliForUndo(int flightId);
}
