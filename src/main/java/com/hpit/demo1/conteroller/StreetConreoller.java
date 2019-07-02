package com.hpit.demo1.conteroller;

import com.hpit.demo1.entity.Street;
import com.hpit.demo1.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ko/")
public class StreetConreoller {
    @Autowired
    private StreetService streetService;
    @RequestMapping("getMoeld")
    @ResponseBody
    public List<Street> getMoeld(Integer did){
        return   streetService.getMoeld(did);
    }
}
