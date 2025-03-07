package com.codes_tech.delivery_manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codes_tech.delivery_manager.model.DeliveryMan;
import com.codes_tech.delivery_manager.repository.DeliveryManRepository;

@Controller
@RequestMapping("/panel/delivery-man")
public class DeliveryManController {

    private final DeliveryManRepository deliveryManRepository;

    public DeliveryManController(DeliveryManRepository deliveryManRepository) {
        this.deliveryManRepository = deliveryManRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listRender(Model model) {
        List<DeliveryMan> deliveryMen = deliveryManRepository.findAll();
        model.addAttribute("deliveryMen", deliveryMen);
        return "deliveryMan/index";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newRender(Model model) {
        model.addAttribute("deliveryMan", new DeliveryMan());
        return "deliveryMan/new";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String editRender(@PathVariable Long id, Model model) {
        Optional<DeliveryMan> deliveryMan = deliveryManRepository.findById(id);
        if (deliveryMan.isPresent()) {
            model.addAttribute("deliveryMan", deliveryMan.get());
            return "deliveryMan/edit";
        }
        return "redirect:/panel/delivery-man";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String insert(@ModelAttribute DeliveryMan deliveryMan) {
        deliveryManRepository.save(deliveryMan);
        return "redirect:/panel/delivery-man";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Long id, @ModelAttribute DeliveryMan deliveryMan) {
        Optional<DeliveryMan> existingDeliveryMan = deliveryManRepository.findById(id);
        
        if (existingDeliveryMan.isPresent()) {
            DeliveryMan updatedDeliveryMan = existingDeliveryMan.get();

            updatedDeliveryMan.setName(deliveryMan.getName());
            updatedDeliveryMan.setDocument(deliveryMan.getDocument());
            updatedDeliveryMan.setPhone(deliveryMan.getPhone());
            updatedDeliveryMan.setAddress(deliveryMan.getAddress());
            updatedDeliveryMan.setAddressCity(deliveryMan.getAddressCity());
            updatedDeliveryMan.setBirthday(deliveryMan.getBirthday());

            deliveryManRepository.save(updatedDeliveryMan);
        }
        return "redirect:/panel/delivery-man";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {
        deliveryManRepository.deleteById(id);
        return "redirect:/panel/delivery-man";
    }
}
