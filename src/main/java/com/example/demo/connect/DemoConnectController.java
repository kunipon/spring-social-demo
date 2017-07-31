package com.example.demo.connect;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

@Controller
@RequestMapping("/connect")
public class DemoConnectController extends ConnectController {
	
	public DemoConnectController(ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository) {
		super(connectionFactoryLocator, connectionRepository);
	}
	
	@Override
	@RequestMapping(value="/{providerId}", method=RequestMethod.GET)
	public String connectionStatus(@PathVariable String providerId, NativeWebRequest request, Model model) {
		model.addAttribute("providerId", providerId);
		return super.connectionStatus(providerId, request, model);
	}
	
	@Override
	protected String connectedView(String providerId) {
		return "profile";
//		return "redirect:/profile/view?"+providerId+"connected";
	}
	
	@Override
	protected String connectView(String providerId) {
//		return "redirect:/profile/view?"+providerId+"connect";
		return "profile";
	}
}
