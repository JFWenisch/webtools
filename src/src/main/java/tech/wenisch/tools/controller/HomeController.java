package tech.wenisch.tools.controller;

import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import tech.wenisch.tools.util.ResponseManager;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class HomeController {

	@GetMapping("/")
	public String home(HttpServletRequest request, Model model) {
		
		model.addAttribute("title", "Home");
		model.addAttribute("description","Welcome to our free online tools page! Here, you'll find a variety of tools available for use without any restrictions. To get started, simply select one of the items on the left. Enjoy exploring and making the most of these resources! This application with all of its services  are open-source, ensuring transparency and community collaboration. You can find the source code on GitHub. If you find the project useful, I would greatly appreciate your support by giving it a star. Your feedback and contributions are always welcome!");
		return "index";
	}
	@GetMapping("/whatismyipaddress")	
	public String clientIPPage(HttpServletRequest request, Model model) {
		model.addAttribute("title", "What is my IP Address");
		model.addAttribute("description","When a client makes a request to the server, various headers are included in the request. These headers can contain valuable information about the client, such as their IP address. The service works by examining these headers to extract the client's IP address. One common header used for this purpose is the X-Forwarded-For header, which is often added by proxies or load balancers to indicate the original IP address of the client. If this header is not present, the service can fall back to using the RemoteAddr property of the request, which provides the IP address directly from the request.");

		Map<String, String> data = ResponseManager.getClientIPInformation(request);
		model.addAttribute("data", data);
		return "index";
	}
	
	@GetMapping("/whataremyclientheaders")	
	public String clientHeadersPage(HttpServletRequest request, Model model) 
	{
		model.addAttribute("title", "What are my client headers");
		model.addAttribute("description","Client headers are pieces of information sent by a user's browser to the server when making a request. These headers contain valuable details about the client's environment, such as the IP address, browser type, operating system, and more. By examining these headers, the server can gain insights into the client's setup and tailor responses accordingly.\r\n"
		+ "\r\n"
		+ "Our service displays these client headers, providing a transparent view of the information your browser shares with the server. This can be useful for debugging, security analysis, and understanding how your requests are processed.");
		Map<String, String> data = ResponseManager.getClientHeaderInformation(request);
		model.addAttribute("data",data);
		return "index";
	}
}
