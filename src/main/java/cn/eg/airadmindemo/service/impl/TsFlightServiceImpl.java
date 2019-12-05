package cn.eg.airadmindemo.service.impl;

import cn.eg.airadmindemo.mapper.TsFlightMapper;
import cn.eg.airadmindemo.pojo.TsFlight;
import cn.eg.airadmindemo.service.TsFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TsFlightServiceImpl implements TsFlightService {
    @Autowired
    private TsFlightMapper tsFlightMapper;

    @Override
    public List<TsFlight> getFlight(String startCity, String endCity, String startTime) {
        List<TsFlight> tsFlight=tsFlightMapper.selFli(startCity,endCity,startTime);
        return tsFlight;
    }

}
