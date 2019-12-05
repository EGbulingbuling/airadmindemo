package cn.eg.airadmindemo.controller;

import cn.eg.airadmindemo.pojo.TicketInfo;
import cn.eg.airadmindemo.pojo.TsFlight;
import cn.eg.airadmindemo.service.TsShowMyTicketService;
import cn.eg.airadmindemo.service.impl.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TsFlightController {
    @Autowired
    private TsFlightServiceImpl tsFlightService;
    @Autowired
    private TsBuyTicketServiceImpl tsBuyTicketService;
    @Autowired
    private TsShowMyTicketService tsShowMyTicketService;
    @Autowired
    private TsUndoTicketServiceImpl tsUndoTicketService;

    @RequestMapping("/getFlight")
    @ResponseBody
    public String getFlight(HttpServletRequest request){
        String startCity=request.getParameter("startCity");
        String endCity=request.getParameter("endCity");
        String startTime=request.getParameter("startTime");

        List<TsFlight> tsFlight=tsFlightService.getFlight(startCity,endCity,startTime);

        String tsFlightStr=JSON.toJSONString(tsFlight);
        return tsFlightStr;
    }

    @RequestMapping("/buyTicket")
    @ResponseBody
    public String buyTicket(HttpServletRequest request){
        String flightId=request.getParameter("flightId");
        String PersonName= request.getParameter("PersonName");
        String PersonId= request.getParameter("PersonId");
        String PersonPhone= request.getParameter("PersonPhone");

        boolean isBuy=tsBuyTicketService.buyTicket(Integer.parseInt(flightId),PersonName,PersonId,PersonPhone);

        if (isBuy){
            return "1";
        }else {
            return "0";
        }
    }

    @RequestMapping("/showMyTickets")
    @ResponseBody
    public String showMyTickets(HttpSession session){
        List<TicketInfo> ticketInfos=tsShowMyTicketService.showTicketInfo();
        String ticketInfoStr=JSON.toJSONString(ticketInfos);
        return ticketInfoStr;
    }

    @RequestMapping("/undoTicket")
    @ResponseBody
    public String undoTicket(HttpServletRequest request){
        String ticketId=request.getParameter("ticketId");
        boolean isUndo=tsUndoTicketService.undoTicket(Integer.parseInt(ticketId));
        if (isUndo){
            return "1";
        }else {
            return "0";
        }
    }

}
