package com.settlement.dataharvester.domain.dto.report;

import com.settlement.dataharvester.domain.entity.PaymentMethod;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class DailyReportData {

    // 제목
    private String title;
    // 날짜
    private LocalDate date;
    // 총 수입
    private Long totalRevenue;
    // 결재 수단 별 수입
    private Map<PaymentMethod, Long> paymentBreakdown;
    // 세금
    private Long tax;
    // 수수료
    private Long charge;
    // 단위 시간 별 최대 판매 시간
    private LocalDateTime peekTime;



}
