package net.java.seven.test.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.java.seven.test.db_service.CreditService;
import net.java.seven.test.models.Credit;
import net.java.seven.test.models.Payment;
import net.java.seven.test.utils.ModelFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class CreditLineController {

    @Autowired
    CreditService creditService;

    @RequestMapping(value = "/createCreditLine", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Credit> createClient(@RequestBody Credit credit) {

        credit.setOpenDate(System.currentTimeMillis());
        creditService.save(credit);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllCredits", params = {"id"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getAllClients(@RequestParam(value = "id", required = true, defaultValue = "") Long id, final Model model) {

        List<Credit> clients = creditService.getAllCreditByClientId(id);

        final ObjectMapper mapper = new ObjectMapper();

        String json = "";

        final HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put(ModelFields.CREDITS, clients);

        try {
            json = mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @RequestMapping(value = "/showPayments", method = RequestMethod.POST)
    public String showCreditLines(HttpServletRequest req, final Model model) {

        final long creditId = Long.valueOf(req.getParameter("id"));
        final int creditNumber = Integer.valueOf(req.getParameter("credit_number"));

        final Credit credit = creditService.getByID(creditId);
        model.addAttribute(ModelFields.PAYMENTS, getPayments(credit));
        model.addAttribute(ModelFields.CREDIT_NUMBER, creditNumber);

        return "payments";
    }

    /**
     * monthOffset - it's offset between two payments
     *
     * @param credit
     * @return
     */
    private List<Payment> getPayments(Credit credit) {
        final List<Payment> payments = new ArrayList<>();
        final long monthOffset = 2629746000L;
        final int defaultSumPayment = 1000;

        final long openDate = credit.getOpenDate();
        final long closeDate = credit.getCloseDate();

        final int paymentsSize = (int) ((closeDate - openDate) / monthOffset);

        for (int i = 0; i < paymentsSize; i++) {
            final Payment payment = new Payment();
            payment.setCreditId(credit.getId());
            payment.setSum(defaultSumPayment);

            final long paymentDate = openDate + (i + 1) * monthOffset;

            payment.setPaymentDate(getFormattedDate(paymentDate));

            payments.add(payment);
        }

        return payments;
    }

    private String getFormattedDate(long paymentDate) {
        final String DATE_FORMAT = "dd.MM.yyyy";
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        final Date date = new Date(paymentDate);

        return sdf.format(date);
    }

}
