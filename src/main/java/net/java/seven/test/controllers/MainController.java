package net.java.seven.test.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.java.seven.test.db_service.ClientService;
import net.java.seven.test.db_service.CreditService;
import net.java.seven.test.models.Client;
import net.java.seven.test.utils.ModelFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MainController {

    public static final int LIMIT = 3;

    @Autowired
    ClientService clientService;

    @Autowired
    CreditService creditService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage(final Map<String, Object> model) {

        return "index";
    }

    @RequestMapping(value = "/getAllClients", params = {"page"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getAllClients(@RequestParam(value = "page", required = true, defaultValue = "") String page, final Model model) {

        int offset = Integer.valueOf(page) * LIMIT;
        List<Client> clients = getClients(offset, LIMIT);
        int limit = LIMIT;
        int size = clientService.getAllClientId().size();

        final ObjectMapper mapper = new ObjectMapper();

        String json = "";

        final HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put(ModelFields.OFFSET, offset);
        map.put(ModelFields.CLIENTS, clients);
        map.put(ModelFields.LIMIT, limit);
        map.put(ModelFields.SIZE, size);

        try {
            json = mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    private List<Client> getClients(final int offset, final int limit) {
        final List<Client> clients = clientService.getClientByOffset(offset, limit);

        for (Client client : clients) {
            client.setCountOpenedLine(creditService.getListOpenedLine(client.getId(), System.currentTimeMillis()).size());
            client.setCountClosedLine(creditService.getListClosedLine(client.getId(), System.currentTimeMillis()).size());
        }

        return clients;
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Client> createClient(@RequestBody Client client) {

        clientService.save(client);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public String editProfile(HttpServletRequest req, final Model model) {

        final long clientId = Long.valueOf(req.getParameter("id"));
        final Client client = clientService.getByID(clientId);
        model.addAttribute(ModelFields.CLIENT, client);

        return "edit_profile";
    }

    @RequestMapping(value = "/showCreditLines", method = RequestMethod.POST)
    public String showCreditLines(HttpServletRequest req, final Model model) {

        final long clientId = Long.valueOf(req.getParameter("id"));

        final Client client = clientService.getByID(clientId);
        model.addAttribute(ModelFields.CLIENT, client);

        return "credit_lines";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String updateClient(HttpServletRequest req) {

        final Client client = new Client();

        client.setId(Long.valueOf(req.getParameter("id")));
        client.setName(req.getParameter("name"));
        client.setSurname(req.getParameter("surname"));
        client.setAddress(req.getParameter("address"));
        client.setPhone(req.getParameter("phone"));

        clientService.save(client);

        return "index";
    }
}
