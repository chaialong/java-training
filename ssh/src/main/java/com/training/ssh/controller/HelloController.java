package com.training.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ssh.vo.Loan;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public void hello(String msg, Loan loan, 	Model data) {
		System.out.println(msg);
		System.out.println(loan);
		data.addAttribute("msg", msg);
	}

}
