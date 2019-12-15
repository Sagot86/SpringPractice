package bean.scopes.controller;

import bean.scopes.beans.MyRequest;
import bean.scopes.service.MyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MyController {

    private MyRequest request;
    private MyService service;

    @GetMapping(value = "/scope/{param}")
    public int testSmth(@PathVariable("param") String param) throws InterruptedException {
        request.setParam(param);
        service.addRequest(request);
        return service.getSize();
    }
}
